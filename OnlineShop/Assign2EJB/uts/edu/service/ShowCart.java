package uts.edu.service;

import javax.ejb.*;

import uts.edu.bean.Cart;
import uts.edu.bean.CartItem;
import uts.edu.bean.Products;
import uts.edu.bean.ProductList;

@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless(mappedName = "ejb/Cart")
public class ShowCart implements ShowCartRemote, ShowCartLocal
	{

		@Override
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public void addItemToCart(String id, Cart cart, ProductList pl)
			{
				// TODO Auto-generated method stub
				Products choosenProduct = pl.getProduct(id);
				CartItem cartItem = cart.getCartItem(id);

				if (cartItem == null)
					{
						cartItem = new CartItem();
						cartItem.setProduct(choosenProduct);
						cartItem.setQuantity(1);
						cart.getCart().add(cartItem);
						System.out.print("not null" + cartItem.getTotalPrice());
					} else
					{
						cartItem.setQuantity(cartItem.getQuantity() + 1);
						System.out.print("not null" + cartItem.getTotalPrice());
					}

				cart.setTotalPrice();
			}
	}
