package com.buddhist.daily.utils;

import com.buddhist.daily.dto.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangyulin on 14/11/2017.
 */
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Msg handleServiceException(HttpServletRequest request, BusinessException exception) {
        log.error(exception.getMessage(), exception);
        Msg msg = new Msg();
        return msg.withError(exception.getMessage());
    }

}
