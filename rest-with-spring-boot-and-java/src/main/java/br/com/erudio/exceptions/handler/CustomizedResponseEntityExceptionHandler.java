package br.com.erudio.exceptions.handler;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.exceptions.exceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice //para concentrar um tratamento em apenas um controler. Tratamento Global
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<exceptionResponse> handleAllExceptions(
            Exception ex, WebRequest request){
        exceptionResponse ExceptionResponse = new exceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(ExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<exceptionResponse> handleBadRequestExceptions(
            Exception ex, WebRequest request){
        exceptionResponse ExceptionResponse = new exceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(ExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
