package uts.edu.service;

import javax.ejb.Remote;

import uts.edu.bean.Customer;

@Remote
public interface GetCustomerRemote
	{
				public Customer getCustomer(String gname, String sname, String email,
				String address, String payment, String postcode, String country);
	}
