package org.example.service;

import org.example.error.BussinessException;
import org.example.service.model.UserModel;

public interface UserService {

    public UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BussinessException;
}
