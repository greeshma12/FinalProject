package com.ust.beans;

public class Vendor {
	private int vendorId;
	private String vendorName;
	private String addr;
	private String location;
	private String service;
	private int pincode;
	private int isActive;
	private int contactId;
	private String name;
	private String dep;
	private String email;
	private String phone;
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contractId) {
		this.contactId = contactId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor(int vendorId, String vendorName, String addr,
			String location, String service, int pincode, int isActive,
			int contractId, String name, String dep, String email, String phone) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.addr = addr;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isActive = isActive;
		this.contactId = contactId;
		this.name = name;
		this.dep = dep;
		this.email = email;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", addr=" + addr + ", location=" + location + ", service="
				+ service + ", pincode=" + pincode + ", isActive=" + isActive
				+ ", contactId=" + contactId + ", name=" + name + ", dep="
				+ dep + ", email=" + email + ", phone=" + phone + "]";
	}
	
	

}
