package com.example.springsecuritymasterfilters.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(Throwable.class)
    public ModelAndView exceptionHandler(Throwable th)throws Throwable{
        ModelAndView mv=new ModelAndView();
        mv.addObject("cause",th.getCause().getMessage());
        mv.addObject("message",th.getMessage());
        mv.setViewName("errorPage");
        return mv;
    }
}
