package pro.sky.homework4;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeExistsException extends RuntimeException    {

    public EmployeeExistsException(String message) {
        super(message);
    }
}
