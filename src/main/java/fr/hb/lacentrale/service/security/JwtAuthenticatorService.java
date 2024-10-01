package fr.hb.lacentrale.service.security;

import fr.hb.lacentrale.custom_response.JwtResponse;
import fr.hb.lacentrale.dto.security.UserLoginDto;
import fr.hb.lacentrale.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JwtAuthenticatorService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public ResponseEntity<JwtResponse> authenticate(UserLoginDto userLoginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userLoginDto.getUsername(),
                            userLoginDto.getPassword()
                    )
            );

            String token = jwtService.generateToken(userLoginDto.getUsername());
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
