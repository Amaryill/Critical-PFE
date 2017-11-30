<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<!-- importation des classes -->
	    <%@page import="fr.eseo.criticalPfe.java.model.scenario.Univers, java.util.List" %>

<jsp:include page="../include/import_dashgum.jsp" />

<!-- Verification de la variable session -->
<%
	if (request.getSession().getAttribute("utilisateur") == null) {
		response.sendRedirect("login.jsp");
	}
%>

<title>Masterisation</title>
</head>
	<body class="bg-image"
		style="background-image: url('../../assets/img/login-bg.jpg');">
	
	
		<!--  Header et aside -->
		
		<section id="container"> 
		
			<jsp:include page="../include/import_header.jsp" />
			<jsp:include page="../include/import_aside.jsp" /> 
		
			<section id = "main-content" class="wrapper">
				<% List<Univers> listeUnivers = (List<Univers>)request.getSession().getAttribute("listeUnivers"); 
				for(Univers univers : listeUnivers){
					%>
					
					<form class="form-horizontal" method="post" action="">
					<input type="hidden" name="id" id="id" value = <%=univers.getId() %>>
						<div class="form-group">
							<div class="col-xs-6 col-xs-offset-2">
								<button type="submit" id="submit_Creer univers" value="Creer"><%=univers.getNomUnivers() %></button>
							</div>
						</div>
					</form>
					
					
					
					<%
				}
				
				
				
				
				%>
			
				<form class="form-horizontal" method="post" action="/Critical-PFE/CreationUnivers">
					<div class="form-group">
						<div class="col-xs-6 col-xs-offset-2">
							<button type="submit" id="submit_Creer univers" value="Creer">Créer un nouvel univers</button>
						</div>
					</div>
				</form>
				
			</section>
			
		</section>
		
		
		
			

		
	
	
	
		<!-- js placed at the end of the document so the pages load faster -->
		<jsp:include page="../include/import_dashgum.jsp" />
	
	</body>

</html>