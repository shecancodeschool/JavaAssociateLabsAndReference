package com.umaxcode.unit_test_with_mockito.repository;

import com.umaxcode.unit_test_with_mockito.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepository {


    UserModel add(UserModel user) throws Exception;

    Optional<UserModel> findByEmail(String email) throws Exception;

    List<UserModel> findAll();
}
