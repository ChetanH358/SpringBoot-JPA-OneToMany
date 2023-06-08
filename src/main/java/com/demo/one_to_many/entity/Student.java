package com.demo.one_to_many.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
	@Id
	private int stdId;
	private String stdName;
	private String stdUSN;

	@OneToMany(mappedBy = "student" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private Set<Address> address;

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdUSN() {
		return stdUSN;
	}

	public void setStdUSN(String stdUSN) {
		this.stdUSN = stdUSN;
	}

}
