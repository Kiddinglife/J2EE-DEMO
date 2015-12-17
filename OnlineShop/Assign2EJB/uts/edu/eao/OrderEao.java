package uts.edu.eao;

import javax.ejb.Stateless;

import uts.edu.bean.Customer;
import uts.edu.bean.Order;

/**
 * Session Bean implementation class OrderEao
 */
@Stateless(mappedName = "ejb/OrderEao")
public class OrderEao extends AbstractEao implements OrderEaoLocal
	{

@Override
	public void saveOrder(Order order, Customer customer)
		{
			save(order);
			save(customer);
		}
	}
