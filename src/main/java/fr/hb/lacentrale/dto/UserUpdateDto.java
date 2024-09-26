package fr.hb.lacentrale.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    private String password;

    private String phone;

    private String photo;

}