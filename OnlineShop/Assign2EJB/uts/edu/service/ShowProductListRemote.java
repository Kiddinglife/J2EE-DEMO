package uts.edu.service;
import javax.ejb.Remote;

import uts.edu.bean.ProductList;

@Remote
public interface ShowProductListRemote {

	ProductList getProductList(String kind);

	void pagination(String cPage, ProductList pl);
	
	//void addItemToCart(String id, Cart cart, ProductList pl);

}
