package uts.edu.controller;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.edu.bean.Cart;
import uts.edu.bean.Customer;
import uts.edu.bean.Order;
import uts.edu.service.SaveOrderLocal;
import uts.edu.web.RequestMethod;

import com.bea.common.security.xacml.IOException;

public class SaveOrderController extends AbstractController
	{

		@EJB
		private SaveOrderLocal local;

		public SaveOrderController(SaveOrderLocal local,
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
				//Order order = (Order) request.getSession()
						//.getAttribute("order");
				
				Cart cart =(Cart) request.getSession().getAttribute("cart");
				Customer customer = (Customer) request.getSession().getAttribute("customer");
				//cart.setOrder(order);
				//Double grandPrice = cart.getTotalPrice();
				Order order = local.saveOrder(cart, customer);
				// service.saveCart(order, cart);
				request.getSession().removeAttribute("cart");
				request.getSession().removeAttribute("customer");
				request.setAttribute(
						"message",
						"NO. "
								+ order.getId()
								+ " order has been sucessfully stored! <br/>the browser will return to entry page in 5 seconds<meta http-equiv='refresh' content='5;url="
								+ request.getContextPath() + "/index.html'>");
				request.getRequestDispatcher("WEB-INF/jsps/message.jsp")
				.forward(request, response);
				return;
			}
	}
