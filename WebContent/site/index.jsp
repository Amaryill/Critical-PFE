<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="Dashboard">
	    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

		<jsp:include page="include/import_dashgum.jsp" />
		
		<!-- Verification de la variable session -->
		<% if (request.getSession().getAttribute("utilisateur") == null) {
			response.sendRedirect("login.jsp");
		}
		%>
		
		<title>Index</title>
	</head>
	
	<body class="bg-image"
	style="background-image: url('../assets/img/login-bg.jpg');">
	
	<!--  Header et aside -->
		<section id="container">
			
			<jsp:include page="include/import_header.jsp" />	
			<jsp:include page="include/import_aside.jsp"/>	
		
		</section>	
			 
		
		<jsp:include  page="include/import_script.jsp" />
		
	
		</div>
	
	
	</body>
	
	
</html>