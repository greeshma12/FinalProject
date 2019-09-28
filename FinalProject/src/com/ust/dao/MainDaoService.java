package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.Login;
import com.ust.beans.Vendor;






public class MainDaoService {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	//to return  the userId
	public Login selectRole(String userName, String password) {
		String sql = "select userId from login where userName='"
				+ userName
				+ "' and password='" + password + "'";
		return template.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<Login>(Login.class));
	}
	
	//get all vendors details
	
	public List<Vendor> getVendor() {
		return template
				.query("select vendorId,vendorName,addr,location,service,pincode from vendor where isActive=1",
						new RowMapper<Vendor>() {
							public Vendor mapRow(ResultSet rs, int row)
									throws SQLException {
								Vendor v = new Vendor();
								v.setVendorId(rs.getInt(1));
								v.setVendorName(rs.getString(2));
								v.setAddr(rs.getString(3));
								v.setLocation(rs.getString(4));
								v.setService(rs.getString(5));
								v.setPincode(rs.getInt(6));
								return v;
							}
						});
	}
	
	//get vendor by vendor name
	
		public List<Vendor> getVendorByName(String vendorName) {
			return template
					.query("select vendorId,vendorName,addr,location,service,pincode from vendor where isActive=1 and vendorName='"+ vendorName + "'",
							new RowMapper<Vendor>() {
								public Vendor mapRow(ResultSet rs, int row)
										throws SQLException {
									Vendor v = new Vendor();
									v.setVendorId(rs.getInt(1));
									v.setVendorName(rs.getString(2));
									v.setAddr(rs.getString(3));
									v.setLocation(rs.getString(4));
									v.setService(rs.getString(5));
									v.setPincode(rs.getInt(6));
									return v;
								}
							});
		}


//get vendor details by id
public List<Vendor> getVendorById(int vendorId) {
	return template
			.query("select vc.vendorId,vc.vendorName,vc.addr,vc.location,vc.service,vc.pincode,c.name,c.dep,c.email,c.phone,c.contactId from vendor vc join contact c on vc.vendorId=c.vendorId where vc.isActive=1 and vc.vendorId='"+ vendorId + "'",
					new RowMapper<Vendor>() {
						public Vendor mapRow(ResultSet rs, int row)
								throws SQLException {
							Vendor v = new Vendor();
							v.setVendorId(rs.getInt(1));
							v.setVendorName(rs.getString(2));
							v.setAddr(rs.getString(3));
							v.setLocation(rs.getString(4));
							v.setService(rs.getString(5));
							v.setPincode(rs.getInt(6));
							v.setName(rs.getString(7));
							v.setDep(rs.getString(8));
							v.setEmail(rs.getString(9));
							v.setPhone(rs.getString(10));
							v.setContactId(rs.getInt(11));
							return v;
						}
					});
}
	
	//to Add vendors
	
	public int addVendor(Vendor v) {

		String sql1 = "insert into vendor(vendorName,addr,location,service,pincode,isActive) values "
				+ "('"
				+ v.getVendorName()
				+ "','"
				+ v.getAddr()
				+ "','"
				+ v.getLocation()
				+ "','"
				+ v.getService()
				+ "',"
				+ v.getPincode()
				+ ","
				+ 1
				+ ")";

		 template.update(sql1);
		 
		 Integer maxId = getSequence();
		 String sql2="insert into contact(vendorId,name,dep,email,phone) values ("
				 + maxId
					+ ",'"
					+ v.getName()
					+ "','"
					+ v.getDep()
					+ "','"
					+ v.getEmail()
					+ "'," + v.getPhone() + ")";
		 return template.update(sql2);

				 
		 
	}
	
	// to get vendor by vendor id
	private Integer getSequence() {
		Integer seq;
		String sql = "select MAX(vendorId)from vendor";
		seq = template.queryForObject(sql, new Object[] {}, Integer.class);
		return seq;
	}

	//------------get vendor details by id
	public Vendor getVendorId(int vendorId) {
	String sql="select vc.vendorId,vc.vendorName,vc.addr,vc.location,vc.service,vc.pincode,cd.name,cd.dep,cd.email,cd.phone,cd.contactId from vendor vc join contact cd on vc.vendorId=cd.vendorId where vc.isActive=1 and vc.vendorId='"+ vendorId + "'";
	return template.queryForObject(sql, new Object[] {},
	new BeanPropertyRowMapper<Vendor>(Vendor.class));

	}
	
	// update vendor
		public int update(int vendorId, Vendor v) {

			String sql = "update vendor set vendorName='" + v.getVendorName()
					+ "' ,addr='" + v.getAddr() + "' ,location='"
					+ v.getLocation() + "',service='" + v.getService() + "',pincode=" + v.getPincode() + ",isActive=" + 1 + " "
					+ "where vendorId =" + vendorId;
			template.update(sql);

			// Integer maxId = getSequence();

			String sql1 = "update contact set vendorId=" + vendorId + ",name='"
					+ v.getName() + "',dep='"
					+ v.getDep() + "',email='"
					+ v.getEmail() + "',phone='" + v.getPhone() + "'"+"where contactId = " + v.getContactId();

			return template.update(sql1);
		}
		
		//contact by id

		public List<Vendor> getContact(int vendorId) {
		return template.query("select contactId,name,dep,vendorId,email,phone from contact where vendorId="+vendorId+"", new RowMapper<Vendor>() {
			public Vendor mapRow(ResultSet rs, int row)
					throws SQLException {
				Vendor v = new Vendor();
				v.setContactId(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setDep(rs.getString(3));
				v.setVendorId(rs.getInt(4));
				v.setEmail(rs.getString(5));
				v.setPhone(rs.getString(6));
				return v;
			}
		});
		}
		//to disable a vendor
		public int disableVendor(int vendorId) {

		String sql = "update vendor set isActive=0 where vendorId=" + vendorId
		+ "";

		return template.update(sql);
		}
}
