package com.sunway.servlet.assignment3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

	private static final List<Student> STUDENT_LIST = new ArrayList<Student>();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter writer = res.getWriter();
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Student List</title>");

		writer.println("<style>");
		writer.println("table, th, td { border: 1px solid black; border-collapse: collapse; }");
		writer.println("</style>");
		
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2>Student List</h2>");
		writer.println("<table style=\"width:100%\">");

		writer.println("<tr>");
		writer.println("<th>Name</th>");
		writer.println("<th>Age</th>");
		writer.println("<th>Gender</th>");
		writer.println("<th>Address</th>");
		writer.println("<th>Phone No.</th>");
		writer.println("</tr>");

		for (Student student : STUDENT_LIST) {
			writer.println("<tr>");
			writer.println("<td>" + student.getName() + "</td>");
			writer.println("<td>" + student.getAge() + "</td>");
			writer.println("<td>" + student.getGender() + "</td>");
			writer.println("<td>" + student.getAddress() + "</td>");
			writer.println("<td>" + student.getPhoneNo() + "</td>");
			writer.println("</tr>");
		}

		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		Integer age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String phoneNo = req.getParameter("phoneNo");
		Student student = new Student(name, age, gender, address, phoneNo);
		STUDENT_LIST.add(student);
		res.sendRedirect("student");
	}
}
