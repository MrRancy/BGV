package com.wipro.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Request {

	@Id
	@Column(name = "request_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String companyName1;
	private String doj1;
	private String lwd1;
	private String address1;
	
	private String companyName2;
	private String doj2;
	private String lwd2;
	private String address2;
	
	private String highestDegree;
	private String college;
	private String year;

	private String status="Open";
	private String dateSubmitted = LocalDate.now().toString();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "request_user", joinColumns = @JoinColumn(name = "request_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> requestUser = new HashSet<>();
	
	public Request() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getCompanyName1() {
		return companyName1;
	}

	public void setCompanyName1(String companyName1) {
		this.companyName1 = companyName1;
	}

	public String getDoj1() {
		return doj1;
	}

	public void setDoj1(String doj1) {
		this.doj1 = doj1;
	}

	public String getLwd1() {
		return lwd1;
	}

	public void setLwd1(String lwd1) {
		this.lwd1 = lwd1;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCompanyName2() {
		return companyName2;
	}

	public void setCompanyName2(String companyName2) {
		this.companyName2 = companyName2;
	}

	public String getDoj2() {
		return doj2;
	}

	public void setDoj2(String doj2) {
		this.doj2 = doj2;
	}

	public String getLwd2() {
		return lwd2;
	}

	public void setLwd2(String lwd2) {
		this.lwd2 = lwd2;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Set<User> getRequestUser() {
		return requestUser;
	}

	public void setRequestUser(Set<User> requestUser) {
		this.requestUser = requestUser;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", companyName1=" + companyName1 + ", doj1=" + doj1 + ", lwd1=" + lwd1
				+ ", address1=" + address1 + ", companyName2=" + companyName2 + ", doj2=" + doj2 + ", lwd2=" + lwd2
				+ ", address2=" + address2 + ", highestDegree=" + highestDegree + ", college=" + college + ", year="
				+ year + ", status=" + status + ", dateSubmitted=" + dateSubmitted + ", requestUser=" + requestUser
				+ "]";
	}
	
	
}
