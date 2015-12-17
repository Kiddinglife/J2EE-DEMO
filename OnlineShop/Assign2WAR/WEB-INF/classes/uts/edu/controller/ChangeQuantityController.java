package uts.edu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.edu.bean.Cart;
import uts.edu.service.ChangedQuantityLocal;
import uts.edu.web.RequestMethod;

import com.bea.common.security.xacml.IOException;

public class ChangeQuantityController extends AbstractController
	{
		private ChangedQuantityLocal local;

		public ChangeQuantityController(ChangedQuantityLocal local,
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
				String quantity = request.getParameter("quantity");

				Cart cart = (Cart) request.getSession().getAttribute("cart");
				System.out.println("process "+id+quantity+cart);
				local.changeQuantity(id, cart, quantity);

				request.getRequestDispatcher("WEB-INF/jsps/1.jsp").forward(
						request, response);
				return;

			}

	}
