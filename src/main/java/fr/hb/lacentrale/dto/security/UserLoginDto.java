package fr.hb.lacentrale.dto.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {

    private String username;

    private String password;

}