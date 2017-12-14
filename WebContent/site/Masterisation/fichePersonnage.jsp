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
<%@ page import="fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur"%>
<%
	Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
	PersonnageBO boPersonnage = new PersonnageBOImpl();
	Personnage personnage = new Personnage();
	personnage.setId(Integer.parseInt(request.getParameter("id")));
	personnage = boPersonnage.trouverPersonnage(personnage); %>



<jsp:include page="../include/import_dashgum.jsp" />

<title>Critical</title>
</head>
<body class="bg-image"
	style="background-image: url('../../assets/img/login-bg.jpg');">

	<!--  Header et aside -->
	<section id="container"> <jsp:include
		page="../include/import_header.jsp" /> <jsp:include
		page="../include/import_aside.jsp" /> <section id="main-content">
	<section class="wrapper">



	<form class="form-horizontal" style="margin-top:20px;margin-left:25px;background-color:rgba(0, 0, 0, 0);">
		<div class="form-group col-xs-12" style="background-color:rgba(0, 0, 0, 0);">
			<div class="panel panel-default" style="background-color:rgba(0, 0, 0, 0);">
				<div class="panel-heading" style="background-color:rgba(66, 74, 93, 1);">
					<h4 style="color:white">Fiche Personnage : <%=personnage.getNom()%>, niv <%=personnage.getNiveau()%></h4> 
				</div> 
				<div class="panel-body" style="background-color:rgba(255, 255, 255, 0.7);">
					<ul class="nav nav-tabs navbar-default nav-justified container-fluid">
						<li class="active"><a data-toggle="tab" href="#home">Description</a></li>
						<li><a data-toggle="tab" href="#menu1">Caractéristiques</a></li>
						<li><a data-toggle="tab" href="#menu2">Inventaire</a></li>
						<li><a data-toggle="tab" href="#menu3">Compétences</a></li>
					</ul>

					<div class="tab-content">
						<div id="home" class="tab-pane fade in active"
							style="margin-top: 30px">
							<div class="row" style="margin-top: 15px">
								<label class="control-label col-xs-2" for="pseudo_ancien">Race
									:</label> <input type="text" id="nom" name="nom"
									class="control-label col-xs-2 champLecture" value='<%=personnage.getRace().getNom() %>' readonly />
								<label class="control-label col-xs-2" for="pseudo_ancien">Classe
									:</label> <input type="text " id="nom" name="nom"
									class="control-label col-xs-2 champLecture" value="a" readonly />
							</div>
							<div class="row" style="margin-top: 15px">

								<label class="control-label col-xs-2" for="pseudo_ancien">Alignement
									:</label> <input type="text" id="nom" name="nom"
									class="control-label col-xs-2 champLecture" value='<%=personnage.getAlignement()%>' readonly />
								<label class="control-label col-xs-2" for="pseudo_ancien">Dieu
									:</label> <input type="text" id="nom" name="nom"
									class="control-label col-xs-2 champLecture" value='<%=personnage.getDieu()%>' readonly />
							</div>
						</div>

						<div id="menu1" class="tab-pane fade" style="margin-top: 30px">
							<%
								String[] caracNomComplet = new String[] { "Force", "Intelligence", "Dexterite", "Sagesse", "Constitution",
										"Charisme" };
								String[] carac = new String[] { "for", "dex", "con", "int", "sag", "cha" };
								for (int i = 0; i < 6; i += 2) {
									out.println("<div class=\"row\" style=\"margin-top: 10px\">");
									out.println("<label class=\"control-label col-xs-2 col-xs-offset-1\" for=\"pseudo_ancien\">" + caracNomComplet[i]
											+ " :</label>");
									out.println("<input type=\"text\" name=\"" + carac[i] + "\" id=\"" + carac[i]
											+ "\" class=\"control-label col-xs-1 champLecture\" value='"+personnage.getCaracteristique().getCaracs().get(carac[i])+"' readonly/>");
									out.println("<label class=\"control-label col-xs-2 col-xs-offset-2\" for=\"pseudo_ancien\">" + caracNomComplet[i + 1]
											+ " :</label>");
									out.println("<input type=\"text\" name=\"" + carac[i + 1] + "\" id=\"" + carac[i + 1]
											+ "\" class=\"control-label col-xs-1 champLecture\" value='"+personnage.getCaracteristique().getCaracs().get(carac[i+1])+"' readonly/>");
									out.println("</div>");
								}
							%>
						</div>

						<div id="menu2" class="tab-pane fade col-xs-offset-1"
							style="margin-top: 30px">
							<p>menu2</p>
						</div>

						<div id="menu3" class="tab-pane fade col-xs-offset-1"
							style="margin-top: 30px">
							<p>menu3</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	</section> </section> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<jsp:include page="../include/import_script.jsp" />
	
	<form method="post" action="../DemandeAmis"></form>

</body>
</html>