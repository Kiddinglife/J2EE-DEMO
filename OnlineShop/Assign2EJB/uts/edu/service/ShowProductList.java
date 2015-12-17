package uts.edu.service;

import javax.ejb.*;

import uts.edu.bean.ProductList;
import uts.edu.eao.ProductListEaoLocal;

@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless(mappedName = "ejb/Service")
public class ShowProductList implements ShowProductListLocal,
		ShowProductListRemote
	{
		@EJB
		private ProductListEaoLocal plEao;

		@Override
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public void pagination(String cPage, ProductList pl)
			{
				// TODO Auto-generated method stub
				pl.setCurrentPage(Integer.parseInt(cPage));
			}

		@Override
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public ProductList getProductList(String kind)
			{
				ProductList pl = new ProductList();
				pl.setTotalProductList(plEao.getProductList(kind));
				pl.setKind(plEao.getKinds());
				return pl;
			}
	}
