package com.nitk.chat.upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(urlPatterns={"/login"}, name="login")
public class LoginServlet  extends HttpServlet {
	private static final long serialVersionUID = -324279526479573210L;
	
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("upload.....");
		boolean isErr = request.getParameter("err") != null;
	}
		
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("Login ....");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username != null && password != null && password.startsWith(username) && password.endsWith("@123")) {
			response.sendRedirect("chat.html");
		}
	}
}