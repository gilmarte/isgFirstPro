package com.isg.ifrend.core.model.mli.dto;


public class ContactDetailDTO {

	
	private String customerNumber;	
	private String homeTelephone;
	private String businessTelephone;
	private boolean isPhonePlaceEmployee;
	private String mobile;
	private String otherTelephone;
	private String faxNumber;
	private String emailAddress;
	
	
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getHomeTelephone() {
		return homeTelephone;
	}
	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
	}
	public String getBusinessTelephone() {
		return businessTelephone;
	}
	public void setBusinessTelephone(String businessTelephone) {
		this.businessTelephone = businessTelephone;
	}
	public boolean isPhonePlaceEmployee() {
		return isPhonePlaceEmployee;
	}
	public void setPhonePlaceEmployee(boolean isPhonePlaceEmployee) {
		this.isPhonePlaceEmployee = isPhonePlaceEmployee;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOtherTelephone() {
		return otherTelephone;
	}
	public void setOtherTelephone(String otherTelephone) {
		this.otherTelephone = otherTelephone;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
