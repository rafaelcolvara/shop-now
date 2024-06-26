package com.shopnow.orderms.conf;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<Object> handleResourceNotFoundGlobal(RuntimeException exception) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "Exception error");
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<Object> handleRecourceAccessException(ResourceAccessException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "Resource Access error");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> handleDataAccessException(DataAccessException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "Database error");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllergalArgumentException(IllegalAccessException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "Illegal Argument error");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
