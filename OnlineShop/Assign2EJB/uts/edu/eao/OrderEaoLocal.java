package uts.edu.eao;

import javax.ejb.Local;

import uts.edu.bean.Cart;
import uts.edu.bean.Customer;
import uts.edu.bean.Order;

@Local
public interface OrderEaoLocal extends Eao
	{
		public void saveOrder(Order order, Customer customer);

	}
