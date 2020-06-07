package com.example.swipemangement.service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.swipemangement.dto.SwipeDto;
import com.example.swipemangement.dto.SwipeOutDto;
import com.example.swipemangement.exception.InsufficientDataException;
import com.example.swipemangement.exception.InvalidDetailsException;
import com.example.swipemangement.exception.NoEmployeeDataFoundException;
import com.example.swipemangement.exception.NoFacilityDataFoundException;
import com.example.swipemangement.exception.SwipeReportFailedException;
import com.example.swipemangement.model.Employee;
import com.example.swipemangement.model.Facility;
import com.example.swipemangement.model.Swipe;
import com.example.swipemangement.repository.EmployeeRepository;
import com.example.swipemangement.repository.SwipeRepository;

@Service
public class SwipeService {
	 Logger logger = LoggerFactory.getLogger(SwipeService.class);
	
	@Autowired
	SwipeRepository swipeRepository;

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public Swipe saveSwipeIn(SwipeDto swipeDto) throws InsufficientDataException, InvalidDetailsException {
		Swipe swipe = new Swipe();
		if (swipeDto.getSwipeIn() != null && swipeDto.getEmployeeId() != 0 && swipeDto.getFacilityId() != 0) {
			
			Employee employee = new Employee();
			employee.setEmployeeId(swipeDto.getEmployeeId());
			Facility facility = new Facility();
			facility.setFacilityId(swipeDto.getFacilityId());
			swipe.setEmployee(employee);
			swipe.setFacility(facility);
			swipe.setSwipeIn(swipeDto.getSwipeIn());
			swipe.setDate(new Date());
			try {
				swipeRepository.save(swipe);
			}catch(Exception e) {
				throw new InvalidDetailsException("invalid employee id or facility id");
			}
			
		} else {
			throw new InsufficientDataException("please fill the all the Details");
		}
		return swipe;
	}
	public Swipe saveSwipeOut(SwipeOutDto swipeOutDto) throws InsufficientDataException, InvalidDetailsException {
		Optional<Swipe> s;
		if (swipeOutDto.getEmployeeId() != 0 && swipeOutDto.getFacilityId() != 0&&swipeOutDto.getSwipeOut()!=null) {
			
			Employee employee = employeeRepository.findById(swipeOutDto.getEmployeeId()).orElseThrow(()->new NoEmployeeDataFoundException());
			List<Swipe> swipe=swipeRepository.findByDateAndEmployee(new Date(),employee);
			 s=swipe.stream().sorted(Comparator.comparing(Swipe::getSwipeId).reversed()).findFirst();
			long t1=swipeOutDto.getSwipeOut().getTime()/100000;
			long t2=s.get().getSwipeIn().getTime();
			long t3=t2-t1;
			s.get().setSwipeOut(swipeOutDto.getSwipeOut());
			s.get().setTotalWorkingHours(t3/(60*60*1000));
			try {
				swipeRepository.save(s.get());
			}catch(Exception e) {
				throw new InvalidDetailsException("invalid employee id or facility id");
			}
	
		} else {
			throw new InsufficientDataException("please fill the all the Details");
		}
		return s.get();
	}
	

	public Employee getSwipeEmployee(Long id) throws SwipeReportFailedException {
		try {
               logger.info("before excuting the swipe  rest template");
			Employee result = restTemplate.getForObject("http://localhost:7250/employee/" + id, Employee.class);
			logger.info("after excuting the swipe  rest template");
			return result;
		} catch (HttpClientErrorException e) {
			throw new NoEmployeeDataFoundException();
		}
	}

	public Facility getSwipeByFaciltyId(Long id) throws SwipeReportFailedException, NoFacilityDataFoundException {
		try {
			logger.info("before excuting the swipe facility  rest template");
			Facility result = restTemplate.getForObject("http://localhost:7251/facility/" + id, Facility.class);
			logger.info("after excuting the swipe facility  rest template");
			return result;
		} catch (HttpClientErrorException e) {
			throw new NoFacilityDataFoundException();
		}
	}

}
