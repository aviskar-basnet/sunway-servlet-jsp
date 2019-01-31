package com.sunway.servlet.initparam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/init-param-2", initParams = @WebInitParam(name = "email", value = "xyz@example.com"))
public class Eg03InitParamServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = getInitParameter("email");
		PrintWriter pw = response.getWriter();
		pw.println("email :: " + email);
	}
}
