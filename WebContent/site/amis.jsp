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


<jsp:include page="include/import_dashgum.jsp" />

<!-- Verification de la variable session -->
<%
	if (request.getSession().getAttribute("utilisateur") == null) {
		response.sendRedirect("login.jsp");
	}

	ArrayList<String> listeAmis = (ArrayList<String>) request.getSession().getAttribute("amis");
	ArrayList<String> demandesEnvoyees = (ArrayList<String>) request.getSession()
			.getAttribute("demandesEnvoyees");
	ArrayList<String> demandesRecues = (ArrayList<String>) request.getSession().getAttribute("demandesRecues");
%>


<%@ page import="java.util.ArrayList"%>


<title>Amis</title>
</head>
<body class="bg-image"
	style="background-image: url('assets/img/login-bg.jpg');">

	<!--  Header et aside -->
	<section id="container"> <jsp:include
		page="include/import_header.jsp" /> <jsp:include
		page="include/import_aside.jsp" />
	</section>	
	<section id="main-content">
	<section class="wrapper">

	<div class="form-horizontal"
		style="margin-top: 20px; margin-left: 25px; background-color: rgba(0, 0, 0, 0);">
		<div class="form-group col-xs-12"
			style="background-color: rgba(0, 0, 0, 0);">
			<div class="panel panel-default"
				style="background-color: rgba(0, 0, 0, 0);">
				<div class="panel-heading"
					style="background-color: rgba(66, 74, 93, 1);">
					<h4 style="color: white">Gestion des amis</h4>
				</div>
				<div class="panel-body form-horizontal"
					style="background-color: rgba(255, 255, 255, 0.7);">

					<div class="form-group">
						<div class="container-fluid">
							<div class=" panel-group content content-boxed overflow-hidden">

								<!-- Ajouter un ami -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h5 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapse1">Ajout d'ami :</a>
										</h5>
									</div>
									<div id="collapse1" class="panel-collapse collapse in">
										<div
											style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px">
											<form method="post" action="/Critical-PFE/DemandeAmis">
												<div class="row" style="margin-left: 10px">
													<div class="col-xs-2">
														<input type="text" class="form-control" id="pseudo"
															placeholder="Pseudo du nouvel amis" name="pseudo">
													</div>
													<div class="col-xs-4 col-xs-offset-1">
														<button class="form-control" name="submit" type="submit"
															id="submit_demandeAmi" value="ajouter un ami">Envoyer
															la demande d'ami</button>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>


								<div class="panel panel-default">
									<div class="panel-heading">
										<h5 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapse2">Mes amis :</a>
										</h5>
									</div>
									<div id="collapse2" class="panel-collapse collapse in">
										<div
											style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px">
											<%
												if (listeAmis.size() == 0) {
													out.print("HO ... Il a pas d'amis ... LOOSER !");
												} else {
													for (int i = 0; i < listeAmis.size(); i++) {
											%>
											<div class="row" style="margin-left: 10px">
												<h4 style="color: black" class="col-xs-2">
													<%
														out.print(listeAmis.get(i));
													%>
												</h4>
												<form method="post" action="/Critical-PFE/SupprimerAmis">
													<div class="col-xs-4 col-xs-offset-1">
														<button type="hidden" name="pseudo" class="form-control"
															value=<%=listeAmis.get(i)%> type="submit"
															id="submit_supprimerAmi" value="Supprimer">supprimer
															l'amitié</button>
													</div>
												</form>
											</div>
											<%
												}
												}
											%>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h5 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapse3">Demandes reçues :</a>
										</h5>
									</div>
									<div id="collapse3" class="panel-collapse collapse in">
										<div
											style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px">
											<%
												if (demandesRecues.size() == 0) {
													out.print("Tu as vraiment cru	 que quelqu'un désirait être ton ami ? *Halala ... Qu'il est naïf*");
												} else {
													for (int i = 0; i < demandesRecues.size(); i++) {
											%>
											<div class="row" style="margin-left: 10px">

												<h4 style="color: black" class="col-xs-2">
													<%
														out.println(demandesRecues.get(i));
													%>
												</h4>
												<form method="post" action="/Critical-PFE/ValiderAmis">
													<div class="col-xs-2 col-xs-offset-1">
														<button type="hidden" name="pseudo"
															value=<%=demandesRecues.get(i)%> type="submit"
															class="form-control" id="submit_validerDemande"
															value="Modifier">valider la demande</button>
													</div>
												</form>
												<form method="post" action="/Critical-PFE/SupprimerAmis">
													<div class="col-xs-2">
														<button type="hidden" name="pseudo"
															value=<%=demandesRecues.get(i)%> type="submit"
															class="form-control" id="submit_refuserDemande"
															value="Modifier">refuser la demande</button>
													</div>
												</form>
												<%
													}
													}
												%>
											</div>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h5 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapse4">Demandes envoyées :</a>
										</h5>
									</div>
									<div id="collapse4" class="panel-collapse collapse in">
										<div
											style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px">
											<%
												if (demandesEnvoyees.size() == 0) {
													out.print("Tu es sûr d'avoir assez d'amis ? Dans ce cas va donc jouer une partie !");
												} else {
													for (int i = 0; i < demandesEnvoyees.size(); i++) {
											%>

											<div class="row" style="margin-left: 10px">
												<h4 style="color: black" class="col-xs-2">
													<%
														out.println(demandesEnvoyees.get(i));
													%>
												</h4>
												<form method="post" action="/Critical-PFE/SupprimerAmis">
													<div class="col-xs-4 col-xs-offset-1">
														<button type="hidden" name="pseudo"
															value=<%=demandesEnvoyees.get(i)%> type="submit"
															class="form-control" id="submit_annulerDemande"
															value="Modifier">annuler la demande</button>
													</div>
												</form>
											</div>
											<%
												}
												}
											%>
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
	</section> </section> 
	<!-- js placed at the end of the document so the pages load faster -->
	<jsp:include page="include/import_script.jsp" />
</body>

</html>