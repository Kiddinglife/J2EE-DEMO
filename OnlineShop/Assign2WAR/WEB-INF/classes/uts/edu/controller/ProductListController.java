package uts.edu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.edu.bean.ProductList;
import uts.edu.service.ShowProductListLocal;
import uts.edu.web.RequestMethod;

import com.bea.common.security.xacml.IOException;

public class ProductListController extends AbstractController implements
		Controller
	{
		private ShowProductListLocal local;

		public ProductListController(ShowProductListLocal service,
				RequestMethod... allowedMethods)
			{
				super(allowedMethods);
				this.local = service;
			}

		/*
		 * receives the request and response objects call the methods from
		 * service interface
		 */

		public void process(HttpServletRequest request,
				HttpServletResponse response) throws ServletException,
				IOException, java.io.IOException
			{
				HttpSession session = request.getSession();
				String kind = request.getParameter("kind");
				ProductList pl = (ProductList) session.getAttribute("pl");
				String wp = request.getParameter("wantedPage");

				if (wp == null) // first time log in or new kind
					{
						pl = local.getProductList(kind);
						pl.setCurrentPage(1);
						session.setAttribute("pl", pl);
					}

				if (pl != null && wp != null)// paging
					{
						local.pagination(wp, pl);
					}

				request.getRequestDispatcher("WEB-INF/jsps/1.jsp").forward(
						request, response);
				return;
			}
	}
