package uts.edu.service;

import javax.ejb.Remote;

import uts.edu.bean.Cart;

@Remote
public interface RemoveCartItemRemote
	{
		void removeCartItem(String id, Cart cart);
	}
