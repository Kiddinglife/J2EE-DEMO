package uts.edu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.edu.bean.Customer;
import uts.edu.bean.Order;
import uts.edu.service.GetCustomerLocal;
import uts.edu.web.RequestMethod;

import com.bea.common.security.xacml.IOException;

public class ConfirmCustomerController extends AbstractController
	{

		private GetCustomerLocal local;

		public ConfirmCustomerController(GetCustomerLocal local,
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
				String gname = request.getParameter("gname");
				String sname = request.getParameter("sname");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String postcode = request.getParameter("postcode");
				String country = request.getParameter("country");
				String payment = request.getParameter("payment");
				

				Customer customer  = local.getCustomer(gname, sname, email, address, payment, postcode, country);
				request.getSession().setAttribute("customer", customer);
				request.getRequestDispatcher("WEB-INF/jsps/confirm-order.jsp")
						.forward(request, response);
				System.out.println("postcode "+ postcode+ " " +"country "+ country);
				return;
			}

	}
