package org.example.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.example.dao.UserDoMapper;
import org.example.dao.UserPasswordDoMapper;
import org.example.dataobject.UserDo;
import org.example.dataobject.UserPasswordDo;
import org.example.error.BussinessException;
import org.example.error.EmBussinessError;
import org.example.service.UserService;
import org.example.service.model.UserModel;
import org.example.validator.ValidationResult;
import org.example.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDoMapper userDoMapper;

    @Autowired
    private UserPasswordDoMapper userPasswordDoMapper;

    @Autowired
    private ValidatorImpl validator;

    @Override
    public UserModel getUserById(Integer id) {
        // 调用userDaoMapper
        UserDo userDo = userDoMapper.selectByPrimaryKey(id);
        if (userDo == null) {
            //System.out.println("null");
            return null;
        }
        UserPasswordDo userPasswordDo = userPasswordDoMapper.selectByUserId(userDo.getId());

        return convertFromDataObject(userDo, userPasswordDo);

    }

    private UserModel convertFromDataObject(UserDo userDo, UserPasswordDo userPasswordDo) {
        if (userDo == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDo, userModel);
        if (userPasswordDo != null) {
            userModel.setEncrptPassword(userPasswordDo.getEncrptPassword());
        }
        return userModel;
    }

    @Override
    @Transactional
    public void register(UserModel userModel) throws BussinessException {
        if (userModel == null) {
            throw new BussinessException(EmBussinessError.PARAMETER_VALISATION_ERROR);
        }
//        if (StringUtils.isNotEmpty(userModel.getName())
//                || StringUtils.isNotEmpty(userModel.getTelephone())
//                || userModel.getAge() == null
//                || userModel.getGender() == null) {
//            throw new BussinessException(EmBussinessError.PARAMETER_VALISATION_ERROR);
//        }

        ValidationResult result = validator.validate(userModel);
        if (result.isHasErrors()) {
            throw new BussinessException(EmBussinessError.PARAMETER_VALISATION_ERROR, result.getErrMsg());
        }
        UserDo userDo = convertFromModel(userModel);
        userDoMapper.insertSelective(userDo);
        userModel.setId(userDo.getId());
        UserPasswordDo userPasswordDo = convertPassowrdFromModel(userModel);
        userPasswordDoMapper.insertSelective(userPasswordDo);
        return;
    }

    private UserPasswordDo convertPassowrdFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserPasswordDo userPasswordDo = new UserPasswordDo();
        userPasswordDo.setEncrptPassword(userModel.getEncrptPassword());
        userPasswordDo.setUserId(userModel.getId());
        return userPasswordDo;
    }

    private UserDo convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(userModel, userDo);
        return userDo;
    }

    @Override
    public UserModel validateLogin(String telephone, String encrptPassword) throws BussinessException {
        //通过用户的手机获取用户信息
        UserDo userDO = userDoMapper.selectByTelephone(telephone);
        if (userDO == null) {
            throw new BussinessException(EmBussinessError.USER_LOGIN_FAIL);
        }
        UserPasswordDo userPasswordDo = userPasswordDoMapper.selectByUserId(userDO.getId());
        UserModel userModel = convertFromDataObject(userDO, userPasswordDo);

        //比对用户信息内加密的密码是否和传输进来的密码相匹配
        if (!StringUtils.equals(encrptPassword, userModel.getEncrptPassword())) {
            throw new BussinessException(EmBussinessError.USER_LOGIN_FAIL);
        }
        return userModel;
    }
}
