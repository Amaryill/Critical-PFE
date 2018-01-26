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

<jsp:include page="/site/include/import_dashgum.jsp" />

<!-- importation des classes -->
<%@page import="fr.eseo.criticalPfe.java.model.scenario.Campagne"%>
<%@page import="fr.eseo.criticalPfe.java.model.scenario.Session"%>
<%@page import="fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<!-- Verification de la variable session -->
<%
	if (request.getSession().getAttribute("utilisateur") == null) {
		response.sendRedirect("login.jsp");
	}
	Campagne campagne = (Campagne) request.getSession().getAttribute("campagne");
	List<Session> listeSession = (List<Session>) request.getSession().getAttribute("listeSession");
%>

<title>Campagne</title>
</head>

<body class="bg-image"
	style="background-image: url('../../assets/img/login-bg.jpg');">

	<!--  Header et aside -->
	<section id="container"> <jsp:include
		page="/site/include/import_header.jsp" /> <jsp:include
		page="/site/include/import_aside.jsp" /> </section>
	<!-- **********************************************************************************************************************************************************
	      MAIN CONTENT
	      *********************************************************************************************************************************************************** -->
	<section id="main-content"> <section class="wrapper">
	<div class="form-horizontal"
		style="margin-top: 20px; margin-left: 25px; background-color: rgba(0, 0, 0, 0);">
		<div class="form-group col-xs-12"
			style="background-color: rgba(0, 0, 0, 0);">
			<div class="panel panel-default"
				style="background-color: rgba(0, 0, 0, 0);">
				<div class="panel-heading"
					style="background-color: rgba(66, 74, 93, 1);">
					<div id="my-content" contenteditable="true">
						<h4 style="color: white"><%=campagne.getNomCampagne()%></h4>
					</div>
				</div>
				<div class="panel-body"
					style="background-color: rgba(255, 255, 255, 0.7);">

					<div class="form-horizontal">
						<div class="form-group">
							<div class="container-fluid">
								<div class=" panel-group content content-boxed overflow-hidden">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapse1">Informations générales :</a>
											</h4>
										</div>
										<div id="collapse1" class="panel-collapse collapse in">
											<form action="/Critical-PFE/UpdateCampagne" method="post"
												style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px">
												<div class="row">
													<div class="col-xs-3">
														<label class="control-label" for="nomCampagne"
															style="color: black;">Modifier le nom de la
															campagne :</label>
													</div>
													<div class="col-xs-3">
														<input type="text" class="form-control" id="nomCampagne"
															name="nomCampagne"
															placeholder="<%=campagne.getNomCampagne()%>"
															name="nomUnivers">
													</div>
												</div>
												<div class="row" style="margin-top: 10px">
													<textarea id="descriptionCampagne"
														name="descriptionCampagne"
														style="resize: none; height: 200px; width: 98%"><%=campagne.getDescription()%></textarea>
												</div>
												<div class="row" style="margin-top: 10px">

													<div class="col-xs-3 col-xs-offset-9"
														style="padding-right: 20px">
														<button type="submit" class="btn btn-theme btn-block">Sauvegarder</button>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapse1">Gestion des sessions :</a>
										</h4>
									</div>
									<div id="collapse1" class="panel-collapse collapse in">
										<div
											style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px">
											<div class="row">
												<%
													if (listeSession != null) {
														if (listeSession.size() > 0) {
												%>
												<table class="table table-hover">
													<thead>
														<tr>
															<th>Nom de la session</th>
															<th>Date</th>
															<th>Gestion Participant</th>
															<th>Suppression</th>
														</tr>
													</thead>

													<tbody>
														<%
															for (Session sessionJeu : listeSession) {
														%>

														<tr>
															<td><%=sessionJeu.getNomSession()%></td>
															<td><%=sessionJeu.getDateSession()%></td>
															<td><div>
																	<button type="button" class="btn btn-theme btn-block"
																		style="width: 200px" data-toggle="modal"
																		data-target="#myModal">Gérer Participants</button>
																	<!-- Modal -->
																	<div id="myModal" class="modal fade" role="dialog">
																		<div class="modal-dialog modal-lg">

																			<!-- Modal content-->
																			<div class="modal-content">
																				<div class="modal-header">
																					<button type="button" class="close"
																						data-dismiss="modal">&times;</button>
																					<h4 class="modal-title">Liste des participants</h4>
																				</div>
																				<div class="modal-body">
																					<form action="/Critical-PFE/AjoutParticipant"
																						method="post">

																						<%
																							List<Utilisateur> participants = new ArrayList<Utilisateur>(
																												sessionJeu.getEtatParticipant().keySet());
																										if (participants.size() > 0) {
																						%>
																						<table class="table table-hover">
																							<thead>
																								<th>Nom participant</th>
																							</thead>
																							<tbody>
																								<%
																									for (Utilisateur participant : participants) {
																								%>
																								<tr>
																									<td><%=participant.getPseudo()%></td>
																								</tr>
																								<%
																									}
																								%>
																							</tbody>
																						</table>
																						<%
																							}
																						%>
																						<div class="col-xs-12">
																							<input type="text" name="pseudo" id="pseudo">
																							<input type="hidden" name="idSession"
																								id="idSession" value=<%=sessionJeu.getId()%>>
																							<button class="btn btn-theme" type="submit"
																								id="submit_Creer campagne" value="Creer">Ajouter
																								Participant</button>
																						</div>
																						<div class="col-xs-12">
																							<button type="button" class="btn btn-default"
																								data-dismiss="modal">Annuler</button>
																						</div>
																					</form>
																				</div>
																				<div class="modal-footer"></div>
																			</div>
																		</div>
																	</div>
																</div></td>
															<td>
																<form class="form-horizontal" method="post"
																	action="/Critical-PFE/SuppressionSession">
																	<input type="hidden" name="idSession" id="idSession"
																		value=<%=sessionJeu.getId()%>>

																	<button class="btn btn-theme btn-block" type="submit"
																		style="width: 100px;" id="afficher univers">Supprimer</button>
																</form>
															</td>
														</tr>
														<%
															}
														%>
													</tbody>
												</table>
												<%
													}
													}
												%>

												<div class="text-center">
													<form class="form-horizontal" method="post"
														action="/Critical-PFE/CreationSession">
														<div class="col-xs-3 col-xs-offset-9"
															style="padding-right: 20px">
															<input type="hidden" name="idUnivers" id="idCampagne"
																value=<%=campagne.getId()%>>

															<button class="btn btn-theme btn-block" type="submit"
																id="submit_Creer campagne" value="Creer">Créer
																une nouvelle session</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<form class="form-horizontal" method="post"
										action="/Critical-PFE/AfficherUnivers">
										<div class="col-xs-3 col-xs-offset-9"
											style="padding-right: 10px">
											<button class="btn btn-theme btn-block" type="submit"
												id="afficher univers">Retour</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section> </section>

	<jsp:include page="/site/include/import_script.jsp" />
</body>


</html>