package fr.hb.lacentrale.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AlreadyActiveException extends RuntimeException {

    public AlreadyActiveException(String message) {
        super(message);
    }

}
