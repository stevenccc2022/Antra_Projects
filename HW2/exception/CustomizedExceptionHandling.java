package HW2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    public ResponseEntity<?> handleException (EmployeeNotFoundException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDataTime(LocalDateTime.now());
        response.setMessage("Target File Not Found");
        ResponseEntity<?> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
}
