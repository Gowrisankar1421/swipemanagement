package com.example.swipemangement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class Swipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long swipeId;
	@Temporal(TemporalType.TIME)
	private Date swipeIn;
	@Temporal(TemporalType.TIME)
	private Date swipeOut;
	private double totalWorkingHours;
	@Temporal(TemporalType.DATE)
	private Date date;
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	private Facility facility;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Employee employee;

	public Long getSwipeId() {
		return swipeId;
	}

	public void setSwipeId(Long swipeId) {
		this.swipeId = swipeId;
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

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
		}
