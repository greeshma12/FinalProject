package com.ust.beans;

public class Contact {
	private int contactId;
	private String name;
	private int vendorId;
	private String dep;
	private String email;
	private String phone;
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
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
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(int contactId, String name, int vendorId, String dep,
			String email, String phone) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.vendorId = vendorId;
		this.dep = dep;
		this.email = email;
		this.phone = phone;
		
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", name=" + name
				+ ", vendorId=" + vendorId + ", dep=" + dep + ", email="
				+ email + ", phone=" + phone + "]";
	}
	
	

}
