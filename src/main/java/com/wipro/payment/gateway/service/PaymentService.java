package com.wipro.payment.gateway.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.payment.gateway.entity.UserCourses;

public interface PaymentService {
	
	ResponseEntity<String> addCourseToCart(String userId, Integer courseId);
	
	ResponseEntity<String> buyCourse(String userId, Integer courseId);
	
	ResponseEntity<List<UserCourses>> viewCoursesInCart(String userId);
	
	ResponseEntity<String> buyCoursesInCart(String userId);	

}