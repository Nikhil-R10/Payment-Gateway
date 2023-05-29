package com.wipro.payment.gateway.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.payment.gateway.entity.UserCourses;
import com.wipro.payment.gateway.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/course/addToCart")
	public ResponseEntity<String> addCourseToCart(@RequestParam("courseId") Integer courseId, HttpServletRequest request) {
		String userName = request.getHeader("user_name");
		return paymentService.addCourseToCart(userName, courseId);
	}
	
	@PostMapping("/course/buy")
	public ResponseEntity<String> buyCourse(@RequestParam("courseId") Integer courseId, HttpServletRequest request){
		String userName = request.getHeader("user_name");
		return paymentService.buyCourse(userName, courseId);
	}
	
	@GetMapping("/course/cart")
	public ResponseEntity<List<UserCourses>> viewCoursesInCart(HttpServletRequest request) {
		String userName = request.getHeader("user_name");
		return paymentService.viewCoursesInCart(userName);
	}
	
	@PostMapping("course/buyAll")
	public ResponseEntity<String> buyCoursesInCart(HttpServletRequest request) {
		String userName = request.getHeader("user_name");
		return paymentService.buyCoursesInCart(userName);
	}

}
