package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// Perform business logic. Return a bean as a result.
		CustomerService service = (CustomerService) CustomerService.getInstance();
		Customer customer = service.login(id, password);
		request.setAttribute("customer", customer);
		
		

		//List<Customer> customers = new ArrayList<>();
		//customers.add(new Customer("id003", "1234", "park", "m", "park@hansung.ac.kr"));
		//request.setAttribute("customerList",  customers);
		
		String page;
		
		if(customer == null) {
			page = "/view/error.jsp";
			request.setAttribute("id", id);
		}
		else {
			page = "/view/successLogin.jsp";
			request.setAttribute("customer", customer);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request,  response);
		
	}

}
