<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<!-- Verification de la variable session -->
		<% if (request.getSession().getAttribute("utilisateur") == null) {
			response.sendRedirect("login.jsp");
		}
		%>
				
		<!-- <link rel="stylesheet" href="WebContent/assets/css/bootstrap-theme.min.css">
		<script src="WebContent/assets/js/bootstrap.min.js"></script>-->
		
		
		<title>Profil</title>
	</head>
	<body>	
		<h1>Bienvenue 
		<%=request.getSession().getAttribute("utilisateur") %></h1>
		
				
	</body>
	
	
	
	
	<nav class="navbar-default navbar-inverse navbar-fixed-bottom">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a href="index.jsp"><img src="assets/img/Critical_dice_logo.png"></a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li><a href="index.jsp">Home</a></li>
		      <li><a href="#">Masterisation</a></li>
		      <li><a href="#">Partie en cours</a></li>
		      <li><a href="options.jsp">Options</a></li>
		      <li class="active"><a href="profil.jsp">Profil</a></li>
		      <li><a href="AfficherAmis">Amis</a></li>
		      <li><a href="#">Aide</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="deconnexion.jsp">Deconnexion</a></li>
		    </ul>
		  </div>
	</nav>
</html>