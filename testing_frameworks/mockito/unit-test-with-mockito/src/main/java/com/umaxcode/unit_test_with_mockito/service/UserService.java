package com.umaxcode.unit_test_with_mockito.service;

import com.umaxcode.unit_test_with_mockito.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel addUser(UserModel user) throws Exception;

    UserModel getUser(String email) throws Exception;

    List<UserModel> getAllUsers();
}
