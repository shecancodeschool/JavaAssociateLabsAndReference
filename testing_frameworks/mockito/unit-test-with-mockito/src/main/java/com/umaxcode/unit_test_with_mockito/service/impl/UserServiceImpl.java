package com.umaxcode.unit_test_with_mockito.service.impl;

import com.umaxcode.unit_test_with_mockito.model.UserModel;
import com.umaxcode.unit_test_with_mockito.repository.UserRepository;
import com.umaxcode.unit_test_with_mockito.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel addUser(UserModel user) throws Exception {

        return userRepository.add(user);
    }

    @Override
    public UserModel getUser(String email) throws Exception {
        return userRepository.findByEmail(email)
                .orElseThrow();
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
}
