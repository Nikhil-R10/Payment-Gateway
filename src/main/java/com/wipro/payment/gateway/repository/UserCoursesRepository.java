package com.wipro.payment.gateway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.payment.gateway.entity.User;
import com.wipro.payment.gateway.entity.UserCourses;

@Repository
public interface UserCoursesRepository extends JpaRepository<UserCourses, Integer>{
	
	List<UserCourses> findByUserNameAndPaymentStatus(User user, String paymentStatus);

}
