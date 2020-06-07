package com.example.swipemangement.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swipemangement.model.Employee;
import com.example.swipemangement.model.Swipe;
@Repository
public interface SwipeRepository extends JpaRepository<Swipe, Long>{

	List<Swipe> findByDateAndEmployee(Date date, Employee employee);

}
