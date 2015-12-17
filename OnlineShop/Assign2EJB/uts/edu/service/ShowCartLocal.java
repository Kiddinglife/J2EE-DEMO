package uts.edu.service;
import javax.ejb.Local;

import uts.edu.bean.Cart;
import uts.edu.bean.ProductList;

@Local
public interface ShowCartLocal {


	void addItemToCart(String id, Cart cart, ProductList pl);

}
