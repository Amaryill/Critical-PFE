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
<%@page
	import="fr.eseo.criticalPfe.java.model.scenario.Univers, java.util.List"%>

<jsp:include page="../include/import_dashgum.jsp" />

<!-- Verification de la variable session -->
<%
	if (request.getSession().getAttribute("utilisateur") == null) {
		response.sendRedirect("login.jsp");
	}
	List<Univers> listeUnivers = (List<Univers>) request.getSession().getAttribute("listeUnivers");
%>

<title>Masterisation</title>
</head>
<body class="bg-image"
	style="background-image: url('../../assets/img/login-bg.jpg');">


	<!--  Header et aside -->

	<section id="container"> <jsp:include
		page="../include/import_header.jsp" /> <jsp:include
		page="../include/import_aside.jsp" /> <section id="main-content"
		class="wrapper">

	<div class="form-horizontal"
		style="margin-top: 20px; margin-left: 25px; margin-right:200px;  background-color: rgba(255, 255, 255, 0);">
		<div class="form-group col-xs-12"
			style="background-color: rgba(255, 255, 255, 0);">
			<div class="panel panel-default"
				style="background-color: rgba(255, 255, 255, 1);">
				<div class="panel-heading"
					style="background-color: rgba(66, 74, 93, 1);">
					<h4 style="color: white">Liste des univers :</h4>
				</div>

				<div class="panel-body"
					style="background-color: rgba(255, 255, 255, 0.7);">
					<div class="form-group">
						<div class="container-fluid">
							<div class=" panel-group content content-boxed overflow-hidden">

								<div class="panel-body"
									style="background-color: rgba(255, 255, 255, 0.7);"></div>
								<div class="card-body">
									<%
										if (listeUnivers != null) {
											if (listeUnivers.size() > 0) {
									%>
									<table class="table table-hover">
										<thead>
											<tr>
												<th>Nom Univers</th>
												<th>Modifier</th>
												<th>Supprimer</th>
											</tr>
										</thead>

										<tbody>
											<%
												for (Univers univers : listeUnivers) {
											%>

											<tr>
												<td><%=univers.getNomUnivers()%></td>
												<td>
													<form class="form-horizontal" method="post"
														action="/Critical-PFE/AfficherUnivers">
														<input type="hidden" name="idUnivers" id="idUnivers"
															value=<%=univers.getId()%>>
														<div class="form-group">
															<button class="btn btn-theme btn-block" type="submit"
																style="width: 150px;" id="submit_update_univers"
																value="update">Editer</button>
														</div>
													</form>
												</td>
												<td>
													<form class="form-horizontal" method="post"
														action="/Critical-PFE/SuppressionUnivers">
														<input type="hidden" name="idUnivers" id="idUnivers"
															value=<%=univers.getId()%>>

														<button class="btn btn-theme btn-block" type="submit"
															style="width: 150px;" id="afficher univers">Supprimer
															l'univers</button>
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
										<form class="form-horizontal col-xs-12" method="post"
											action="/Critical-PFE/CreationUnivers">
											<div class="col-xs-3 col-xs-offset-9">
												<button class="btn btn-theme btn-block" type="submit"
													id="submit_Creer univers" value="Creer">Créer un
													nouvel univers</button>
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
	</div>
	</section></section>


	<!-- js placed at the end of the document so the pages load faster -->
	<jsp:include page="../include/import_dashgum.jsp" />
</body>

</html>