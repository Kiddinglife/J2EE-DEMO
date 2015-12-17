package uts.edu.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductList  implements Serializable
	{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		// private String id;
		private List<Products> productList = new  ArrayList<Products>();
		private List<Products> totalProductList = new  ArrayList<Products>();
		private List<String> kind = new ArrayList<String>();
		private int currentPage;
		private int nextPage;
		private int prePage;
		private int totalPages;
		private final static int MAX = 2;

		public List<String> getKind()
			{
				return kind;
			}

		public void setKind(List<String> kind)
			{
				this.kind = kind;
			}

		public List<Products> getProductList()
			{
				return productList;
			}

		public int getNextPage()
			{
				return nextPage;
			}

		public void setNextPage(int nextPage)
			{
				this.nextPage = nextPage;
			}

		public int getPrePage()
			{
				return prePage;
			}

		public void setPrePage(int prePage)
			{
				this.prePage = prePage;
			}

		public List<Products> getTotalProductList()
			{
				return totalProductList;
			}

		public void setTotalProductList(List<Products> totalProductList)
			{
				this.totalProductList = totalProductList;
				int pages = totalProductList.size();
				if (pages % MAX == 0)
					setTotalPages(pages / MAX);
				else
					{
						setTotalPages((int) (pages / MAX) + 1);
					}
			}

		public int getCurrentPage()
			{
				return currentPage;
			}

		public void setCurrentPage(int cPage)
			{
				if (cPage < 1 || cPage > totalPages)
					return;

				this.currentPage = cPage;
				setNextPage(currentPage + 1);
				setPrePage(currentPage - 1);

				int left = 0;
				int right = 0;
				System.out.println("currentPage" + " " + currentPage);
				if (currentPage >= 1 && currentPage < totalPages)
					{
						left = MAX * (currentPage - 1);
						right = MAX * currentPage - 1;
					}

				if (currentPage == totalPages)
					{
						int size = totalProductList.size();
						left = MAX * (currentPage - 1);
						right = size - 1;
					}

				if (!productList.isEmpty())
					productList.clear();

				for (int i = left; i <= right; i++)
					{
						productList.add(totalProductList.get(i));
					}
			}

		public void setTotalPages(int totalPages)
			{
				this.totalPages = totalPages;
			}

		public Products getProduct(String id)
			{
				for (Products p : productList)
					{
						if ((p.getId()+"").equals(id))
							{
								return p;
							}
					}
				return null;
			}

		public void setProductList(List<Products> productList)
			{
				this.productList = productList;
			}
		
		
	}
