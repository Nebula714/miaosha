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

    @Override
    public UserModel getUserById(Integer id){
        // 调用userDaoMapper
        UserDo userDo=userDoMapper.selectByPrimaryKey(id);
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
        if (StringUtils.isNotEmpty(userModel.getName())
                || StringUtils.isNotEmpty(userModel.getTelephone())
                || userModel.getAge() == null
                || userModel.getGender() == null) {
            throw new BussinessException(EmBussinessError.PARAMETER_VALISATION_ERROR);
        }
        UserDo userDo = convertFromModel(userModel);
        userDoMapper.insertSelective(userDo);
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
        BeanUtils.copyProperties(userDo, userModel);
        return userDo;
    }
}
