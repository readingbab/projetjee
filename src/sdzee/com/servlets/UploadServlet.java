package sdzee.com.servlets;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oreilly.servlet.MultipartRequest;
import sdzee.com.bdd.*;
@WebServlet("/UploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UploadServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Upload.jsp").forward(request, response);
			
		}

	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	    	Database d=new Database();
	        int id_hotel=Integer.parseInt( request.getParameter("id_hotel"));
	         
	        InputStream inputStream1 = null;
	        InputStream inputStream2 = null;
	        InputStream inputStream3 = null;
	        Part filePart1 = request.getPart("fname1");
	        Part filePart2 = request.getPart("fname2");
	        Part filePart3 = request.getPart("fname3");
	        if (filePart1 != null) {
	            inputStream1 = filePart1.getInputStream();
	        }
	        if (filePart1 != null) {
	            inputStream2 = filePart2.getInputStream();
	        }
	        if (filePart1 != null) {
	            inputStream3 = filePart3.getInputStream();
	        }
	         
	       String message=d.savePhoto(inputStream1 ,id_hotel,1);
	       d.savePhoto(inputStream2 ,id_hotel,2);
	       d.savePhoto(inputStream3 ,id_hotel,3);
	            request.setAttribute("Message", message);
	            response.sendRedirect( request.getContextPath() +"/gerer_hotel?id_hotel="+id_hotel);
	        }
	    }
