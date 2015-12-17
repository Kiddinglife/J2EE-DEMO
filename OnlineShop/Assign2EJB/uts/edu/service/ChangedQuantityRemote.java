package uts.edu.service;

import javax.ejb.Remote;

import uts.edu.bean.Cart;

@Remote
public interface ChangedQuantityRemote
	{
		public void changeQuantity(String id, Cart cart, String quantity);
	}
