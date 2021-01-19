package com.cos.movieApp.domain;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	
	List<Movie> movies = new ArrayList<>();
	
	public MovieRepository() {
		movies.add(new Movie(1,"테넷",5.0,Timestamp.valueOf(LocalDateTime.now())));
		movies.add(new Movie(2,"인터스텔라",5.0,Timestamp.valueOf(LocalDateTime.now())));
		movies.add(new Movie(3,"인셉션",5.0,Timestamp.valueOf(LocalDateTime.now())));
	}
	public List<Movie> findAll(){
		System.out.println("전체영화 가져오기");
		
		return movies;
	}
	
	public Movie findById(int id){
		System.out.println("영화 1건 가져오기");
		
		return movies.get(id-1);
	}
	
	public void save(JoinReqDto dto) {
		System.out.println("영화 등록하기");
		
		int id = movies.size() + 1;
		String title = dto.getTitle();
		double rating = dto.getRating();
		
		movies.add(new Movie(id, title, rating,Timestamp.valueOf(LocalDateTime.now()) ));		
	}
	
	public void delete(int id) {
		System.out.println("영화 삭제하기");
		
		movies.get(id-1).setId(movies.get(id-1).getId()-1);
		movies.remove(id-1);	
	}
	
	public void update(int id, UpdateReqDto dto) {
		System.out.println("영화 수정하기");
		
		String title = dto.getTitle();
		double rating = dto.getRating();
		
		movies.get(id-1).setTitle(title);
		movies.get(id-1).setRating(rating);
	}
}
