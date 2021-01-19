package com.cos.movieApp.web;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movieApp.domain.CommonDto;
import com.cos.movieApp.domain.JoinReqDto;
import com.cos.movieApp.domain.MovieRepository;
import com.cos.movieApp.domain.UpdateReqDto;
import com.cos.movieApp.domain.Movie;


import lombok.RequiredArgsConstructor;

@RestController
public class MovieController {

	private MovieRepository movieRepository;
	
	// DI = 의존성 주입
	public MovieController(MovieRepository movieRepository) { // = import lombok.RequiredArgsConstructor;
		this.movieRepository = movieRepository;
	}
	
	@GetMapping("/movie")
	public CommonDto<List<Movie>> findAll() {
		System.out.println("findAll()");
		return new CommonDto<>(200, movieRepository.findAll()); // MessageConverter => (JavaObject -> Json String)
	}
	
	@GetMapping("/movie/select/{id}")
	public CommonDto<Movie> findById(@PathVariable int id) { // /user/{id} 의 id값을 int 값으로 받는다
		System.out.println("findById() : id : " + id);
		return new CommonDto<>(200, movieRepository.findById(id));
	}
	
	@PostMapping("/movie")
	// x-www-form-urlencoded => request.getParameter
	// text/plain => @RequestBody 어노테이션
	public CommonDto<String> save(@Valid @RequestBody JoinReqDto dto, BindingResult bindingResult) {
		System.out.println("save()");
		movieRepository.save(dto);
		
		return new CommonDto<>(200, "ok");
	}
	
	@DeleteMapping("/movie/{id}")
	public CommonDto delete(@PathVariable int id) {
		System.out.println("delete()");
		movieRepository.delete(id);
		
		return new CommonDto<>(200, "ok");
	}
	
	@PutMapping("/movie/{id}")
	public CommonDto update(@PathVariable int id, @Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult) {
		System.out.println("update()");
		movieRepository.update(id, dto);
		
		return new CommonDto<>(200, "ok");
	}
}
