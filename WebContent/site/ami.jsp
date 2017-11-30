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

	
	    <jsp:include page="include/import_dashgum.jsp" />

<!-- Verification de la variable session -->
<% if (request.getSession().getAttribute("utilisateur") == null) {
			response.sendRedirect("login.jsp");
		}
%>


<%@ page import="java.util.ArrayList"%>


<title>Amis</title>
</head>
<body class="bg-image"
	style="background-image: url('../assets/img/login-bg.jpg');">
	
	<!--  Header et aside -->
	<section id="container">
		<!-- **********************************************************************************************************************************************************
	      TOP BAR CONTENT & NOTIFICATIONS
	      *********************************************************************************************************************************************************** -->
	      <!--header start-->
	      <header class="header black-bg">
             <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
             </div>
             <!--logo start-->
           	 <a href="index.jsp" class="logo"><b>Critical</b></a>
             <!--logo end-->
             <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="Inscription_Connexion_Deco/deconnexion.jsp">D�connexion</a></li>
            	</ul>
            </div>
          </header>
			
		  <jsp:include page="include/import_aside.jsp"/>	
	
	</section>	
		 



	<h1>

		rechercher des amis : <br>
	</h1>
	<%
		ArrayList<String> listeNonAmis = (ArrayList<String>) request.getSession().getAttribute("listeNonAmis");
	%>
	<FORM method="post" action="/Critical-PFE/DemandeAmis">
		<SELECT name="pseudo">
			<%
				for (int i = 0; i < listeNonAmis.size(); i++) {
			%>
			<OPTION><%=listeNonAmis.get(i)%>
				<%
					}
				%>
			
		</SELECT>
		<button name="submit" type="submit" id="submit_demandeAmi"
			value="ajouter un ami">Envoyer la demande d'ami</button>
	</FORM>


	<br>
	<br>

	<h1>
		Les amis de :
		<%=request.getSession().getAttribute("utilisateur")%>
	</h1>

	<%
		ArrayList<String> listeAmis = (ArrayList<String>) request.getSession().getAttribute("amis");
		ArrayList<String> demandesEnvoyees = (ArrayList<String>) request.getSession()
				.getAttribute("demandesEnvoyees");
		ArrayList<String> demandesRecues = (ArrayList<String>) request.getSession().getAttribute("demandesRecues");
		ArrayList<String> demandesValidees = (ArrayList<String>) request.getSession()
				.getAttribute("demandesValidees");
		if (listeAmis.size() > 0) {
			out.println("amis :");
			for (int i = 0; i < listeAmis.size(); i++) {
				out.println("<br>" + listeAmis.get(i));
				if (demandesValidees.contains(listeAmis.get(i))) {
					out.println("  Une nouvelle amiti� est n� <3");
				}
	%>
	<form method="post" action="/Critical-PFE/SupprimerAmis">
		<button type="hidden" name="pseudo" value=<%=listeAmis.get(i)%>
			type="submit" id="submit_supprimerAmi" value="Supprimer">supprimer
			l'amiti�</button>
	</form>

	<%
		}
		}

		if (demandesRecues.size() > 0) {
			out.println("<br><br>demandes re�ues :");
			for (int i = 0; i < demandesRecues.size(); i++) {
				out.println("<br>" + demandesRecues.get(i) + "<br>");
	%>
	<form method="post" action="/Critical-PFE/ValiderAmis">
		<button type="hidden" name="pseudo" value=<%=demandesRecues.get(i)%>
			type="submit" id="submit_validerDemande" value="Modifier">valider
			la demande</button>
	</form>
	<form method="post" action="/Critical-PFE/RefuserAmis">
		<button type="hidden" name="pseudo" value=<%=demandesRecues.get(i)%>
			type="submit" id="submit_refuserDemande" value="Modifier">refuser
			la demande</button>
	</form>
	<%
		}
		}

		if (demandesEnvoyees.size() > 0) {
			out.println("<br><br>demandes envoy�es :");
			for (int i = 0; i < demandesEnvoyees.size(); i++) {
				out.println("<br>" + demandesEnvoyees.get(i) + "<br>");
	%>
	<form method="post" action="/Critical-PFE/AnnulerDemandeAmis">
		<button type="hidden" name="pseudo" value=<%=demandesEnvoyees.get(i)%>
			type="submit" id="submit_annulerDemande" value="Modifier">annuler
			la demande</button>
	</form>
	<%
		}
		}

		
	%>

<!-- js placed at the end of the document so the pages load faster -->
		<jsp:include page="include/import_script.jsp"/>
	

</body>

</html>