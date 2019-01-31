package com.sunway.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie-max-age")
public class CookieMaxAgeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie langCookie = new Cookie("lang", "en");
		langCookie.setMaxAge(5);
		response.addCookie(langCookie);
		PrintWriter writer = response.getWriter();
		writer.println("Lang cookie added!!");
	}
}
