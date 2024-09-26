package fr.hb.lacentrale.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExpiredCodeException extends RuntimeException{

    public ExpiredCodeException(String message) {
        super(message);
    }

}
