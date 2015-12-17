package uts.edu.service;

import javax.ejb.Local;

import uts.edu.bean.Cart;

@Local
public interface RemoveCartItemLocal
	{
		void removeCartItem(String id, Cart cart);
	}
