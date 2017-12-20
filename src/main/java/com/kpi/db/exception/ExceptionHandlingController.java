package com.kpi.db.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(Exception.class)
    public String conflict(Model model,Exception ex){
        model.addAttribute("message",ex.getMessage());
        return "/exception";
    }
}
