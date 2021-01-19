package com.cos.movieApp.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movieApp.domain.CommonDto;

@RestController
@ControllerAdvice

public class MyExceptionHandler {
	
	@ExceptionHandler(value=IllegalArgumentException.class)
	public CommonDto 요청잘못(IllegalArgumentException e){
		return new CommonDto(500, "fail");
		}
}
