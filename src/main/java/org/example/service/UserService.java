package org.example.service;

import org.example.error.BussinessException;
import org.example.service.model.UserModel;

public interface UserService {

    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BussinessException;

    UserModel validateLogin(String telphone, String encrptPassword) throws BussinessException;
}
