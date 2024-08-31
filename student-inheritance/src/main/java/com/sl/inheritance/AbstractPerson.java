package com.sl.inheritance;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractPerson {

	private String drivingLicence;
	
	public AbstractPerson() {}

	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}
	
	
}
