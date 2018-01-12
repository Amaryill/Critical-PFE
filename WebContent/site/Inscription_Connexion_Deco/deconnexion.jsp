<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

HttpSession varSession = request.getSession();
varSession.invalidate(); 

response.sendRedirect("/Critical-PFE/Index");

%>