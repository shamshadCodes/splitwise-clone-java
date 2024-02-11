package com.shamshad.splitwiseclone.services;

import com.shamshad.splitwiseclone.exceptions.UserAlreadyExistsException;
import com.shamshad.splitwiseclone.models.User;
import com.shamshad.splitwiseclone.models.UserStatus;
import com.shamshad.splitwiseclone.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String username, String phoneNumber, String password) throws UserAlreadyExistsException {
        Optional<User> optionalUser = userRepository.findByPhoneNumber(phoneNumber);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(user.getUserStatus().equals(UserStatus.REGISTERED)){
                throw new UserAlreadyExistsException("This phone number is already registered!");
            }
            else{
                user.setUsername(username);
                user.setPassword(password);
                user.setUserStatus(UserStatus.REGISTERED);
                userRepository.save(user);
            }
            return user;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setUserStatus(UserStatus.REGISTERED);
        userRepository.save(user);
        return user;
    }
}
