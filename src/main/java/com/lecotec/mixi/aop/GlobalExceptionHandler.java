package com.lecotec.mixi.aop;

import com.lecotec.mixi.model.response.FailResponse;
import com.lecotec.mixi.model.response.ResponseObject;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseObject allExceptionHandler(Exception exception, HttpServletResponse response) {
        if (exception instanceof MethodArgumentNotValidException) {
            response.setStatus(400);
            Set<String> errorMessages = new HashSet<>();
            List<ObjectError> allErrors = ((MethodArgumentNotValidException) exception).getBindingResult().getAllErrors();
            for (ObjectError error : allErrors) {
                errorMessages.add(error.getDefaultMessage());
            }
            return new FailResponse(errorMessages);
        }
        response.setStatus(500);
        return new FailResponse(exception.getLocalizedMessage());
    }
}