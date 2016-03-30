package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Database;

public class BaoxiuDelete extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String baoxiuid=request.getParameter("id");
		
		try{
			Connection cn=Database.getconnect();
			PreparedStatement ps=cn.prepareStatement("delete from baoxiu where baoxiuid=?");
			ps.setString(1, baoxiuid);
			int n=ps.executeUpdate();
			if(n>0){
				response.sendRedirect("baoxiuselect.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
