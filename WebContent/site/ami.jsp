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

	
	    <!-- Bootstrap core CSS -->
	    <link href="../dashgum/assets/css/bootstrap.css" rel="stylesheet">
	    <!--external css-->
	    <link href="../dashgum/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	    <link rel="stylesheet" type="text/css" href="../dashgum/assets/css/zabuto_calendar.css">
	    <link rel="stylesheet" type="text/css" href="../dashgum/assets/js/gritter/css/jquery.gritter.css" />
	    <link rel="stylesheet" type="text/css" href="../dashgum/assets/lineicons/style.css">    
	    
	    <!-- Custom styles for this template -->
	    <link href="../dashgum/assets/css/style.css" rel="stylesheet">
	    <link href="../dashgum/assets/css/style-responsive.css" rel="stylesheet">
	
	    <script src="../dashgum/assets/js/chart-master/Chart.js"></script>

<!-- Verification de la variable session -->
<% if (request.getSession().getAttribute("utilisateur") == null) {
			response.sendRedirect("login.jsp");
		}
%>


<%@ page import="java.util.ArrayList"%>


<title>Amis</title>
</head>
<body>

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
			
		  <!-- **********************************************************************************************************************************************************
	      MAIN SIDEBAR MENU
	      *********************************************************************************************************************************************************** -->
	      <!--sidebar start-->
		  <aside>
				<div id="sidebar" class="nav-collapse">
					<ul class="sidebar-menu" id="nav-accordion">
						<p class="centered"><a href="profile.html"><img src="../assets/img/Critical_dice_logo_large.png" class="img-circle" width="60"></a></p>
              	  		<h5 class="centered"><% String login = request.getSession().getAttribute("utilisateur").toString();%><%= login %></h5>
              	  		
              	  		<li class="mt">
              	  			<a href="index.jsp">
	                          <i class="fa fa-dashboard"></i>
	                          <span>Home</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="Masterisation/masterisation.jsp">
	                          <i class="fa"></i>
	                          <span>Masterisation</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="#">
	                          <i class="fa"></i>
	                          <span>Partie en cours</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="options.jsp">
	                          <i class="fa"></i>
	                          <span>Options</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="Profil/profil.jsp">
	                          <i class="fa"></i>
	                          <span>Profil</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a class="active" href="../AfficherAmis">
	                          <i class="fa"></i>
	                          <span>Amis</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="aide.jsp">
	                          <i class="fa"></i>
	                          <span>Aide</span>
	                        </a>
              	  		</li>
					</ul>
				</div>
			</aside>	
	
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
		<div id="Importation des scripts">
		    <script src="../dashgum/assets/js/jquery.js"></script>
		    <script src="../dashgum/assets/js/jquery-1.8.3.min.js"></script>
		    <script src="../dashgum/assets/js/bootstrap.min.js"></script>
		    <script class="include" type="text/javascript" src="../dashgum/assets/js/jquery.dcjqaccordion.2.7.js"></script>
		    <script src="../dashgum/assets/js/jquery.scrollTo.min.js"></script>
		    <script src="../dashgum/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
		    <script src="../dashgum/assets/js/jquery.sparkline.js"></script>
		
		
		    <!--common script for all pages-->
		    <script src="../dashgum/assets/js/common-scripts.js"></script>
		    
		    <script type="text/javascript" src="../dashgum/assets/js/gritter/js/jquery.gritter.js"></script>
		    <script type="text/javascript" src="../dashgum/assets/js/gritter-conf.js"></script>
		
		    <!--script for this page-->
		    <script src="../dashgum/assets/js/sparkline-chart.js"></script>    
			<script src="../dashgum/assets/js/zabuto_calendar.js"></script>
			
			<script type="application/javascript">
	        $(document).ready(function () {
	            $("#date-popover").popover({html: true, trigger: "manual"});
	            $("#date-popover").hide();
	            $("#date-popover").click(function (e) {
	                $(this).hide();
	            });
	        
	            $("#my-calendar").zabuto_calendar({
	                action: function () {
	                    return myDateFunction(this.id, false);
	                },
	                action_nav: function () {
	                    return myNavFunction(this.id);
	                },
	                ajax: {
	                    url: "show_data.php?action=1",
	                    modal: true
	                },
	                legend: [
	                    {type: "text", label: "Special event", badge: "00"},
	                    {type: "block", label: "Regular event", }
	                ]
	            });
	        });
	        
	        
	        function myNavFunction(id) {
	            $("#date-popover").hide();
	            var nav = $("#" + id).data("navigation");
	            var to = $("#" + id).data("to");
	            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
	        }
	   	 	</script>
	
		</div>
	

</body>

</html>