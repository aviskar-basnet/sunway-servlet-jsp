package com.sunway.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneNo = request.getParameter("phoneNo");
		System.out.println(name + " :: " + address + " :: " + phoneNo);
		if (name == null || address == null || phoneNo == null || name.equals("") || address.equals("")
				|| phoneNo.equals("")) {
			request.setAttribute("cause", "Name, Address or Phone No is null or empty.");
			request.getRequestDispatcher("/registration-error").forward(request, response);
		} else {
			request.getRequestDispatcher("/registration-success").forward(request, response);
		}
	}
}
