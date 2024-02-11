package com.shamshad.splitwiseclone.controllers;

import com.shamshad.splitwiseclone.dtos.RegisterUserRequestDTO;
import com.shamshad.splitwiseclone.dtos.RegisterUserResponseDTO;
import com.shamshad.splitwiseclone.exceptions.UserAlreadyExistsException;
import com.shamshad.splitwiseclone.models.User;
import com.shamshad.splitwiseclone.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO requestDTO){
        RegisterUserResponseDTO responseDTO = new RegisterUserResponseDTO();
        try{
            User user = userService.registerUser(requestDTO.getUsername(), requestDTO.getPhoneNumber(), requestDTO.getPassword());
            responseDTO.setStatus("SUCCESS");
            responseDTO.setUserId(user.getId());
        }
        catch (UserAlreadyExistsException exception){
            responseDTO.setMessage(exception.getMessage());
            responseDTO.setStatus("FAILURE");
        }
        return responseDTO;
    }
}
