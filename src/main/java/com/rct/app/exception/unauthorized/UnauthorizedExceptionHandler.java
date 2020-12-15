package com.rct.app.exception.unauthorized;

import com.rct.app.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.rct.app.util.TimeManager;

@ControllerAdvice
public class UnauthorizedExceptionHandler {
    @ExceptionHandler(value={ApiUnauthorizedException.class})
    public ResponseEntity<Object> handleApiException(ApiUnauthorizedException e){
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        ApiException apiException =
                new ApiException(e.getMessage(),
                        httpStatus,
                        TimeManager.timeStampToDateAndTimeExtended(TimeManager.currentTimeStamp()));
        return new ResponseEntity<>(apiException,httpStatus);
    }
}
