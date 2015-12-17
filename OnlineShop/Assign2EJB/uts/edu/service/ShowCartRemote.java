package uts.edu.service;
import javax.ejb.Remote;

import uts.edu.bean.Cart;
import uts.edu.bean.ProductList;

@Remote
public interface ShowCartRemote {
	public void addItemToCart(String id, Cart cart, ProductList pl);
}
