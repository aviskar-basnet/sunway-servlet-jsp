package com.sunway.servlet.assignment5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter writer = res.getWriter();
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Product List</title>");

		writer.println("<style>");
		writer.println("table, th, td { border: 1px solid black; border-collapse: collapse; }");
		writer.println("</style>");

		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2>Product List</h2>");
		writer.println("<table style=\"width:100%\">");

		writer.println("<tr>");
		writer.println("<th>Id</th>");
		writer.println("<th>Name</th>");
		writer.println("<th>Brand</th>");
		writer.println("<th>Category</th>");
		writer.println("<th>Price</th>");
		writer.println("</tr>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connUrl = "jdbc:mysql://localhost:3306/sunway-java-ee";
			String connUser = "root";
			String connPass = "mysql";
			Connection conn = DriverManager.getConnection(connUrl, connUser, connPass);
			ResultSet rs = conn.createStatement().executeQuery("select * from product");
			while (rs.next()) {
				writer.println("<tr>");
				writer.println("<td>" + rs.getString(1) + "</td>");
				writer.println("<td>" + rs.getString(2) + "</td>");
				writer.println("<td>" + rs.getString(3) + "</td>");
				writer.println("<td>" + rs.getString(4) + "</td>");
				writer.println("<td>" + rs.getString(5) + "</td>");
				writer.println("</tr>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String brand = req.getParameter("brand");
		String category = req.getParameter("category");
		String price = req.getParameter("price");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connUrl = "jdbc:mysql://localhost:3306/sunway-java-ee";
			String connUser = "root";
			String connPass = "mysql";
			Connection conn = DriverManager.getConnection(connUrl, connUser, connPass);
			String query = "insert into product values (null, '" + name + "', '" + brand + "', '" + category + "', '"
					+ price + "')";
			conn.createStatement().executeUpdate(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		res.sendRedirect("product");
	}
}
