package uts.edu.service;

import javax.ejb.Local;

import uts.edu.bean.Customer;

@Local
public interface GetCustomerLocal
	{
		public Customer getCustomer(String gname, String sname, String email,
				String address, String payment, String postcode, String country);
	}
