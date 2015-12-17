package uts.edu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.edu.bean.Customer;
import uts.edu.bean.Order;
import uts.edu.web.RequestMethod;

import com.bea.common.security.xacml.IOException;

public class CancelOrderController extends AbstractController
	{

		public CancelOrderController(RequestMethod... allowedMethods)
			{
				super(allowedMethods);
			}

		@Override
		public void process(HttpServletRequest request,
				HttpServletResponse response) throws ServletException,
				IOException, java.io.IOException
			{
				request.setAttribute(
						"message", " purchase has been sucessfully cancelled! <br>the browser will return to entry page in 3 seconds<meta http-equiv='refresh' content='5;url="
								+ request.getContextPath() + "/Index.html'>");

				request.getSession().removeAttribute("customer");
				request.getSession().removeAttribute("cart");
				request.getSession().removeAttribute("pl");
				request.getRequestDispatcher("WEB-INF/jsps/message.jsp")
						.forward(request, response);
				return;
			}
	}
