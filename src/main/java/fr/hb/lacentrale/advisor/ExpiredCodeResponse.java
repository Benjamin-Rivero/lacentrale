package fr.hb.lacentrale.advisor;

import fr.hb.lacentrale.exceptions.AlreadyActiveException;
import fr.hb.lacentrale.exceptions.ExpiredCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExpiredCodeResponse {

    @ResponseBody
    @ExceptionHandler(ExpiredCodeException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    CustomResponse alreadyActiveHandler(ExpiredCodeException exception){
        CustomResponse response = new CustomResponse();
        response.setStatus(HttpStatus.BAD_GATEWAY.value());
        response.setMessage(exception.getMessage());
        return response;
    }

}
