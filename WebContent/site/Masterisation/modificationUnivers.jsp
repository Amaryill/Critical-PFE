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
	    <%@page import="fr.eseo.criticalPfe.java.model.scenario.Univers,fr.eseo.criticalPfe.java.model.scenario.Campagne,
	    	java.util.List" %>
	    
		<!-- Verification de la variable session -->
		<% if (request.getSession().getAttribute("utilisateur") == null) {
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
			
		  	<jsp:include page="../include/import_aside.jsp"/>	
	
		</section>	
		 
		<!-- **********************************************************************************************************************************************************
	      MAIN CONTENT
	      *********************************************************************************************************************************************************** -->
		<section id="main-content">
			<section class="wrapper">
			
			
				<form class="form-horizontal" method="post" action="/Critical-PFE/AffichageListeUnivers">
					<div class="col-xs-2 col-xs-offset-0">
						<button class="btn btn-theme btn-block" type="submit" id="afficher univers">Retour</button>
					</div>
				</form>
				
				<br><br>
				<% Univers univers = (Univers)request.getSession().getAttribute("univers"); %>
				<br>
				
				
				<form class="form-horizontal" method="post" action="/Critical-PFE/SuppressionUnivers">
					<input type="hidden" name="idUnivers" id="idUnivers" value = <%= univers.getId() %>>
					<div class="col-xs-2 col-xs-offset-0">
						<button class="btn btn-theme btn-block" type="submit" id="afficher univers">Supprimer l'univers</button>
					</div>
				</form>
				<br>
				
				<h1 style="color:black">
					<%= univers.getNomUnivers() %>
				</h1>
				<br>
				
				<h2 style="color:black;">
				 - Description - 
				</h2>
				
				<script type="text/javascript">
		    function getContent(){
		        document.getElementById("my-textarea").value = document.getElementById("my-contentp").innerHTML;
		    }
		</script>
				
				<div id="my-content" contenteditable="true">
					<p id="my-contentp"style="color:black;"><%=univers.getDescription()%></p>
				</div>
			
				<form id="form" action="/Critical-PFE/EditDescriptionUnivers" onsubmit="return getContent()">
			    	<textarea id="my-textarea" name="my-textarea" style="display:none"></textarea>
					<input type="hidden" name="idUnivers" id="idUnivers" value = <%=univers.getId() %>>
			    	<div class="col-xs-6 col-xs-offset-0">
						<button type="submit" class="btn btn-default">editer</button>
					</div>				
				</form>
				<br>
				<br>
				<br>

				
				<form class="form-horizontal" action="/Critical-PFE/RenommerUnivers" method="post">
					<div class="form-group">
						<div class="col-xs-3 col-xs-offset-0">
							<div class="form-material form-material-primary">
								<label class="control-label" for="pseudo_nouveau" style="color:black;">Changer le nom de l'univers</label> 
								<input type="text" class="form-control" id="nomUnivers"
									placeholder="Nouveau nom" name="nomUnivers">
			   					<textarea id="my-textarea" style="display:none"></textarea>
							</div>
						</div>
					</div>
					<input type="hidden" name="idUnivers" id="idUnivers" value = <%=univers.getId() %>>
					<div class="form-group">
						<div class="col-xs-6 col-xs-offset-0">
							<button type="submit" class="btn btn-default">Modifier</button>
						</div>
					</div>
						
				</form>
				
				<br><br><br>
				
				<% List<Campagne> listeCampagne = (List<Campagne>)request.getSession().getAttribute("listeCampagne"); 
				for(Campagne campagne : listeCampagne){
					%>
					
					<form class="form-horizontal" method="post" action="/Critical-PFE/AfficherCampagne">
						<input type="hidden" name="idCampagne" id="idCampagne" value = <%=campagne.getId()%>>
						<div class="form-group">
							<div class="col-xs-3 col-xs-offset-1">
								<button class="btn btn-theme btn-block" type="submit" id="afficher campagne" value="afficher"><%=campagne.getNomCampagne() %></button>
							</div>
						</div>
					</form>
					<%
				}
				%>
				<form class="form-horizontal" method="post" action="/Critical-PFE/CreationCampagne">
					<div class="col-xs-3 col-xs-offset-2">
						<button class="btn btn-theme btn-block" type="submit" id="submit_Creer campagne" value="Creer">Créer une nouvelle campagne</button>
					</div>
				</form>
				
				
				
				
				
				
				
				
				
			</section>
		</section>
		
		<jsp:include  page="/site/include/import_script.jsp" />
		
		
	</body>
	
</html>