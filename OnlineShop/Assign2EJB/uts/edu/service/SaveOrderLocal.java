package uts.edu.service;

import javax.ejb.Local;

import uts.edu.bean.Cart;
import uts.edu.bean.Customer;
import uts.edu.bean.Order;

@Local
public interface SaveOrderLocal
	{
		public Order saveOrder(Cart cart, Customer customer);
	}
