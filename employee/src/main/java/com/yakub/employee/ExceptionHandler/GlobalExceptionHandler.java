package com.yakub.employee.ExceptionHandler;

import com.yakub.employee.Error.APIError;
import com.yakub.employee.Exceptions.NoDataToShowException;
import com.yakub.employee.Exceptions.NotAbleToUpdateRecordException;
import com.yakub.employee.Exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoDataToShowException.class)
    public ResponseEntity<APIError> handleNoDataToShowException(NoDataToShowException exc){
        APIError error = APIError.builder().status(HttpStatus.NO_CONTENT).message(exc.getMessage()).timeStamp(LocalDateTime.now()).build();
        return new ResponseEntity<>(error,HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NotAbleToUpdateRecordException.class)
    public ResponseEntity<APIError> handleNotAbleToUpdateRecordException(NotAbleToUpdateRecordException exc){
        APIError error = APIError.builder().status(HttpStatus.NOT_MODIFIED).message(exc.getMessage()).timeStamp(LocalDateTime.now()).build();
        return new ResponseEntity<>(error,HttpStatus.NOT_MODIFIED);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIError> handleResourceNotFoundException(ResourceNotFoundException exc){
        APIError error = APIError.builder().status(HttpStatus.NOT_FOUND).message(exc.getMessage()).timeStamp(LocalDateTime.now()).build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    
}
