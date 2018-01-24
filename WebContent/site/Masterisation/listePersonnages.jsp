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

<%@ page import="java.util.*"%>
<%@ page import="fr.eseo.criticalPfe.java.model.entite.Personnage"%>
<%@ page import="fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur"%>

<%	Utilisateur user = (Utilisateur) session.getAttribute("user"); %>

<jsp:include page="/site/include/import_dashgum.jsp" />

<title>Critical</title>
</head>
<body class="bg-image"
	style="background-image: url('assets/img/login-bg.jpg');">

	<!--  Header et aside -->
	<section id="container"> <jsp:include
		page="/site/include/import_header.jsp" /> <jsp:include
		page="/site/include/import_aside.jsp" /> <section id="main-content">
	<section class="wrapper"> <!-- CONTENU PAGE ICI -->



	<form class="form-horizontal"
		style="margin-top: 20px; margin-left: 25px; background-color: rgba(255, 255, 255, 0);">
		<div class="form-group col-xs-12"
			style="background-color: rgba(255, 255, 255, 0);">
			<div class="panel panel-default"
				style="background-color: rgba(255, 255, 255, 1);">
				<div class="panel-heading"
					style="background-color: rgba(66, 74, 93, 1);">
					<h4 style="color: white">Liste des personnages :</h4>
				</div>

				<div class="panel-body"
					style="background-color: rgba(255, 255, 255, 0.7);"></div>
				<div class="card-body">
					<%
						if (user.getPersonnages().size() == 0) {
					%>
					<h4>Aucun personnage créé actuellement</h4>
					<%
						} else {
					%>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Personnage</th>
								
								<th>Niveau</th>
								<th>Univers</th>
							</tr>
						</thead>

						<tbody>
							<%
								for (int i = 0; i < user.getPersonnages().size(); ++i) {
										out.println("<tr onclick=\"location.href='/Critical-PFE/AfficherFichePersonnage?id="
												+ user.getPersonnages().get(i).getId()
												+ "'\">");
										out.println("<td><input id='id' name='id' type='hidden' value='"+ user.getPersonnages().get(i).getId() +"'>" + user.getPersonnages().get(i).getNom() + "</td>");
										out.println("<td>" + (int)user.getPersonnages().get(i).getFacteurPuissance() + "</td>");
										out.println("<td>" + (user.getPersonnages().get(i).getUnivers().getNomUnivers()==null?"Non affecté":user.getPersonnages().get(i).getUnivers().getNomUnivers()) + "</td>");
										out.println("</tr>");
									}
							%>
						</tbody>
					</table>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</form> 
	<jsp:include page="/site/include/import_script.jsp" />
</body>
</html>