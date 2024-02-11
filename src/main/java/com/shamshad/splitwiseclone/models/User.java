package com.shamshad.splitwiseclone.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel{
    private String username;
    private String password;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @ManyToMany
    private List<Group> groups;
}
