package uts.edu.service;

import javax.ejb.Local;

import uts.edu.bean.Cart;

@Local
public interface ChangedQuantityLocal
	{
		public void changeQuantity(String id, Cart cart, String quantity);
	}
