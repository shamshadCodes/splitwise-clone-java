package com.shamshad.splitwiseclone.Commands;

import com.shamshad.splitwiseclone.controllers.UserController;
import com.shamshad.splitwiseclone.dtos.RegisterUserRequestDTO;
import com.shamshad.splitwiseclone.dtos.RegisterUserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RegisterNewUserCommand implements Command{
//    Sample Command
//    Register vinsmokesanji 003 namisswwaann
//    u1 is registering with the username "vinsmokesanji", phone "003" and password as "namisswwaann"

    UserController userController;

    @Autowired
    public RegisterNewUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean matches(String input) {
        //TODO: Apply a check for leading zeroes or more than one zero between words
        List<String> inputKeywords = Arrays.stream(input.split(" ")).toList();

        return inputKeywords.size() == 4 && inputKeywords.get(0).equalsIgnoreCase(CommandKeywords.REGISTER_NEW_USER);
    }

    @Override
    public void execute(String input) {
        //TODO: Apply a check for leading zeroes or more than one zero between words
        List<String> inputKeywords = Arrays.stream(input.split(" ")).toList();

        String username = inputKeywords.get(1);
        String phoneNumber = inputKeywords.get(2);
        String password = inputKeywords.get(3);

        RegisterUserRequestDTO requestDTO = new RegisterUserRequestDTO();
        requestDTO.setUsername(username);
        requestDTO.setPhoneNumber(phoneNumber);
        requestDTO.setPassword(password);

        RegisterUserResponseDTO responseDTO = userController.registerUser(requestDTO);

        if(responseDTO.getStatus().equals("SUCCESS")){
            System.out.printf("User with user id: %s created\n", responseDTO.getUserId());
        }
        else {
            System.out.println(responseDTO.getMessage());
        }

    }
}
