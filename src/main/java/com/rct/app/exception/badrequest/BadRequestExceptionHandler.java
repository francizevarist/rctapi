package com.rct.app.exception.badrequest;

import com.rct.app.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.rct.app.util.TimeManager;

@ControllerAdvice
public class BadRequestExceptionHandler {
    @ExceptionHandler(value={ApiBadRequestException.class})
    public ResponseEntity<Object> handleApiException(ApiBadRequestException e){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiException apiException =
                        new ApiException(e.getMessage(),
                        httpStatus,
                        TimeManager.timeStampToDateAndTimeExtended(TimeManager.currentTimeStamp()));
        return new ResponseEntity<>(apiException,httpStatus);
    }
}
