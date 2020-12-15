package com.rct.app.exception.forbidden;

import com.rct.app.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.rct.app.util.TimeManager;

@ControllerAdvice
public class ForbiddenExceptionHandler {
    @ExceptionHandler(value={ApiForbiddenException.class})
    public ResponseEntity<Object> handleApiException(ApiForbiddenException e){
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        ApiException apiException =
                new ApiException(e.getMessage(),
                        httpStatus,
                        TimeManager.timeStampToDateAndTimeExtended(TimeManager.currentTimeStamp()));
        return new ResponseEntity<>(apiException,httpStatus);
    }
}