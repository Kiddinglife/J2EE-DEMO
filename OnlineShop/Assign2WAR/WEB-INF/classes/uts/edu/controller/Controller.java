/**
 * 
 */
package uts.edu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bea.common.security.xacml.IOException;

/**
 * this interface will contact to the Service interface
 */
public interface Controller
	{
		boolean isAllowedMethod(HttpServletRequest request);

		void process(HttpServletRequest request, HttpServletResponse response) throws ServletException,
		IOException, java.io.IOException;

	}
