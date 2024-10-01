package fr.hb.lacentrale.controller.security;

import fr.hb.lacentrale.custom_response.JwtResponse;
import fr.hb.lacentrale.dto.UserCreateDto;
import fr.hb.lacentrale.dto.security.UserLoginDto;
import fr.hb.lacentrale.entity.User;
import fr.hb.lacentrale.service.UserService;
import fr.hb.lacentrale.service.security.JwtAuthenticatorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class SecurityController {


    private final UserService userService;
    private JwtAuthenticatorService jwtAuthenticatorService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserLoginDto userLoginDto){
        return jwtAuthenticatorService.authenticate(userLoginDto);
    }

    @PostMapping("/register")
    public User register(@RequestBody UserCreateDto userCreateDto){
        return userService.create(userCreateDto);
    }

}