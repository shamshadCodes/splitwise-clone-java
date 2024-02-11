package com.shamshad.splitwiseclone.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDTO {
    private long userId;
    private String status;
    private String message;
}
