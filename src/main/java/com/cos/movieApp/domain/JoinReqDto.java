package com.cos.movieApp.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class JoinReqDto {
	@NotBlank(message = "영화 제목이 없습니다.")
	@NotNull(message = "영화 제목이 없습니다.")
	private String title;
	
	@NotNull(message = "평점이 없습니다.")
	private double rating;
}
