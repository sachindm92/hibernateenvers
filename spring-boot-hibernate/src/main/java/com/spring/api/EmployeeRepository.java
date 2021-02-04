package com.spring.api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface EmployeeRepository extends RevisionRepository <Employee,Integer,Integer>, JpaRepository<Employee,Integer> {

	

}
