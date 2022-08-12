package com.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.model.Assesment;

@Repository
public interface AssesmentRepository extends JpaRepository<Assesment,Integer> {

}
