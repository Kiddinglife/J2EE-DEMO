package uts.edu.service;

import javax.ejb.*;

import uts.edu.bean.Cart;

@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless(mappedName = "ejb/RemoveCartItem")
public class RemoveCartItem implements RemoveCartItemRemote,
		RemoveCartItemLocal
	{

		@Override
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public void removeCartItem(String id, Cart cart)
			{
				cart.removeCartItem(id);
				cart.setTotalPrice();
			}
	}
