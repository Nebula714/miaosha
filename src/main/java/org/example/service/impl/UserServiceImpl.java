package org.example.service.impl;

import org.example.dao.UserDoMapper;
import org.example.dao.UserPasswordDoMapper;
import org.example.dataobject.UserDo;
import org.example.dataobject.UserPasswordDo;
import org.example.service.UserService;
import org.example.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(userDo==null){
            //System.out.println("null");
            return null;
        }
        UserPasswordDo userPasswordDo =userPasswordDoMapper.selectByUserId(userDo.getId());

        return convertFromDataObject(userDo,userPasswordDo);

    }

    private UserModel convertFromDataObject(UserDo userDo, UserPasswordDo userPasswordDo){
        if(userDo==null){
            return null;
        }
        UserModel userModel=new UserModel();
        BeanUtils.copyProperties(userDo,userModel);
        if(userPasswordDo!=null){
            userModel.setEncrptPassword(userPasswordDo.getEncrptPassword());
        }
        return userModel;
    }
}
