<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fr.eseo.criticalPfe.java.model.attributs.Competence"%>
<%@ page import="fr.eseo.criticalPfe.java.model.entite.Personnage"%>
<%@ page import="fr.eseo.criticalPfe.java.model.entite.Classe"%>
<%@ page import="fr.eseo.criticalPfe.java.model.entite.Race"%>
<%
    List<Competence> competencesAcquises = (List<Competence>) session.getAttribute("competencesAcquises");
%>
<%
    List<Competence> competencesNonAcquises = (List<Competence>) session.getAttribute("competencesNonAcquises");
%>
<%
    Personnage personnage = (Personnage) session.getAttribute("personnageCourant");
%>
<%
    int pointsCompetenceMax = (Integer) session.getAttribute("pointsCompRestants");
%>

<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">


<jsp:include page="/site/include/import_dashgum.jsp" />
<title>Critical</title>
</head>
<body class="bg-image"
	style="background-image: url('assets/img/CreationPerso-bg.png');">

	<!-- Verification de la variable session -->
	<%
	    if (request.getSession().getAttribute("utilisateur") == null) {
	        response.sendRedirect("/site/login.jsp");
	    }
	%>

	<!--  Header et aside -->
	<section id="container"> <jsp:include
		page="/site/include/import_header.jsp" /> <jsp:include
		page="/site/include/import_aside.jsp" /> <!-- **********************************************************************************************************************************************************
	      MAIN CONTENT
	      *********************************************************************************************************************************************************** -->

	<section id="main-content"> <section class="wrapper">
	<br>
	<br>
	<h1 style="color: black;">Sélection des Compétences</h1>
	<div class="form-group col-xs-12">
		<form action="/Critical-PFE/ApplicationCompetences" method="post">
			<!-- INFOS PERSO -->
			<div class="row">
				<div class="form-group col-xs-12 col-sm-12 col-md-6 col-md-offset-3">
					<div class="panel panel-default">
						<div class="panel-heading"><strong>Personnage<strong></div>
						<div class="panel-body">
							<div class="form-inline">
								<div class="form-group col-xs-12 col-md-6">
									<h3 id="nom"><%=personnage.getNom()%></h3>
								</div>
								<div class="form-group col-xs-12 col-md-6">
									<h4>
										<i><%=personnage.getRace().getNom()%> - <%=personnage.toStringClasses()%></i>
									</h4>
								</div>
								<div class="form-group col-xs-12 col-xs-6">
									<h5>
										<i><%=personnage.getAlignement()%></i>
									</h5>
								</div>
							</div>
							<hr/>
							<div class="row">
								<div class="form-group col-xs-12 ">
									<h3 class="text-center">Points de compétence Restants : <br/></h3>
									<h1 class="text-center"><%=pointsCompetenceMax %></h2>
								</div>
							</div>


						</div>
					</div>
				</div>

			</div>
			<div class="row">
				<!-- COMPETENCES NON ACQUISES -->
				<div class="form-group col-xs-12 col-md-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>Compétences Non Acquises</strong>
						</div>
						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<th>Nom</th>
									<th>Carac. Assoc.</th>
									<th>Niveau</th>
								</thead>
								<tbody>
									<%
									    for (Competence c : competencesNonAcquises) {
									%>
									<tr data-toggle="modal" data-target="#<%=c.getNom().replace(' ', '_')%>">
										<td><%=c.getNom()%></td>
										<td><%=c.getCaracAssociee()%></td>
										<td><p class="col-xs-4 col-sm-3 col-md-4"><%=c.getNiveauCompetence()%> -></p> <input type="text" class="col-xs-3"
											name="<%=c.getNom()%>"
											placeholder="<%=c.getNiveauCompetence()%>"></td>
									</tr>
									<!-- Modal -->
									<div class="modal fade" id=<%=c.getNom().replace(' ', '_')%>>
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h4 class="modal-title"><%=c.getNom()%>
														: Description
													</h4>
												</div>
												<div class="modal-body">
													<p><%=c.getDescription()%></p>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Fermer</button>
												</div>
											</div>
										</div>
									</div>
									<%
									    }
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- COMPETENCES ACQUISES -->
				<div class="form-group col-xs-12 col-md-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>Compétences Acquises</strong>
						</div>
						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<th>Nom</th>
									<th>Carac. Assoc.</th>
									<th>Niveau</th>
								</thead>
								<tbody>
									<%
									    for (Competence c : competencesAcquises) {
									%>
									<tr data-toggle="modal" data-target="#<%=c.getNom().replace(' ', '_')%>">
										<td><%=c.getNom()%></td>
										<td><%=c.getCaracAssociee()%></td>
										<td><p class="col-xs-4 col-sm-3 col-md-4"><%=c.getNiveauCompetence()%> -></p> <input type="text" class="col-xs-3"
											name="<%=c.getNom()%>"
											placeholder="<%=c.getNiveauCompetence()%>"></td>
									</tr>
									<!-- Modal -->
									<div class="modal fade" id=<%=c.getNom().replace(' ', '_')%>>
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h4 class="modal-title"><%=c.getNom()%>
														: Description
													</h4>
												</div>
												<div class="modal-body">
													<p><%=c.getDescription()%></p>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Fermer</button>
												</div>
											</div>
										</div>
									</div>
									<%
									    }
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group form-inline col-xs-offset-3">
					<input type="button" class="btn btn-danger" name="action" value="Annuler" />
					<input type="button" class="btn btn-primary" name="action" value="Appliquer" />
					<input type="button" class="btn btn-success" name="action" value="Appliquer et Quitter" />
				</div>
			</div>
		</form>
	</div>
	
	
	
	</section> </section> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<jsp:include page="/site/include/import_script.jsp" />


</body>
</html>