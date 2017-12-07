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

		<jsp:include page="/site/include/import_dashgum.jsp" />
		
		<!-- importation des classes -->
	    <%@page import="fr.eseo.criticalPfe.java.model.scenario.Campagne" %>
	    
		
		<!-- Verification de la variable session -->
		<% if (request.getSession().getAttribute("utilisateur") == null) {
			response.sendRedirect("login.jsp");
		}
		%>
		
		<title>Campagne</title>
	</head>
	
	<body class="bg-image"
	style="background-image: url('../../assets/img/login-bg.jpg');">
	
	<!--  Header et aside -->
		<section id="container">
			
			<jsp:include page="/site/include/import_header.jsp" />	
			<jsp:include page="/site/include/import_aside.jsp"/>	
		
		</section>	
		<!-- **********************************************************************************************************************************************************
	      MAIN CONTENT
	      *********************************************************************************************************************************************************** -->
		<section id="main-content">
			<section class="wrapper">
			
				<form class="form-horizontal" method="post" action="/Critical-PFE/AfficherUnivers">
					<div class="col-xs-2 col-xs-offset-0">
						<button class="btn btn-theme btn-block" type="submit" id="afficher univers">Retour</button>
					</div>
				</form>
				
				<br><br>
				<% Campagne campagne = (Campagne)request.getSession().getAttribute("campagne"); %>
				
				<br>
				
				<form class="form-horizontal" method="post" action="/Critical-PFE/SuppressionCampagne">
					<div class="col-xs-2 col-xs-offset-0">
						<button class="btn btn-theme btn-block" type="submit" id="supprimer campagne">Supprimer la campagne</button>
					</div>
				</form>
				<br>
				
				
				<h1 style="color:black;">
					<%= campagne.getNomCampagne() %>
				</h1>
				
				<h2 style="color:black;">
				 - Description - 
				</h2>
				
				<script type="text/javascript">
				    function getContent(){
			     	   document.getElementById("my-textarea").value = document.getElementById("my-contentp").innerHTML;
				    }
				</script>
				
				<div id="my-content" contenteditable="true">
					<p id="my-contentp"style="color:black;"><%=campagne.getDescription()%></p>
				</div>
			
				<form id="form" action="/Critical-PFE/EditDescriptionCampagne" onsubmit="return getContent()">
			    	<textarea id="my-textarea" name="my-textarea" style="display:none"></textarea>
			    	<div class="col-xs-6 col-xs-offset-0">
						<button type="submit" class="btn btn-default">editer</button>
					</div>				
				</form>
				
				<br>
				<br>
				<br>

				
				<form class="form-horizontal" action="/Critical-PFE/RenommerCampagne" method="post">
					<div class="form-group">
						<div class="col-xs-3 col-xs-offset-0">
							<div class="form-material form-material-primary">
								<label class="control-label" for="pseudo_nouveau" style="color:black;">Changer le nom de la campagne</label> 
								<input type="text" class="form-control" id="nomCampagne"
									placeholder="Nouveau nom" name="nomCampagne">
			   					<textarea id="my-textarea" style="display:none"></textarea>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-6 col-xs-offset-0">
							<button type="submit" class="btn btn-default">Modifier</button>
						</div>
					</div>
						
				</form>
			</section>
		</section>
		
			 
		
		<jsp:include  page="/site/include/import_script.jsp" />
		
	
		</div>
	
	
	</body>
	
	
</html>