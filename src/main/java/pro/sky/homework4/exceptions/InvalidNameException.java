package pro.sky.homework4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNameException  extends RuntimeException{
    public InvalidNameException(String message) {
        super(message);
    }
}
