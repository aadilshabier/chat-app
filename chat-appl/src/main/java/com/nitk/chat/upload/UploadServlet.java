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

import org.apache.commons.io.FileUtils;

@MultipartConfig
@WebServlet(urlPatterns={"/upload"}, name="upload")
public class UploadServlet  extends HttpServlet {
	private static final long serialVersionUID = -324279526479573200L;
	
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
		System.out.println("File upload....");
	    final Part filePart = request.getPart("ufile");
	    String fileName = filePart.getSubmittedFileName();
	    try(InputStream is = filePart.getInputStream()) {
	        File targetFile = new File("/Users/tkdinda/"+fileName);
	        FileUtils.copyInputStreamToFile(is, targetFile);	
	        
	        try(Writer w = response.getWriter()) {
	        	w.write(fileName +" uploaded successfully");
	        }
	        
	    } catch (Exception e) {
	    	
	    	response.sendRedirect("upload");
	    }
	}
}
