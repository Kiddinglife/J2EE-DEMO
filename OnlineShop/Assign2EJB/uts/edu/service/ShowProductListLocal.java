package uts.edu.service;
import javax.ejb.Local;

import uts.edu.bean.ProductList;

@Local
public interface ShowProductListLocal {
	ProductList getProductList(String kind);

	void pagination(String cPage, ProductList pl);
	
	//void addItemToCart(String id, Cart cart, ProductList pl);
}
