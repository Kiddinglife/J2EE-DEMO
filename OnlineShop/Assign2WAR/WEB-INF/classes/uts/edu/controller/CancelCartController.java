package uts.edu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.edu.web.RequestMethod;

import com.bea.common.security.xacml.IOException;

public class CancelCartController extends AbstractController
	{

		
		public CancelCartController(RequestMethod... allowedMethods)
		{
			super(allowedMethods);
		}

		@Override
		public void process(HttpServletRequest request,
				HttpServletResponse response) throws ServletException,
				IOException, java.io.IOException
			{
				request.getSession().removeAttribute("cart");

				request.getRequestDispatcher("WEB-INF/jsps/1.jsp")
						.forward(request, response);
				return;
			}
	}
