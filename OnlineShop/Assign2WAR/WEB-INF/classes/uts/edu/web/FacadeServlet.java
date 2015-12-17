package uts.edu.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.edu.controller.CancelCartController;
import uts.edu.controller.CancelOrderController;
import uts.edu.controller.ChangeQuantityController;
import uts.edu.controller.Controller;
import uts.edu.controller.ProductListController;
import uts.edu.controller.ConfirmCustomerController;
import uts.edu.controller.RemoveCartItemController;
import uts.edu.controller.SaveOrderController;
import uts.edu.controller.ShowCartController;
import uts.edu.service.ChangedQuantityLocal;
import uts.edu.service.RemoveCartItemLocal;
import uts.edu.service.GetCustomerLocal;
import uts.edu.service.SaveOrderLocal;
import uts.edu.service.ShowCartLocal;
import uts.edu.service.ShowProductListLocal;

/**
 * Servlet implementation class FacadeServlet
 */
public class FacadeServlet extends HttpServlet
	{
		private static final long serialVersionUID = 1L;

		@EJB
		private ShowProductListLocal productListLocal;

		@EJB
		private ShowCartLocal cartLocal;

		@EJB
		private ChangedQuantityLocal quantityLocal;

		@EJB
		private RemoveCartItemLocal removeLocal;

		@EJB
		private GetCustomerLocal cusLocal;

		@EJB
		private SaveOrderLocal saveLocal;

		/**
		 * 
		 */
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException,
				IOException
			{

				Controller controller = null;
				String action = request.getParameter("action");

				if (action.equalsIgnoreCase("show-product-list"))
					{
						controller = new ProductListController(
								productListLocal, RequestMethod.GET,
								RequestMethod.POST);
					} else if (action.equalsIgnoreCase("show-cart"))
					{
						controller = new ShowCartController(cartLocal,
								RequestMethod.GET, RequestMethod.POST);
					} else if (action.equalsIgnoreCase("change-quantity"))
					{
						controller = new ChangeQuantityController(
								quantityLocal, RequestMethod.GET,
								RequestMethod.POST);
					} else if (action.equalsIgnoreCase("remove-cart-item"))
					{
						controller = new RemoveCartItemController(removeLocal,
								RequestMethod.GET, RequestMethod.POST);
					} else if (action.equalsIgnoreCase("cancel-cart"))
					{
						controller = new CancelCartController(
								RequestMethod.GET, RequestMethod.POST);
					} else if (action.equalsIgnoreCase("confirm-customer"))
					{
						controller = new ConfirmCustomerController(cusLocal,
								RequestMethod.GET, RequestMethod.POST);
					} else if (action.equalsIgnoreCase("cancel-order"))
					{
						controller = new CancelOrderController(
								RequestMethod.GET, RequestMethod.POST);
					} else if (action.equalsIgnoreCase("save-order"))
					{
						controller = new SaveOrderController(saveLocal,
								RequestMethod.GET, RequestMethod.POST);
					}

				if (controller.isAllowedMethod(request))
					{
						try
							{
								controller.process(request, response);
							} catch (com.bea.common.security.xacml.IOException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					} else
					{
						throw new IllegalStateException(
								"Not suporrted method \"" + request.getMethod()
										+ "\" for the request.");
					}
				;

			}

		/**
		 * 
		 */
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException,
				IOException
			{
				doPost(request, response);
			}

	}
