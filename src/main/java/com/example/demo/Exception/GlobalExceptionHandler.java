package com.example.demo.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice // with the help of this below class is able to handle Exceptions Globally
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override // when Json value is binded to the model object when exception is thrown the below mtd is executed.
    // we are customising the http response
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", System.currentTimeMillis());
        body.put("status", status.value());

        //to get all the errors we use list
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x-> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);
        return new ResponseEntity<Object>(body, status);
    }


}
