package com.gcil.cms.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class RequestAndCsutomer {

	private int customerId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String firstName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mobileNumber;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String emailId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String addressLineOne;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String addressLineTwo;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String city;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String county;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String zipCode;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String country;
	private String requestDesc;

	public String getResquestDesc() {
		return requestDesc;
	}

	public void setResquestDesc(String resquestDesc) {
		this.requestDesc = resquestDesc;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String custContactDateTime;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String customerType;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String requestType;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String requestBrief;
	private String reqAdditonalInfo;
	private String reqActionTaken;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String serviceTypeName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String requestStatus;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String requestSource;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String requestDateTime;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String reqEmpID;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String serviceTypeId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int requestId;

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestBrief() {
		return requestBrief;
	}

	public void setRequestBrief(String requestBrief) {
		this.requestBrief = requestBrief;
	}

	public String getReqAdditonalInfo() {
		return reqAdditonalInfo;
	}

	public void setReqAdditonalInfo(String reqAdditonalInfo) {
		this.reqAdditonalInfo = reqAdditonalInfo;
	}

	public String getReqActionTaken() {
		return reqActionTaken;
	}

	public void setReqActionTaken(String reqActionTaken) {
		this.reqActionTaken = reqActionTaken;
	}

	public String getServiceTypeName() {
		return serviceTypeName;
	}

	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getRequestSource() {
		return requestSource;
	}

	public void setRequestSource(String requestSource) {
		this.requestSource = requestSource;
	}

	public String getRequestDateTime() {
		return requestDateTime;
	}

	public void setRequestDateTime(String requestDateTime) {
		this.requestDateTime = requestDateTime;
	}

	public String getReqEmpID() {
		return reqEmpID;
	}

	public void setReqEmpID(String reqEmpID) {
		this.reqEmpID = reqEmpID;
	}

	public String getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustContactDateTime() {
		return custContactDateTime;
	}

	public void setCustContactDateTime(String custContactDateTime) {
		this.custContactDateTime = custContactDateTime;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
