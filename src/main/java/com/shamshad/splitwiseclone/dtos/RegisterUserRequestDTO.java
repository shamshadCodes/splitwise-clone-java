package com.shamshad.splitwiseclone.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDTO {
    private String username;
    private String phoneNumber;
    private String password;
}
