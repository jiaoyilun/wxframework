<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	request.setAttribute("path", path);

	request.getRequestDispatcher("/account/login").forward(request,response);
	//response.sendRedirect("index.shtml");//URL重定向
	
%>