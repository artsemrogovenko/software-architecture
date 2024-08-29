package ru.geekbrains.mpaExample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleNoHandlerFoundException(NoHandlerFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("404"); // имя вашей HTML страницы
        modelAndView.addObject("message", "Страница не найдена!");
        return modelAndView;
    }
}