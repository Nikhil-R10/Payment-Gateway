package com.wipro.payment.gateway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.payment.gateway.entity.UserCourses;

@Repository
public interface UserCoursesRepository extends JpaRepository<UserCourses, Integer>{
	
	@Query(nativeQuery = true, value = "select * from user_courses where user_name = :user_name and payment_status = :status")
	List<UserCourses> findByUserNameAndPaymentStatus(@Param("user_name") String userName,@Param("status") String paymentStatus);

}
