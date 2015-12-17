package uts.edu.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.*;

import uts.edu.bean.Cart;
import uts.edu.bean.CartItem;
import uts.edu.bean.Customer;
import uts.edu.bean.Order;
import uts.edu.bean.OrderDetail;
import uts.edu.eao.OrderEaoLocal;

/**
 * Session Bean implementation class SaveOrder
 */
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless(mappedName = "ejb/SaveOrder")
public class SaveOrder implements SaveOrderRemote, SaveOrderLocal
	{
		@EJB private OrderEaoLocal eao;
		
		@Override
		public Order saveOrder(Cart cart, Customer customer)
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
				order.setOrderStatus("Ordered");
				order.setGrandtotal(cart.getTotalPrice());
				order.setOrderDate(new Timestamp(System.currentTimeMillis()));
				order.setCustomerId(generateCusId());
				order.setCustomerSurname(customer.getSurname());
				
				
				
				eao.saveOrder(order, customer);
				return order;
			}
		
		private  String generateCusId()
			{
				String onum = "dota2-" + System.currentTimeMillis()/1000;
				return onum;
			}
		
		/*private List <OrderDetail> generateOrderList(Cart cart, String orderNum)
		{
			List <OrderDetail> orderList = new ArrayList<OrderDetail>();
			for(CartItem item : cart.getCart())
			{
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderId(orderNum);
				orderDetail.setProductId(item.getCartItem_id());
				
				
			}
			return null;
		}*/
	}
