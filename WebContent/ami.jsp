<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Verification de la variable session -->
<% if (request.getSession().getAttribute("utilisateur") == null) {
			response.sendRedirect("login.jsp");
		}
%>

<!-- <link rel="stylesheet" href="WebContent/assets/css/bootstrap-theme.min.css">
		<script src="WebContent/assets/js/bootstrap.min.js"></script>-->

<%@ page import="java.util.ArrayList"%>


<title>Amis</title>
</head>
<body>
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
					out.println("  Une nouvelle amitié est né <3");
				}
	%>
	<form method="post" action="/Critical-PFE/SupprimerAmis">
		<button type="hidden" name="pseudo" value=<%=listeAmis.get(i)%>
			type="submit" id="submit_supprimerAmi" value="Supprimer">supprimer
			l'amitié</button>
	</form>

	<%
		}
		}

		if (demandesRecues.size() > 0) {
			out.println("<br><br>demandes reçues :");
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
			out.println("<br><br>demandes envoyées :");
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



</body>




<nav class="navbar-default navbar-inverse navbar-fixed-bottom">
<div class="container-fluid">
	<div class="navbar-header">
		<a href="index.jsp"><img src="assets/img/Critical_dice_logo.png"></a>
	</div>
	<ul class="nav navbar-nav">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#">Masterisation</a></li>
		<li><a href="#">Partie en cours</a></li>
		<li><a href="#">Options</a></li>
		<li><a href="profil.jsp">Profil</a></li>
		<li class="active"><a href="AfficherAmis">Amis</a></li>
		<li><a href="#">Aide</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li><a href="deconnexion.jsp">Deconnexion</a></li>
	</ul>
</div>
</nav>
</html>