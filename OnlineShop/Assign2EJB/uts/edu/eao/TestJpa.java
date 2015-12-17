package uts.edu.eao;


import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;

import javax.ejb.Stateless;

import uts.edu.bean.Order;

/**
 * Session Bean implementation class TestJpa
 */
@Stateless(mappedName = "ejb/TestJpa")
public class TestJpa extends AbstractEao implements TestJpaLocal
	{
	


		@Override
		public void TestSaveOrder()
			{
				Order order = new Order();
				Order.plusNum();
				String num = Order.getNum() + "";
				int zero = num.length();
				if (zero == 1)
					{
						num = "mezhang000" + num;
					}

				if (zero == 2)
					{
						num = "mezhang00" + num;
					}

				if (zero == 3)
					{
						num = "mezhang0" + num;
					}
				order.setOrderNumber(num);
				order.setGrandtotal(20.1f);
				order.setCustomerId("123");
				order.setCustomerSurname("zhang");	
				order.setOrderStatus("Ordered");
				save(order);
				System.out.println("order number: "+num+"order object: "+order.getCustomerId()+", "+order.getCustomerSurname()+", "+order.getOrderDate()+", "+order.getGrandtotal());

			}

		@Override
		public <T> List<T> getResultList(Class<T> entityClass,
				String whereJpql, LinkedHashMap<String, String> orderBy,
				Object... args)
			{
				// TODO Auto-generated method stub
				return null;
			}

		@Override
		public void TestSaveCus()
			{
				// TODO Auto-generated method stub
				
			}

	}
