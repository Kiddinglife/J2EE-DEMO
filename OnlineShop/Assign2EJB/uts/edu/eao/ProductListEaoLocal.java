package uts.edu.eao;

import java.util.List;

import javax.ejb.Local;

import uts.edu.bean.Products;

@Local
public interface ProductListEaoLocal extends Eao
	{
		public List<Products> getProductList(String kind);
		public List<String> getKinds();
	}
