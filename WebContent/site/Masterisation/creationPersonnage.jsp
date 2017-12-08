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

	
	    <jsp:include page="../include/import_dashgum.jsp" />
		<title>Critical</title>
</head>
<body class="bg-image"
	style="background-image: url('../../assets/img/CreationPerso-bg.png');">
	<!--  Header et aside -->
		<section id="container">
		
		<jsp:include page="../include/import_header.jsp" />
		<jsp:include page="../include/import_aside.jsp" />
	
			<!-- **********************************************************************************************************************************************************
	      MAIN CONTENT
	      *********************************************************************************************************************************************************** -->
		
			<section id="main-content">
				<section class="wrapper">
				<br><br>
				<h1 style="color:black;">Creation Personnage</h1>
			
				<form class="form-horizontal" action="/Critical-PFE/CreationPersonnageServlet"
					method="post">
					<div class="form-group">
						<div class="container">
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
										<div style="margin-top: 10px; margin-bottom: 10px">
											<div class="row">
				
												<label class="control-label col-xs-2" for="pseudo_ancien">Nom
													personnage :</label> <input type="text" id="nom" name="nom"
													class="champSaisie control-label col-xs-2" />
				
											</div>
				
											<div class="row" style="margin-top: 10px">
												<label class="control-label col-xs-2" for="pseudo_ancien">Race
													:</label> <select name="race" id="race" class="control-label col-xs-2">
													<option value="DemiElfe">Demi-elfe</option>
													<option value="DemiOrque">Demi-orque</option>
													<option value="Elfe">Elfe</option>
													<option value="Gnome">Gnome</option>
													<option value="Halfelin">Halfelin</option>
													<option value="Humain">Humain</option>
													<option value="Nain">Nain</option>
												</select> <label class="control-label col-xs-2" for="pseudo_ancien">Classe
													:</label> <select name="classe" id="classe"
													class="control-label col-xs-2		">
													<option value="Barbare">Barbare</option>
													<option value="Barde">Barde</option>
													<option value="Druide">Druide</option>
													<option value="Ensorceleur">Ensorceleur</option>
													<option value="Guerrier">Guerrier</option>
													<option value="Magicien">Magicien</option>
													<option value="Moine">Moine</option>
													<option value="Paladin">Paladin</option>
													<option value="Prêtre">Prêtre</option>
													<option value="Rodeur">Rodeur</option>
													<option value="Roublard">Roublard</option>
												</select>
											</div>
				
											<div class="row" style="margin-top: 10px">
											<label class="control-label col-xs-2" for="pseudo_ancien">Alignement
												:</label> <input type="text" id="alignement" name="alignement"
												class="champSaisie control-label col-xs-2" /> <label
												class="control-label col-xs-2" for="pseudo_ancien">Dieu
												:</label> <select name="dieu" id="dieu" class="control-label col-xs-2">
												<option value=""></option>
												<optgroup label="Dieux majeurs">
													<option value="Abadar">Abadar</option>
													<option value="Asmodeus">Asmodéus</option>
													<option value="Calistria">Calistria</option>
													<option value="Cayden Cailean">Cayden Cailéan</option>
													<option value="Desna">Desna</option>
													<option value="Érastil">Érastil</option>
													<option value="Gorum">Gorum</option>
													<option value="Iomedae">Iomédae</option>
													<option value="Irori">Irori</option>
													<option value="Lamashtu">Lamashtu</option>
													<option value="Nethys">Néthys</option>
													<option value="Norgorber">Norgorber</option>
													<option value="Pharasma">Pharasma</option>
													<option value="Rovagug">Rovagug</option>
													<option value="Sarenrae">Sarenrae</option>
													<option value="Shelyn">Shélyn</option>
													<option value="Torag">Torag</option>
													<option value="Urgathoa">Urgathoa</option>
													<option value="Zon-Kuthon">Zon-Kuthon</option>
												</optgroup>
												<optgroup label="Dieux mineurs">
													<option value="Achaekek">Achaékek</option>
													<option value="Apsu">Apsu</option>
													<option value="Aroden">Aroden</option>
													<option value="Besmara">Besmara</option>
													<option value="Dahak">Dahak</option>
													<option value="Droskar">Droskar</option>
													<option value="Ghlaunder">Ghlaunder</option>
													<option value="Groetus">Groétus</option>
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
										<div style="margin-top: 10px; margin-bottom: 10px">
											<div class="row">
				
												<label class="control-label col-xs-2" for="pseudo_ancien">Sexe
													:</label> <select name="sexe" id="sexe" class="control-label col-xs-2">
													<option value="femme">Homme</option>
													<option value="homme">Femme</option>
												</select> <label class="control-label col-xs-2" for="pseudo_ancien">Age
													:</label> <input type="number" id="age" name="age"
													style="text-align: center" class="control-label col-xs-1" />
				
												<div class="control-label col-xs-1">ans</div>
											</div>
				
											<div class="row" style="margin-top: 10px; margin-bottom: 10px">
												<label class="control-label col-xs-2" for="pseudo_ancien">Taille
													:</label> <input type="number" id="taille" name="taille" style="text-align: center"
													class="control-label col-xs-1" />
												<div class="control-label col-xs-1">cm</div>
				
												<label class="control-label col-xs-2" for="pseudo_ancien">Poids
													:</label> <input type="number" id="poids" name="poids" style="text-align: center"	
													class="control-label col-xs-1" />
												<div class="control-label col-xs-1">kg</div>
											</div>
				
											<div class="row" style="margin-top: 10px">
											<label class="control-label col-xs-2" for="pseudo_ancien">Couleur
												yeux :</label> <input type="text" id="couleurYeux" name="couleurYeux"
												class="champSaisie control-label col-xs-2" /> <label
												class="control-label col-xs-2" for="pseudo_ancien">Couleur
												cheveux :</label> <input type="text" id="couleurCheveux"
												name="couleurCheveux" class="champSaisie control-label col-xs-2" /> 
										</div>
										</div>
									</div>
								</div>
								
								<!-- Caractéristiques -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapse3"> Caractéristiques</a>
										</h4>
									</div>
									<div id="collapse3" class="panel-collapse collapse in">
										<div style="margin-top: 10px; margin-bottom: 10px">
											<!-- Saisie des valeurs des caractéristiques au moyen d'un menu déroulant allant de 3 à 18 pour chaque carac -->
											<%
											String[] caracNomComplet = new String[] { "Force", "Intelligence", "Dexterite", "Sagesse", "Constitution",
													"Charisme" };
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
							
								<!-- Compétences -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapse4"> Compétences</a>
										</h4>
									</div>
									<div id="collapse4" class="panel-collapse collapse in">
										<div style="margin-top: 10px; margin-bottom: 10px">
											<div class="row">
				
												<label class="control-label col-xs-2" for="pseudo_ancien">Nom
													personnage :</label> <input type="text" id="nom" name="nom"
													class="champSaisie control-label col-xs-2" />
				
											</div>
				
											<div class="row" style="margin-top: 10px">
												<label class="control-label col-xs-2" for="pseudo_ancien">Race
													:</label> <select name="race" id="race" class="control-label col-xs-2">
													<option value="DemiElfe">Demi-elfe</option>
													<option value="DemiOrque">Demi-orque</option>
													<option value="Elfe">Elfe</option>
													<option value="Gnome">Gnome</option>
													<option value="Halfelin">Halfelin</option>
													<option value="Humain">Humain</option>
													<option value="Nain">Nain</option>
												</select> <label class="control-label col-xs-2" for="pseudo_ancien">Classe
													:</label> <select name="classe" id="classe"
													class="control-label col-xs-2		">
													<option value="Barbare">Barbare</option>
													<option value="Barde">Barde</option>
													<option value="Druide">Druide</option>
													<option value="Ensorceleur">Ensorceleur</option>
													<option value="Guerrier">Guerrier</option>
													<option value="Magicien">Magicien</option>
													<option value="Moine">Moine</option>
													<option value="Paladin">Paladin</option>
													<option value="Prêtre">Prêtre</option>
													<option value="Rodeur">Rodeur</option>
													<option value="Roublard">Roublard</option>
												</select>
											</div>
				
											<div class="row" style="margin-top: 10px">
											<label class="control-label col-xs-2" for="pseudo_ancien">Alignement
												:</label> <input type="text" id="alignement" name="alignement"
												class="champSaisie control-label col-xs-2" /> <label
												class="control-label col-xs-2" for="pseudo_ancien">Dieu
												:</label> <select name="dieu" id="dieu" class="control-label col-xs-2">
												<option value=""></option>
												<optgroup label="Dieux majeurs">
													<option value="Abadar">Abadar</option>
													<option value="Asmodeus">Asmodéus</option>
													<option value="Calistria">Calistria</option>
													<option value="Cayden Cailean">Cayden Cailéan</option>
													<option value="Desna">Desna</option>
													<option value="Érastil">Érastil</option>
													<option value="Gorum">Gorum</option>
													<option value="Iomedae">Iomédae</option>
													<option value="Irori">Irori</option>
													<option value="Lamashtu">Lamashtu</option>
													<option value="Nethys">Néthys</option>
													<option value="Norgorber">Norgorber</option>
													<option value="Pharasma">Pharasma</option>
													<option value="Rovagug">Rovagug</option>
													<option value="Sarenrae">Sarenrae</option>
													<option value="Shelyn">Shélyn</option>
													<option value="Torag">Torag</option>
													<option value="Urgathoa">Urgathoa</option>
													<option value="Zon-Kuthon">Zon-Kuthon</option>
												</optgroup>
												<optgroup label="Dieux mineurs">
													<option value="Achaekek">Achaékek</option>
													<option value="Apsu">Apsu</option>
													<option value="Aroden">Aroden</option>
													<option value="Besmara">Besmara</option>
													<option value="Dahak">Dahak</option>
													<option value="Droskar">Droskar</option>
													<option value="Ghlaunder">Ghlaunder</option>
													<option value="Groetus">Groétus</option>
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
							</div>
							

			
							<div style="margin-top: 30px" class="text-center">
								<button type="submit"
									class=" btn btn-default">Création
									Personnage</button>
							</div>
			
						</div>
			
					</div>
				</form>
			</section>
		</section>
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
		<jsp:include page="../include/import_script.jsp" />
			

</body>
</html>