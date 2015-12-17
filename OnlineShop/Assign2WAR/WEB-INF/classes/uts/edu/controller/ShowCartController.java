package uts.edu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.edu.bean.Cart;
import uts.edu.bean.ProductList;
import uts.edu.service.ShowCartLocal;
import uts.edu.web.RequestMethod;

import com.bea.common.security.xacml.IOException;

public class ShowCartController extends AbstractController
	{

		private ShowCartLocal cartLocal;

		public ShowCartController(ShowCartLocal cartLocal,
				RequestMethod... allowedMethods)
			{
				super(allowedMethods);
				this.cartLocal = cartLocal;

			}

		@Override
		public void process(HttpServletRequest request,
				HttpServletResponse response) throws ServletException,
				IOException, java.io.IOException
			{
				String id = request.getParameter("id");
				ProductList pl = (ProductList) request.getSession()
						.getAttribute("pl");
				Cart cart = (Cart) request.getSession().getAttribute("cart");
				if (cart == null)
					{
						cart = new Cart();
						request.getSession().setAttribute("cart", cart);
					}
				cartLocal.addItemToCart(id, cart, pl);
				request.getRequestDispatcher("WEB-INF/jsps/1.jsp").forward(
						request, response);
				return;
			}

	}
