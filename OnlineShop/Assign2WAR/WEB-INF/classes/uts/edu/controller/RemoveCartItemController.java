package uts.edu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.edu.bean.Cart;
import uts.edu.service.RemoveCartItemLocal;
import uts.edu.web.RequestMethod;

import com.bea.common.security.xacml.IOException;

public class RemoveCartItemController extends AbstractController
	{
		private RemoveCartItemLocal local;

		public RemoveCartItemController(RemoveCartItemLocal local,
				RequestMethod... allowedMethods)
			{
				super(allowedMethods);
				this.local = local;
			}

		@Override
		public void process(HttpServletRequest request,
				HttpServletResponse response) throws ServletException,
				IOException, java.io.IOException
			{
				String id = request.getParameter("id");
				Cart cart = (Cart) request.getSession().getAttribute("cart");
				local.removeCartItem(id, cart);
				request.getRequestDispatcher("WEB-INF/jsps/1.jsp").forward(
						request, response);
				return;
			}
	}
