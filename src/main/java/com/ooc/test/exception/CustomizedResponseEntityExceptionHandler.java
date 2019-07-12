package com.ooc.test.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){

        HttpHeaders headers = new HeaderResponse().addAll(
                LocalDateTime.now(),
                "FAIL",
                ex.getMessage(),
                ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).build();

    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request){

        HttpHeaders headers = new HeaderResponse().addAll(
                LocalDateTime.now(),
                "FAIL",
                ex.getMessage(),
                ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
        );


        return ResponseEntity.notFound().headers(headers).build();
    }


    // @Validate For Validating Path Variables and Request Parameters
    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request){

        HttpHeaders header = new HeaderResponse().addAll(
                LocalDateTime.now(),
                "FAIL",
                Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage(),
                ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).build();
    }
}
