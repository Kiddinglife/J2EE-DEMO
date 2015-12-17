package uts.edu.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import uts.edu.bean.Products;

/**
 * Session Bean implementation class ProductListEao
 */
@Stateless(mappedName = "ejb/ProductListEao")
public class ProductListEao extends AbstractEao implements ProductListEaoLocal
	{
		@Override
		public List<Products> getProductList(String kind)
			{
				return getResultList(Products.class, "where o.category = ?1", null, kind);
			}
		
		@SuppressWarnings("unchecked")
		public List<String> getKinds()
			{
				
				// create query
				Query query = em.createQuery("select distinct o.category from Products as o");
				
				// return result list
				return (List<String>) query.getResultList();
			}
	}
