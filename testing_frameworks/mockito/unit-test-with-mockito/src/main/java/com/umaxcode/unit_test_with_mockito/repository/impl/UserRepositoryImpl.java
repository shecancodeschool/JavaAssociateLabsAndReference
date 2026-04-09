package com.umaxcode.unit_test_with_mockito.repository.impl;

import com.umaxcode.unit_test_with_mockito.model.UserModel;
import com.umaxcode.unit_test_with_mockito.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<UserModel> users;

    public UserRepositoryImpl() {
        users = new ArrayList<>();
    }

    @Override
    public UserModel add(UserModel user) throws Exception {

        Optional<UserModel> optionalUser = getUserByEmail(user.getEmail());

        if (optionalUser.isEmpty()) {
            users.add(user);
            return user;
        }

        throw new Exception("User already exist");
    }

    @Override
    public Optional<UserModel> findByEmail(String email) throws Exception {

        return Optional.ofNullable(getUserByEmail(email)
                .orElseThrow(() -> new Exception("User not found")));
    }

    @Override
    public List<UserModel> findAll() {
        return users;
    }


    private Optional<UserModel> getUserByEmail(String email) {
        return users.stream().
                filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
}
