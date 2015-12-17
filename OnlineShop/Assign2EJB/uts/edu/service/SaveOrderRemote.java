package uts.edu.service;

import javax.ejb.Remote;

import uts.edu.bean.Cart;
import uts.edu.bean.Customer;
import uts.edu.bean.Order;

@Remote
public interface SaveOrderRemote
	{
		public Order saveOrder(Cart cart, Customer customer);
	}
