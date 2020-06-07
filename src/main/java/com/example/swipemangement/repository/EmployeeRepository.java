package com.example.swipemangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swipemangement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
