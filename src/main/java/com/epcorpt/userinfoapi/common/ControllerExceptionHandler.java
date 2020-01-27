package com.epcorpt.userinfoapi.common;

import com.epcorpt.userinfoapi.constant.UserInfoConstant;
import com.epcorpt.userinfoapi.model.UserInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.epcorpt.userinfoapi.constant.UserInfoConstant.STATUS_ERROR;

@Slf4j
@RestController
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<UserInfoResponse> exception(Exception ex) {
        log.error("Exception occurred, ", ex);
        return ResponseEntity.ok(new UserInfoResponse(STATUS_ERROR, UserInfoConstant.INTERNAL_SERVER_ERROR_PLS_TRY_AGAIN));
    }

    @ExceptionHandler(UserInfoException.class)
    public ResponseEntity<UserInfoResponse> userInfoException(UserInfoException ex) {
        return ResponseEntity
                .ok(new UserInfoResponse(ex.getStatusCode(), ex.getStatusDesc()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ObjectError objectError = ex.getBindingResult().getAllErrors().get(0);
        return ResponseEntity.ok(new UserInfoResponse(STATUS_ERROR, objectError.getDefaultMessage()));
    }
}
