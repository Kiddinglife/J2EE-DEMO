package uts.edu.service;

import javax.ejb.*;

import uts.edu.bean.Cart;

@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless(mappedName = "ejb/ChangeQuantity")
public class ChangedQuantity implements ChangedQuantityRemote,
		ChangedQuantityLocal
	{

		@Override
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public void changeQuantity(String id, Cart cart, String quantity)
			{
				System.out.println("i am in ejb ");
				cart.getCartItem(id).setQuantity(Integer.parseInt(quantity));
				cart.setTotalPrice();
			}
	}
