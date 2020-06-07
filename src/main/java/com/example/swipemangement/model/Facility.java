package com.example.swipemangement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Facility {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long facilityId;
	
	private String facilityBranch;
	
	private String facilityCity;

	@OneToMany(mappedBy = "facility", cascade = CascadeType.MERGE)
	private List<Swipe> swipes;

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public List<Swipe> getSwipes() {
		return swipes;
	}

	public void setSwipes(List<Swipe> swipes) {
		this.swipes = swipes;
	}

	public String getFacilityBranch() {
		return facilityBranch;
	}

	public void setFacilityBranch(String facilityBranch) {
		this.facilityBranch = facilityBranch;
	}

	public String getFacilityCity() {
		return facilityCity;
	}

	public void setFacilityCity(String facilityCity) {
		this.facilityCity = facilityCity;
	}

}
