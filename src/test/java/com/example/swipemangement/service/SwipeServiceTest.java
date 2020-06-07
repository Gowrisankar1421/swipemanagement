package com.example.swipemangement.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
import com.example.swipemangement.repository.SwipeRepository;
@RunWith(MockitoJUnitRunner.Silent.class)
public class SwipeServiceTest {


	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	
		@InjectMocks
		SwipeService swipeService;

		@Mock
		SwipeRepository swipeRepository;
		SwipeDto swipeDto=new SwipeDto();
		SwipeOutDto swipeOutDto=new SwipeOutDto();
		@Test
		public void testSaveSwipeInNegitive() throws InsufficientDataException, InvalidDetailsException{
			swipeDto.setEmployeeId(2);
			swipeDto.setTotalWorkingHours(2);
			swipeDto.setFacilityId(3);
			swipeDto.setSwipeIn(new Date());
			if (swipeDto.getSwipeIn() != null && swipeDto.getEmployeeId() != 0 && swipeDto.getFacilityId() != 0) {
			
			Swipe swipe = new Swipe();
			Employee employee = new Employee();
			employee.setEmployeeId(swipeDto.getEmployeeId());
			Facility facility = new Facility();
			facility.setFacilityId(swipeDto.getFacilityId());
			swipe.setEmployee(employee);
			swipe.setFacility(facility);
			swipe.setSwipeIn(swipeDto.getSwipeIn());
			swipe.setDate(new Date());
			try {
				Mockito.when(swipeRepository.save(Mockito.any(Swipe.class))).thenReturn((swipe));
			}catch(Exception e) {
				throw new InvalidDetailsException("invalid employee id or facility id");
			}
	
			
			swipeService.saveSwipeIn(swipeDto);;
			} else {
				throw new InsufficientDataException("please fill the all the Details");
			}
			}
		@Test
		public void testSaveSwipeInForPositve() throws InsufficientDataException, InvalidDetailsException{
			swipeDto.setEmployeeId(2);
			swipeDto.setTotalWorkingHours(2);
			swipeDto.setFacilityId(3);
			swipeDto.setSwipeIn(new Date());
			if (swipeDto.getSwipeIn() != null && swipeDto.getEmployeeId() != 0 && swipeDto.getFacilityId() != 0) {
			
			Swipe swipe = new Swipe();
			Employee employee = new Employee();
			employee.setEmployeeId(swipeDto.getEmployeeId());
			Facility facility = new Facility();
			facility.setFacilityId(swipeDto.getFacilityId());
			swipe.setEmployee(employee);
			swipe.setFacility(facility);
			swipe.setSwipeIn(swipeDto.getSwipeIn());
			swipe.setDate(new Date());
			swipeRepository.save(swipe);
			
			try {
				Mockito.when(swipeRepository.save(swipe)).thenReturn((swipe));
				
			}catch(Exception e) {
				throw new InvalidDetailsException("invalid employee id or facility id");
			}
			
			swipeService.saveSwipeIn(swipeDto);;
			} else {
				throw new InsufficientDataException("please fill the all the Details");
			}
		}
		@Test(expected = InsufficientDataException.class)
		public void testSaveSwipeInForExce() throws InsufficientDataException, InvalidDetailsException{
			if (swipeDto.getSwipeIn() != null && swipeDto.getEmployeeId() != 0 && swipeDto.getFacilityId() != 0) {
			
			Swipe swipe = new Swipe();
			Employee employee = new Employee();
			employee.setEmployeeId(swipeDto.getEmployeeId());
			Facility facility = new Facility();
			facility.setFacilityId(swipeDto.getFacilityId());
			swipe.setEmployee(employee);
			swipe.setFacility(facility);
			swipe.setSwipeIn(swipeDto.getSwipeIn());
			swipe.setDate(new Date());
	
			Mockito.when(swipeRepository.save(swipe)).thenReturn((swipe));
			swipeService.saveSwipeIn(swipeDto);;
			} else {
				throw new InsufficientDataException("please fill the all the Details");
			}
		}
		@Test(expected = NullPointerException.class)
		public void testSaveSwipeOutNegitive() throws InsufficientDataException, InvalidDetailsException{
			swipeOutDto.setEmployeeId(2);
			swipeOutDto.setTotalWorkingHours(2);
			swipeOutDto.setFacilityId(3);
			swipeOutDto.setSwipeOut(new Date());
			if (swipeOutDto.getSwipeOut() != null && swipeOutDto.getEmployeeId() != 0 && swipeOutDto.getFacilityId() != 0) {
			
			Swipe swipe = new Swipe();
			Employee employee = new Employee();
			employee.setEmployeeId(swipeOutDto.getEmployeeId());
			Facility facility = new Facility();
			facility.setFacilityId(swipeOutDto.getFacilityId());
			swipe.setEmployee(employee);
			swipe.setFacility(facility);
			swipe.setSwipeOut(swipeOutDto.getSwipeOut());
			swipe.setDate(new Date());
			Mockito.when(swipeRepository.save(Mockito.any(Swipe.class))).thenReturn((swipe));
			swipeService.saveSwipeOut(swipeOutDto);
			} else {
				throw new InsufficientDataException("please fill the all the Details");
			}
			}
		@Test(expected = InsufficientDataException.class)
		public void testSaveSwipeOutExce() throws InsufficientDataException, InvalidDetailsException{
			if (swipeOutDto.getSwipeOut() != null && swipeOutDto.getEmployeeId() != 0 && swipeOutDto.getFacilityId() != 0) {
			
			Swipe swipe = new Swipe();
			Employee employee = new Employee();
			employee.setEmployeeId(swipeOutDto.getEmployeeId());
			Facility facility = new Facility();
			facility.setFacilityId(swipeOutDto.getFacilityId());
			swipe.setEmployee(employee);
			swipe.setFacility(facility);
			swipe.setSwipeOut(swipeOutDto.getSwipeOut());
			swipe.setDate(new Date());
			Mockito.when(swipeRepository.save(Mockito.any(Swipe.class))).thenReturn((swipe));
			swipeService.saveSwipeOut(swipeOutDto);
			} else {
				throw new InsufficientDataException("please fill the all the Details");
			}
			}
	
		@Test(expected = Exception.class)
		public void testgetSwipeEmployee() throws SwipeReportFailedException {
			swipeService.getSwipeEmployee(2l);
			try {
				Employee result = restTemplate.getForObject("http://localhost:7250/employee/" , Employee.class);
				
			} catch (HttpClientErrorException e) {
				throw new NoEmployeeDataFoundException();
			}}
		@Test(expected = Exception.class)
		public void testgetSwipeByFaciltyId() throws SwipeReportFailedException, NoFacilityDataFoundException {
			swipeService.getSwipeByFaciltyId(2l);
			try {
				Facility result = restTemplate.getForObject("http://localhost:7251/employee/" , Facility.class);
				
			} catch (HttpClientErrorException e) {
				throw new NoEmployeeDataFoundException();
			}}
}
		