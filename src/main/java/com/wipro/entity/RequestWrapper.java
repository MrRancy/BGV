package com.wipro.entity;


public class RequestWrapper {

	private Long id;
	private User userDetails;
	private Request requestDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public Request getRequestDetails() {
		return requestDetails;
	}

	public void setRequestDetails(Request requestDetails) {
		this.requestDetails = requestDetails;
	}

	@Override
	public String toString() {
		return "RequestWrapper [id=" + id + ", userDetails=" + userDetails + ", requestDetails=" + requestDetails + "]";
	}

}
