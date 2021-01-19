package com.cos.movieApp.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateReqDto {
	@NotNull(message = "영화 제목이 없습니다.")
	private String title;
	
	@NotNull(message = "평점이 없습니다.")
	private double rating;
}
