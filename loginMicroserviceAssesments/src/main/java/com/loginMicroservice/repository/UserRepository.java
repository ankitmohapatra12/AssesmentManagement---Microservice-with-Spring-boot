package com.loginMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loginMicroservice.model.User;




@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	User findByName(String userName);

	@Query(value= "SELECT * from user u where name = ?",nativeQuery = true)
	User findByUserName(String name);

	

}
