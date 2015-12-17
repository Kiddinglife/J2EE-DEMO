package uts.edu.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.edu.web.RequestMethod;

import com.bea.common.security.xacml.IOException;

/**
 * @author Administrator
 * 
 */
public abstract class AbstractController implements Controller
	{
		private final List<RequestMethod> allowedMethodList;
		//protected ServiceLocal service;

		public AbstractController(final RequestMethod... allowedMethods)
			{
				this.allowedMethodList = Arrays.asList(allowedMethods); 			// create allowed methods list
			}

		/*
		 * This method will justify if the request is correct type
		 */
		public boolean isAllowedMethod(HttpServletRequest request)
			{
				final String method = request.getMethod();
				for (final RequestMethod allowedMethod : allowedMethodList)
					{
						if (allowedMethod.name().equalsIgnoreCase(method))
							{
								return true;
							}
					}
				return false;
			}

		/*
		 * This method will process the logic operations and then forward to
		 * viewer layer
		 */
		public abstract void process(HttpServletRequest request,
				HttpServletResponse response) throws ServletException,
				IOException, java.io.IOException;

	}
