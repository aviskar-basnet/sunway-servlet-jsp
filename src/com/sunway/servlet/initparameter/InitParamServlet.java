package com.sunway.servlet.initparameter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/init-param", initParams = @WebInitParam(name = "my-name", value = "Aashish"))
public class InitParamServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String myName = getInitParameter("my-name");
		PrintWriter pw = response.getWriter();
		pw.println("my-name :: " + myName);
	}
}
