package com.example.swipemangement.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SwipeDto {
	private long employeeId;
	private long facilityId;
	@Temporal(TemporalType.TIME)
	private Date swipeIn;
	@JsonIgnore
	private Date swipeOut;
	@JsonIgnore
	private double totalWorkingHours;
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}
	public Date getSwipeIn() {
		return swipeIn;
	}
	public void setSwipeIn(Date swipeIn) {
		this.swipeIn = swipeIn;
	}
	public Date getSwipeOut() {
		return swipeOut;
	}
	public void setSwipeOut(Date swipeOut) {
		this.swipeOut = swipeOut;
	}
	public double getTotalWorkingHours() {
		return totalWorkingHours;
	}
	public void setTotalWorkingHours(double totalWorkingHours) {
		this.totalWorkingHours = totalWorkingHours;
	}

	
}
