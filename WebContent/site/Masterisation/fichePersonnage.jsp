
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

<%@ page import="fr.eseo.criticalPfe.java.bo.entite.PersonnageBO"%>
<%@ page import="fr.eseo.criticalPfe.java.bo.entite.PersonnageBOImpl"%>
<%@ page import="fr.eseo.criticalPfe.java.model.entite.Personnage"%>
<%@ page import="fr.eseo.criticalPfe.java.model.attributs.Competence"%>
<%@ page import="fr.eseo.criticalPfe.java.model.attributs.Sort"%>
<%@ page import="fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%
	/* Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
	PersonnageBO boPersonnage = new PersonnageBOImpl();
	Personnage personnage = new Personnage();
	personnage.setId(Integer.parseInt(request.getParameter("id")));
	personnage = boPersonnage.trouverPersonnage(personnage); */

	//TODO Mettre tout ceci dans un servlet et appeler session.getAttribute(<nomAttribut>),
	//     on ne fait pas de recherche sur la bdd dans une vue!
%>

<%
	Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
%>
<%
	Personnage personnage = (Personnage) session.getAttribute("personnageCourant");
%>

<%
	List<Competence> competencesAcquises = (List<Competence>) session.getAttribute("competencesAcquises");
%>
<%
	List<Competence> competencesNonAcquises = (List<Competence>) session.getAttribute("competencesNonAcquises");
%>
<%
	int pointsCompetenceMax = (Integer) session.getAttribute("pointsCompRestants");
%>

<%
	List<Sort> sortsApprenables = (List<Sort>) session.getAttribute("sortsApprenables");
%>




<jsp:include page="../include/import_dashgum.jsp" />

<title>Critical</title>
</head>
<body class="bg-image"
	style="background-image: url('assets/img/login-bg.jpg');">

	<!--  Header et aside -->
	<section id="container"> <jsp:include
		page="../include/import_header.jsp" /> <jsp:include
		page="../include/import_aside.jsp" /> <section id="main-content">
	<section class="wrapper">



	<div class="form-horizontal"
		style="margin-top: 20px; margin-left: 25px; background-color: rgba(0, 0, 0, 0);">
		<div class="form-group col-xs-12"
			style="background-color: rgba(0, 0, 0, 0);">
			<div class="panel panel-default"
				style="background-color: rgba(0, 0, 0, 0);">
				<div class="panel-heading"
					style="background-color: rgba(66, 74, 93, 1);">
					<h4 style="color: white">
						Fiche Personnage :
						<%=personnage.getNom()%>, niv
						<%=personnage.getNiveau()%></h4>
				</div>
				<div class="panel-body"
					style="background-color: rgba(255, 255, 255, 0.7);">
					<ul
						class="nav nav-tabs navbar-default nav-justified container-fluid">
						<li class="active"><a data-toggle="tab" href="#home">Description</a></li>
						<li><a data-toggle="tab" href="#menu1">Caractéristiques</a></li>
						<li><a data-toggle="tab" href="#menu2">Inventaire</a></li>
						<li><a data-toggle="tab" href="#menu3">Compétences</a></li>
						<li><a data-toggle="tab" href="#menu4">Sorts</a></li>
					</ul>

					<div class="tab-content">
						<div id="home" class="tab-pane fade in active"
							style="margin-top: 30px">
							<div class="row" style="margin-top: 15px">
								<label class="control-label col-xs-2" for="pseudo_ancien">Race
									:</label> <input type="text" id="nom" name="nom"
									class="control-label col-xs-2 champLecture"
									value='<%=personnage.getRace().getNom()%>' readonly /> <label
									class="control-label col-xs-2" for="pseudo_ancien">Classe
									:</label> <input type="text " id="nom" name="nom"
									class="control-label col-xs-2 champLecture"
									value="<%=session.getAttribute("texteClasses")%>" readonly />
							</div>
							<div class="row" style="margin-top: 15px">

								<label class="control-label col-xs-2" for="pseudo_ancien">Alignement
									:</label> <input type="text" id="nom" name="nom"
									class="control-label col-xs-2 champLecture"
									value='<%=personnage.getAlignement()%>' readonly /> <label
									class="control-label col-xs-2" for="pseudo_ancien">Dieu
									:</label> <input type="text" id="nom" name="nom"
									class="control-label col-xs-2 champLecture"
									value='<%=personnage.getDieu()%>' readonly />
							</div>
						</div>

						<div id="menu1" class="tab-pane fade" style="margin-top: 30px">
							<%
								String[] caracNomComplet = new String[] { "Force", "Intelligence", "Dexterite", "Sagesse", "Constitution",
										"Charisme" };
								String[] carac = new String[] { "for", "dex", "con", "int", "sag", "cha" };
								for (int i = 0; i < 6; i += 2) {
									out.println("<div class=\"row\" style=\"margin-top: 10px\">");
									out.println("<label class=\"control-label col-xs-2 col-xs-offset-1\" for=\"pseudo_ancien\">"
											+ caracNomComplet[i] + " :</label>");
									out.println("<input type=\"text\" name=\"" + carac[i] + "\" id=\"" + carac[i]
											+ "\" class=\"control-label col-xs-1 champLecture\" value='"
											+ personnage.getCaracteristique().getCaracs().get(carac[i]) + "' readonly/>");
									out.println("<label class=\"control-label col-xs-2 col-xs-offset-2\" for=\"pseudo_ancien\">"
											+ caracNomComplet[i + 1] + " :</label>");
									out.println("<input type=\"text\" name=\"" + carac[i + 1] + "\" id=\"" + carac[i + 1]
											+ "\" class=\"control-label col-xs-1 champLecture\" value='"
											+ personnage.getCaracteristique().getCaracs().get(carac[i + 1]) + "' readonly/>");
									out.println("</div>");
								}
							%>
						</div>

						<div id="menu2" class="tab-pane fade col-xs-offset-1"
							style="margin-top: 30px">
							<p>menu2</p>
						</div>

						<!-- MENU COMPETENCES -->
						<div id="menu3" class="tab-pane fade col-xs-offset-1"
							style="margin-top: 30px">
							<div class="row">
								<div
									class="panel panel-default col-xs-12 col-sm-12 col-md-6 col-md-offset-3">
									<div class="panel-body">
										<h3 class="text-center">
											Points de compétence Restants : <br />
										</h3>
										<h1 class="text-center"><%=pointsCompetenceMax%></h1>
										<%
											if (pointsCompetenceMax == 0) {
										%>
										<form action="/Critical-PFE/ChoixCompetences" method="get">
											<input type="hidden" name="id"
												value="<%=personnage.getId()%>"> <input
												class="button col-xs-6 col-xs-offset-3" type="submit"
												value="Gérer mes compétences" />
										</form>
										<%
											}
										%>
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
													<tr data-toggle="modal"
														data-target="#<%=c.getNom().replace(' ', '_')%>">
														<td><%=c.getNom()%></td>
														<td><%=c.getCaracAssociee()%></td>
														<td><p class="col-xs-4 col-sm-3 col-md-4"><%=c.getNiveauCompetence()%>
															</p></td>
													</tr>
													<!-- Modal -->
													<div class="modal fade"
														id=<%=c.getNom().replace(' ', '_')%>>
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal">&times;</button>
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
											<%
												if (competencesAcquises.size() > 0) {
											%>
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
													<tr data-toggle="modal"
														data-target="#<%=c.getNom().replace(' ', '_')%>">
														<td><%=c.getNom()%></td>
														<td><%=c.getCaracAssociee()%></td>
														<td><p class="col-xs-4 col-sm-3 col-md-4"><%=c.getNiveauCompetence()%></p></td>
													</tr>
													<!-- Modal -->
													<div class="modal fade"
														id=<%=c.getNom().replace(' ', '_')%>>
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal">&times;</button>
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
											<%
												} else {
											%>
											<h3>Aucune Compétence Acquise...</h3>
											<%
												}
											%>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="menu4" class="tab-pane fade col-xs-offset-1"
							style="margin-top: 30px">
							<div class="form-group col-xs-12 col-md-10">
								<div class="panel panel-default">
									<div class="panel-heading">
										<strong>Sorts acquis</strong>
									</div>
									<div class="panel-body">
										<%
											if (personnage.getSorts() != null) {
										%>
										<h4>
											<strong>Liste des sorts apprenable</strong>
										</h4>

										<table class="table table-hover">
											<thead>
												<th>Nom</th>
												<th>Ecole</th>
												<th>Composante</th>
												<th>Portee</th>
												<th>Cible</th>
											</thead>
											<tbody>
												<%
													List<Sort> sorts = personnage.getSorts();
														for (int i = 0; i < sorts.size(); i++) {
												%>
												<tr>
													<td><a href=<%=sorts.get(i).getReference()%>
														target="_blank"><%=sorts.get(i).getNom()%></a></td>
													<td><%=sorts.get(i).getEcole()%></td>
													<td><%=sorts.get(i).getComposantes()%></td>
													<td><%=sorts.get(i).getPortee()%></td>
													<td><%=sorts.get(i).getCible()%></td>
												</tr>
												<%
													}
												%>
											</tbody>
										</table>
										<%
											} else {
												out.println("<h4>Le personnage n'a appris aucun sort</h4>");
											}
										%>
										<!-- Trigger the modal with a button -->
										<button type="button" class="btn btn-info btn-lg"
											data-toggle="modal" data-target="#myModal">Apprendre
											des sorts</button>

										<!-- Modal -->
										<div id="myModal" class="modal fade" role="dialog">
											<div class="modal-dialog modal-lg">

												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">Sorts</h4>
													</div>
													<div class="modal-body">
														<form action="/Critical-PFE/ApprendreSort" method="post">


															<h4>
																<strong>Liste des sorts apprenable</strong>
															</h4>
															<%
																if (sortsApprenables.size() > 0) {
															%>
															<table class="table table-hover">
																<thead>
																	<th>Nom</th>
																	<th>Ecole</th>
																	<th>Composante</th>
																	<th>Portee</th>
																	<th>Cible</th>
																	<th></th>
																</thead>
																<tbody>
																	<%
																		for (Sort s : sortsApprenables) {
																	%>
																	<tr>
																		<td><a href=<%=s.getReference()%> target="_blank"><%=s.getNom()%></a></td>
																		<td><%=s.getEcole()%></td>
																		<td><%=s.getComposantes()%></td>
																		<td><%=s.getPortee()%></td>
																		<td><%=s.getCible()%></td>
																		<td><input type="checkbox"
																			name="sortSelectionnes" value="<%=s.getNom()%>"></td>
																	</tr>
																	<%
																		}
																	%>
																</tbody>
															</table>
															<%
																}
															%>
															<input class="btn btn-primary" type="submit"
																value="Sauvegarder">
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Annuler</button>
														</form>
													</div>
													<div class="modal-footer"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section> </section> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<jsp:include page="../include/import_script.jsp" />

	<form method="post" action="../DemandeAmis"></form>

</body>
</html>