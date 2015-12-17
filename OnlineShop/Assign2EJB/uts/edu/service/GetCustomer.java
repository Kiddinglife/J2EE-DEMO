package uts.edu.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import uts.edu.bean.Customer;
import uts.edu.bean.Order;

/**
 * Session Bean implementation class Order
 */
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless(mappedName = "ejb/Order")
public class GetCustomer implements GetCustomerRemote, GetCustomerLocal
	{

		
		@Override
		public Customer getCustomer(String gname, String sname, String email,
				String address, String payment, String postcode, String country)
			{
				Customer customer = new Customer();
				customer.setId(sname);
				customer.setGivenname(gname);
				customer.setSurname(sname);
				customer.setEmail(email);
				customer.setAddress(address);
				customer.setPostcode(postcode);
				customer.setCountry(country);
				String onum = "dota2" + System.currentTimeMillis()/1000;
				customer.setId(onum);
				try
					{
						customer.setPayment(Integer.parseInt(payment));
					} catch (NumberFormatException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("please enter integer number");
					}
				return customer;

			}

	}
