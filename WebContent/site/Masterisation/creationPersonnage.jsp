<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.eseo.criticalPfe.java.model.entite.Classe" %>
<%@ page import="fr.eseo.criticalPfe.java.model.entite.Race" %>
<% List<Race> races = (ArrayList<Race>) session.getAttribute("races"); %>
<% List<Classe> classes = (ArrayList<Classe>) session.getAttribute("classes"); %>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">


<jsp:include page="../include/import_dashgum.jsp" />
<title>Critical</title>
</head>
<body class="bg-image"
	style="background-image: url('assets/img/login-bg.jpg');">
	
	<!--  Header et aside -->
	<section id="container"> <jsp:include
		page="../include/import_header.jsp" /> <jsp:include
		page="../include/import_aside.jsp" /> <!-- **********************************************************************************************************************************************************
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
					<h4 style="color: white">Cr�ation Personnage</h4>
				</div>
				<div class="panel-body"
					style="background-color: rgba(255, 255, 255, 0.7);">

					<form class="form-horizontal"
						action="/Critical-PFE/InsertionPersonnage" method="post">
						<div class="form-group">
							<div class="container-fluid">
								<div class=" panel-group content content-boxed overflow-hidden">

									<!-- Personnage -->
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapse1"> Personnage</a>
											</h4>
										</div>
										<div id="collapse1" class="panel-collapse collapse in">
											<div
												style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px">
												<div class="row">

													<label class="control-label col-xs-2" for="pseudo_ancien">Nom
														personnage :</label> <input type="text" id="nom" name="nom"
														class="champSaisie control-label col-xs-2" required />

												</div>

												<div class="row" style="margin-top: 10px">
													<label class="control-label col-xs-2" for="pseudo_ancien">Race
														:</label> <select name="race" id="race"
														class="control-label col-xs-2">
														<% for(Race r : races){ %>
															<option value=<%= r.getNom() %>><%= r.getNom() %></option>
														<%} %>
													</select> <label class="control-label col-xs-2" for="pseudo_ancien">Classe
														:</label> <select name="classe" id="classe"
														class="control-label col-xs-2		">
														<% for(Classe c : classes){ %>
															<option value=<%= c.getNom() %>><%= c.getNom() %></option>
														<%} %>
													</select>
												</div>

												<div class="row" style="margin-top: 10px">
													<label class="control-label col-xs-2" for="pseudo_ancien">Alignement
														:</label> <input type="text" id="alignement" name="alignement"
														class="champSaisie control-label col-xs-2" required/> <label
														class="control-label col-xs-2" for="pseudo_ancien">Dieu
														:</label> <select name="dieu" id="dieu"
														class="control-label col-xs-2">
														<!-- ATTENTION : Dieux cod�s en dur - � impl�menter sur la BDD+BO+DAO -->
														<option value=""></option>
														<optgroup label="Dieux majeurs">
															<option value="Abadar">Abadar</option>
															<option value="Asmodeus">Asmod�us</option>
															<option value="Calistria">Calistria</option>
															<option value="Cayden Cailean">Cayden Cail�an</option>
															<option value="Desna">Desna</option>
															<option value="�rastil">�rastil</option>
															<option value="Gorum">Gorum</option>
															<option value="Iomedae">Iom�dae</option>
															<option value="Irori">Irori</option>
															<option value="Lamashtu">Lamashtu</option>
															<option value="Nethys">N�thys</option>
															<option value="Norgorber">Norgorber</option>
															<option value="Pharasma">Pharasma</option>
															<option value="Rovagug">Rovagug</option>
															<option value="Sarenrae">Sarenrae</option>
															<option value="Shelyn">Sh�lyn</option>
															<option value="Torag">Torag</option>
															<option value="Urgathoa">Urgathoa</option>
															<option value="Zon-Kuthon">Zon-Kuthon</option>
														</optgroup>
														<optgroup label="Dieux mineurs">
															<option value="Achaekek">Acha�kek</option>
															<option value="Apsu">Apsu</option>
															<option value="Aroden">Aroden</option>
															<option value="Besmara">Besmara</option>
															<option value="Dahak">Dahak</option>
															<option value="Droskar">Droskar</option>
															<option value="Ghlaunder">Ghlaunder</option>
															<option value="Groetus">Gro�tus</option>
															<option value="Kurgess">Kurgess</option>
															<option value="Lissala">Lissala</option>
															<option value="Milani">Milani</option>
															<option value="Razmir">Razmir</option>
															<option value="Sivanah">Sivanah</option>
															<option value="Zyphus">Zyphus</option>
														</optgroup>
													</select>

												</div>
											</div>

										</div>
									</div>

									<!-- Apparence -->
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapse2"> Apparence</a>
											</h4>
										</div>
										<div id="collapse2" class="panel-collapse collapse in">
											<div
												style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px">
												<div class="row">

													<label class="control-label col-xs-2" for="pseudo_ancien">Sexe
														:</label> <select name="sexe" id="sexe"
														class="control-label col-xs-2">
														<option value="femme">Homme</option>
														<option value="homme">Femme</option>
													</select> <label class="control-label col-xs-2" for="pseudo_ancien">Age
														:</label> <input type="number" id="age" name="age"
														style="text-align: center" class="control-label col-xs-1" required />

													<div class="control-label col-xs-1">ans</div>
												</div>

												<div class="row"
													style="margin-top: 10px; margin-bottom: 10px">
													<label class="control-label col-xs-2" for="pseudo_ancien">Taille
														:</label> <input type="number" id="taille" name="taille"
														style="text-align: center" class="control-label col-xs-1" required/>
													<div class="control-label col-xs-1">cm</div>

													<label class="control-label col-xs-2" for="pseudo_ancien">Poids
														:</label> <input type="number" id="poids" name="poids"
														style="text-align: center" class="control-label col-xs-1" required/>
													<div class="control-label col-xs-1">kg</div>
												</div>

												<div class="row" style="margin-top: 10px">
													<label class="control-label col-xs-2" for="pseudo_ancien">Couleur
														yeux :</label> <input type="text" id="couleurYeux"
														name="couleurYeux"
														class="champSaisie control-label col-xs-2" required /> <label
														class="control-label col-xs-2" for="pseudo_ancien">Couleur
														cheveux :</label> <input type="text" id="couleurCheveux"
														name="couleurCheveux"
														class="champSaisie control-label col-xs-2" required />
												</div>
											</div>
										</div>
									</div>

									<!-- Caract�ristiques -->
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapse3"> Caract�ristiques</a>
											</h4>
										</div>
										<div id="collapse3" class="panel-collapse collapse in">
											<div
												style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px">
												<!-- Saisie des valeurs des caract�ristiques au moyen d'un menu d�roulant allant de 3 � 18 pour chaque carac -->
												<%
													String[] caracNomComplet = new String[] { "Force", "Dexterite", "Constitution", "Intelligence", "Sagesse", "Charisme" };
													String[] carac = new String[] { "for", "dex", "con", "int", "sag", "cha" };
													for (int i = 0; i < 6; i += 2) {
														out.println("<div class=\"row\" style=\"margin-top: 10px\">");
														out.println("<label class=\"control-label col-xs-2\" for=\"pseudo_ancien\">" + caracNomComplet[i]
																+ " :</label>");
														out.println(
																"<select name=\"" + carac[i] + "\" id=\"" + carac[i] + "\" class=\"control-label col-xs-1\">");
														for (int j = 3; j <= 18; j++) {
															String select = j == 10 ? "selected=\"selected\"" : "";
															out.println("<option " + select + " value=" + j + ">" + j + "</option>");
														}
														out.println("</select>");

														out.println("<label class=\"control-label col-xs-2 col-xs-offset-1\" for=\"pseudo_ancien\">"
																+ caracNomComplet[i + 1] + " :</label>");
														out.println("<select name=\"" + carac[i + 1] + "\" id=\"" + carac[i + 1]
																+ "\" class=\"control-label col-xs-1\">");
														for (int j = 3; j <= 18; j++) {
															String select = j == 10 ? "selected=\"selected\"" : "";
															out.println("<option " + select + " value=" + j + ">" + j + "</option>");
														}
														out.println("</select>");
														out.println("</div>");
													}
												%>
											</div>
										</div>
									</div>

						



								<div style="margin-top: 30px" class="text-center">
									<button type="submit" class=" btn btn-default">Cr�ation
										Personnage</button>
								</div>

							</div></div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</section> </section> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<jsp:include page="../include/import_script.jsp" />


</body>
</html>