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
			<!-- **********************************************************************************************************************************************************
		      TOP BAR CONTENT & NOTIFICATIONS
		      *********************************************************************************************************************************************************** -->
		      <!--header start-->
		      <header class="header black-bg">
	             <div class="sidebar-toggle-box">
	                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
	             </div>
	             <!--logo start-->
	           	 <a href="index.jsp" class="logo"><b>Critical</b></a>
	             <!--logo end-->
	             <div class="top-menu">
	            	<ul class="nav pull-right top-menu">
	                    <li><a class="logout" href="Inscription_Connexion_Deco/deconnexion.jsp">Déconnexion</a></li>
	            	</ul>
	            </div>
	          </header>
				
			  <jsp:include page="include/import_aside.jsp"/>	
		
		</section>	
			 
		
		<jsp:include  page="include/import_script.jsp" />
		
	
		</div>
	
	
	</body>
	
	
</html>