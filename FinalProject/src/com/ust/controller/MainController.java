package com.ust.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.beans.Login;
import com.ust.beans.Vendor;
import com.ust.dao.MainDaoService;



@RestController
public class MainController {
	@Autowired
	MainDaoService dao;
	
	
	//verify login
		@RequestMapping(value = "/api/login/{userName}/{password}", method = RequestMethod.GET)
		@ResponseBody
		public Login select(@PathVariable("userName") String userName,
				@PathVariable("password") String password) {
			return dao.selectRole(userName,password);
		}
		
		//view vendors
		
			@RequestMapping(value = "/api/vendor/{vendorName}", method = RequestMethod.GET)
			@ResponseBody
			public List getVendor(Model m, @PathVariable("vendorName") String vendorName) {
				List list;
				if (vendorName.equals("null")) {
					list = dao.getVendor();
				} else {
					list = dao.getVendorByName(vendorName);
				}

				return list;
			}
			// view vendor list by id
			@RequestMapping(value = "/api/vendordetails/{vendorId}", method = RequestMethod.GET)
			@ResponseBody
			public Vendor getvendors(Model m, @PathVariable("vendorId") int vendorId) {

			return  dao.getVendorId(vendorId);

			}
			// Add to  Vendor and contact
			@ResponseBody
			@RequestMapping(value = "/api/insert", method = RequestMethod.POST)
			public void insert(@RequestBody Vendor v) throws ParseException {
				dao.addVendor(v);
			}
			
			// update Vendor
			@ResponseBody
			@RequestMapping(value = "/api/updatevendor", method = RequestMethod.PUT)
			public void updateDoctor(@RequestBody Vendor v) throws ParseException {
				int vendorId = v.getVendorId();
				int contactId = v.getContactId();
				dao.update(vendorId, v);
			}
			
			// to disable a vendor

			@RequestMapping(value = "/api/disablevendor/{vendorId}", method = RequestMethod.PUT)
			@ResponseBody
			public void disableStaff(@PathVariable("vendorId") int vendorId) {
			dao.disableVendor(vendorId);
			}
			
			// view contactdetails by vendor id

			@RequestMapping(value = "/api/contactdetails/{vendorId}", method = RequestMethod.GET)
			@ResponseBody
			public List getContact(Model m,@PathVariable("vendorId") int vendorId) {
				List list;
			list=dao.getContact(vendorId);
			return list;

			}
			

			
			
			

			

	
	

}
