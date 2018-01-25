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
<%@page
	import="fr.eseo.criticalPfe.java.model.scenario.Univers,fr.eseo.criticalPfe.java.model.scenario.Campagne,
	    	java.util.List"%>
<%
	List<Campagne> listeCampagne = (List<Campagne>) request.getSession().getAttribute("listeCampagne");
	Univers univers = (Univers) request.getSession().getAttribute("univers");
%>


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
	<section id="container"> <jsp:include
		page="../include/import_header.jsp" /> <jsp:include
		page="../include/import_aside.jsp" /> </section>

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
						<h4 style="color: white"><%=univers.getNomUnivers()%></h4>
					</div>
				</div>
				<div class="panel-body"
					style="background-color: rgba(255, 255, 255, 0.7);">

					<div class="form-horizontal"
						action="/Critical-PFE/CreationPersonnageServlet" method="post">
						<div class="form-group">
							<div class="container-fluid">
								<div class=" panel-group content content-boxed overflow-hidden">

									<!-- Personnage -->
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapse1">Informations générales :</a>
											</h4>
										</div>
										<div id="collapse1" class="panel-collapse collapse in">
											<form action="/Critical-PFE/UpdateUnivers" method="post"
												style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px">
												<div class="row">
													<div class="col-xs-2">
														<label class="control-label" for="nomUnivers"
															style="color: black;">Modifier le nom de
															l'univers :</label>
													</div>
													<div class="col-xs-3">
														<input type="text" class="form-control" id="nomUnivers"
															placeholder="<%=univers.getNomUnivers()%>"
															name="nomUnivers">
													</div>
												</div>
												<div class="row" style="margin-top: 10px">
													<textarea id="descriptionUnivers" name="descriptionUnivers"
														style="resize: none; height: 200px; width: 98%"><%=univers.getDescription()%></textarea>
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
												href="#collapse1">Gestion des campagnes :</a>
										</h4>
									</div>
									<div id="collapse1" class="panel-collapse collapse in">
										<div style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px">
											<div class="row">
												<%
													if (listeCampagne != null) {
														if (listeCampagne.size() > 0) {
												%>
												<table class="table table-hover">
													<thead>
														<tr>
															<th>Nom Campagne</th>
															<th>Modifier</th>
															<th>Supprimer</th>
														</tr>
													</thead>

													<tbody>
														<%
															for (Campagne campagne : listeCampagne) {
														%>

														<tr>
															<td><%=campagne.getNomCampagne()%></td>
															<td>
																<form class="form-horizontal" method="post"
																	action="/Critical-PFE/AfficherCampagne">
																	<input type="hidden" name="idCampagne" id="idCampagne"
																		value=<%=campagne.getId()%>>
																	<div class="form-group">
																		<button class="btn btn-theme btn-block" type="submit"
																			style="width: 150px;" id="submit_update_campagne"
																			value="update">Editer</button>
																	</div>
																</form>
															</td>
															<td>
																<form class="form-horizontal" method="post"
																	action="/Critical-PFE/SuppressionCampagne">
																	<input type="hidden" name="idUnivers" id="idUnivers"
																		value=<%=campagne.getId()%>>

																	<button class="btn btn-theme btn-block" type="submit"
																		style="width: 200px;" id="afficher univers">Supprimer
																		la campagne</button>
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
														action="/Critical-PFE/CreationCampagne">
														<div class="col-xs-3 col-xs-offset-9"
															style="padding-right: 20px">
															<button class="btn btn-theme btn-block" type="submit"
																id="submit_Creer campagne" value="Creer">Créer
																une nouvelle campagne</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<form class="form-horizontal" method="post"
										action="/Critical-PFE/AffichageListeUnivers">
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