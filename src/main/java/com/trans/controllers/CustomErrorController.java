package com.trans.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomErrorController {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/error/400"); // Имя вашего шаблона 400.html без расширения
        mav.addObject("id", ex.getParameterName());
        return mav;
    }
}
