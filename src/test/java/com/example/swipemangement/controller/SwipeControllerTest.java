package com.example.swipemangement.controller;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.swipemangement.dto.ResponseDto;
import com.example.swipemangement.dto.SwipeDto;
import com.example.swipemangement.dto.SwipeOutDto;
import com.example.swipemangement.exception.InsufficientDataException;
import com.example.swipemangement.exception.InvalidDetailsException;
import com.example.swipemangement.exception.NoFacilityDataFoundException;
import com.example.swipemangement.exception.SwipeReportFailedException;
import com.example.swipemangement.model.Employee;
import com.example.swipemangement.model.Facility;
import com.example.swipemangement.model.Swipe;
import com.example.swipemangement.service.SwipeService;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.Silent.class)
public class SwipeControllerTest {
		@InjectMocks
		SwipeController swipeController;

		@Mock
		SwipeService  swipeService;


		@Test
		public void checkSwipeIn() throws InsufficientDataException, InvalidDetailsException {
			SwipeDto s = new SwipeDto();
			Swipe srd= new Swipe();
			Mockito.when(swipeService.saveSwipeIn(s)).thenReturn(srd);
			
			ResponseEntity<ResponseDto> ydc=swipeController.swipeIn(s);
			Assert.assertNotNull(ydc);
			Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
			
			
		}

		@Test
		public void checkSwipeOut() throws InsufficientDataException, InvalidDetailsException{
			SwipeOutDto s = new SwipeOutDto();
			Swipe srd= new Swipe();
			Mockito.when(swipeService.saveSwipeOut(s)).thenReturn(srd);
			
			ResponseEntity<ResponseDto> ydc=swipeController.swipeOut(s);
			Assert.assertNotNull(ydc);
			Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
			
			
		}
		@Test
		public void checkGrtByEmpId() throws SwipeReportFailedException {
			SwipeOutDto s = new SwipeOutDto();
			Swipe swi = new Swipe();
			Employee e =  new Employee();
			s.setEmployeeId(1l);
			ResponseDto srd= new ResponseDto();
			Mockito.when(swipeService.getSwipeEmployee(1l)).thenReturn(e);
			
			ResponseEntity<Employee> ydc=swipeController.getSwipeReportByEmployeeId(1l);
			Assert.assertNotNull(ydc);
			Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
			
			
		}
		
		@Test
		public void checkGrtByFaciId() throws SwipeReportFailedException, NoFacilityDataFoundException {
			SwipeOutDto s = new SwipeOutDto();
			Swipe swi = new Swipe();
			Facility f = new Facility();
			s.setEmployeeId(1l);
			ResponseDto srd= new ResponseDto();
			Mockito.when(swipeService.getSwipeByFaciltyId(1l)).thenReturn(f);
			
			ResponseEntity<Facility> ydc=swipeController.getSwipeReportByFacility(1l);
			Assert.assertNotNull(ydc);
			Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
			
			
		}
		}

