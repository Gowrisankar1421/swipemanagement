package com.example.swipemangement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.swipemangement.dto.ResponseDto;
import com.example.swipemangement.dto.SwipeDto;
import com.example.swipemangement.dto.SwipeOutDto;
import com.example.swipemangement.exception.InsufficientDataException;
import com.example.swipemangement.exception.InvalidDetailsException;
import com.example.swipemangement.exception.NoFacilityDataFoundException;
import com.example.swipemangement.exception.SwipeReportFailedException;
import com.example.swipemangement.model.Employee;
import com.example.swipemangement.model.Facility;
import com.example.swipemangement.service.SwipeService;


@RestController
public class SwipeController {
	@Autowired
	SwipeService swipeService;
	 Logger logger = LoggerFactory.getLogger(SwipeController.class);
	 
	   
	
	@PostMapping("/swipeIn")
	public ResponseEntity<ResponseDto> swipeIn(@RequestBody SwipeDto swipeDto) throws InsufficientDataException, InvalidDetailsException {
		ResponseDto responseDto=new ResponseDto();
		logger.info("create swipe------------");
		swipeService.saveSwipeIn(swipeDto);
		responseDto.setMessage("swipeIn saved successfully");
		
		responseDto.getMessage();
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);	
	}
	@PostMapping("/swipeOut")
	public ResponseEntity<ResponseDto> swipeOut(@RequestBody SwipeOutDto swipeOutDto) throws InsufficientDataException, InvalidDetailsException {
		ResponseDto responseDto=new ResponseDto();
		logger.info("create swipe------------");
		swipeService.saveSwipeOut(swipeOutDto);
		responseDto.setMessage("swipeOut saved successfully");
		
		responseDto.getMessage();
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);	
	}

	@GetMapping("/swipeReportByEmployee")
	public ResponseEntity<Employee> getSwipeReportByEmployeeId(@RequestParam long id) throws SwipeReportFailedException {
		ResponseDto responseDto=new ResponseDto();
		logger.info("getting swipe report by employee in swipe controller----------");
		Employee swipe=swipeService.getSwipeEmployee(id);
		responseDto.setMessage("swipe saved successfully");
		responseDto.getMessage();
		
		return new ResponseEntity<>(swipe, HttpStatus.OK);	
	}
	@GetMapping("/swipeReportByFacility")
	public ResponseEntity<Facility> getSwipeReportByFacility(@RequestParam long id) throws SwipeReportFailedException, NoFacilityDataFoundException {
		ResponseDto responseDto=new ResponseDto();
		logger.info("getting swipe report by facility in swipe controller----------");
		Facility swipe=swipeService.getSwipeByFaciltyId(id);
		responseDto.setMessage("swipe saved successfully");
		responseDto.getMessage();
		return new ResponseEntity<>(swipe, HttpStatus.OK);	
	}

}


