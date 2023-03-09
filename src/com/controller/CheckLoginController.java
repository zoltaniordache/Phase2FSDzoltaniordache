package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Admin;
import com.service.AdminService;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLoginController")
public class CheckLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Admin admin = new Admin(email, password);
		AdminService as = new AdminService();
		
		boolean valid = as.validateAdmin(admin);
		
		if(valid)
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", admin.getEmail());
			session.setAttribute("password", admin.getPassword());
			response.sendRedirect("viewFlight.jsp");
		} else {
			request.getRequestDispatcher("loginPage.jsp").include(request, response);
			out.print("<header style='color:red; margin-left:7%'> Invalid email or password! </header>");
		}
	}

}
