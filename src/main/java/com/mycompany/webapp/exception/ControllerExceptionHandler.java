package com.mycompany.webapp.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
	@ExceptionHandler
	public String handleCh16NotFoundAccountException(NotFoundAccountException e, Model model) {
		log.info("실행");
		e.printStackTrace();
		model.addAttribute("error", e.getMessage());
		return "notFoundAccountException";
	}
}
