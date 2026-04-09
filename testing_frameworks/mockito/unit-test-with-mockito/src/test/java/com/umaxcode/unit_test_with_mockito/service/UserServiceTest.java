package com.umaxcode.unit_test_with_mockito.service;

import com.umaxcode.unit_test_with_mockito.model.UserModel;
import com.umaxcode.unit_test_with_mockito.repository.UserRepository;
import com.umaxcode.unit_test_with_mockito.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void addUser_shouldCreateANewUser() throws Exception {

        UserModel mockUserModel = new UserModel("firstname",
                "lastname", "example@gmail.com");

        when(userRepository.add(any(UserModel.class))).thenReturn(mockUserModel);

        UserModel userModelResponse = userService.addUser(mockUserModel);

        assertEquals("firstname", userModelResponse.getFirstName());
        assertEquals("lastname", userModelResponse.getLastName());
        assertEquals("example@gmail.com", userModelResponse.getEmail());

        ArgumentCaptor<UserModel> userModelCaptor = ArgumentCaptor.forClass(UserModel.class);
        verify(userRepository).add(userModelCaptor.capture());
        UserModel capturedUserModel = userModelCaptor.getValue();
        assertEquals("firstname", capturedUserModel.getFirstName());
        assertEquals("lastname", capturedUserModel.getLastName());
        assertEquals("example@gmail.com", capturedUserModel.getEmail());

        verify(userRepository, times(1)).add(any(UserModel.class));
    }

    @Test
    void getUser() {
    }

    @Test
    void getAllUsers() {
    }
}