package com.wipro.payment.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.payment.gateway.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
