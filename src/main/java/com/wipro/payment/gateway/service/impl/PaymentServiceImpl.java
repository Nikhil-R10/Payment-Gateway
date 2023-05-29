package com.wipro.payment.gateway.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.payment.gateway.entity.Course;
import com.wipro.payment.gateway.entity.User;
import com.wipro.payment.gateway.entity.UserCourses;
import com.wipro.payment.gateway.repository.CourseRepository;
import com.wipro.payment.gateway.repository.UserCoursesRepository;
import com.wipro.payment.gateway.repository.UserRepository;
import com.wipro.payment.gateway.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserCoursesRepository userCourseRepository;
	
	private static final String IN_CART = "IN_CART";
	private static final String PAID = "PAID";
	
	public ResponseEntity<String> addCourseToCart(String userId, Integer courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		Optional<User> user = userRepository.findById(userId);
		UserCourses userCourse = new UserCourses();
		userCourse.setCourseId(course.get());
		userCourse.setUserName(user.get());
		userCourse.setPaymentStatus(IN_CART);
		userCourseRepository.save(userCourse);
		return new ResponseEntity<>("Added to cart", HttpStatus.OK);		
	}
	
	public ResponseEntity<String> buyCourse(String userId, Integer courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		Optional<User> user = userRepository.findById(userId);
		UserCourses userCourse = new UserCourses();
		userCourse.setCourseId(course.get());
		userCourse.setUserName(user.get());
		userCourse.setPaymentStatus(PAID);
		userCourseRepository.save(userCourse);
		return new ResponseEntity<>("Course is added to your learning", HttpStatus.OK);		
	}
	
	public ResponseEntity<List<UserCourses>> viewCoursesInCart(String userId) {
		return new ResponseEntity<>(userCourseRepository.findByUserNameAndPaymentStatus(userId, IN_CART), HttpStatus.OK);
	}
	
	public ResponseEntity<String> buyCoursesInCart(String userId) {
		List<UserCourses> courses = userCourseRepository.findByUserNameAndPaymentStatus(userId, IN_CART);
		courses.forEach(course -> {
			course.setPaymentStatus(PAID);
		});
		userCourseRepository.saveAll(courses);
		return new ResponseEntity<>("Payment successful and courses are added to your learning!", HttpStatus.OK);
	}

}
