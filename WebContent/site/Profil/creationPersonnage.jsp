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
	    <link href="../../dashgum/assets/css/bootstrap.css" rel="stylesheet">
	    <!--external css-->
	    <link href="../../dashgum/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	    <link rel="stylesheet" type="text/css" href="../../dashgum/assets/css/zabuto_calendar.css">
	    <link rel="stylesheet" type="text/css" href="../../dashgum/assets/js/gritter/css/jquery.gritter.css" />
	    <link rel="stylesheet" type="text/css" href="../../dashgum/assets/lineicons/style.css">    
	    
	    <!-- Custom styles for this template -->
	    <link href="../../dashgum/assets/css/style.css" rel="stylesheet">
	    <link href="../../dashgum/assets/css/style-responsive.css" rel="stylesheet">
		<title>Critical</title>
</head>
<body class="bg-image"
	style="background-image: url('../../assets/img/login-bg.jpg');">
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
                    <li><a class="logout" href="Inscription_Connexion_Deco/deconnexion.jsp">Déconnexion</a></li>
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
						<p class="centered"><a href="profile.html"><img src="../../assets/img/Critical_dice_logo_large.png" class="img-circle" width="60"></a></p>
              	  		<h5 class="centered"><% String login = request.getSession().getAttribute("utilisateur").toString();%><%= login %></h5>
              	  		
              	  		<li class="mt">
              	  			<a href="../index.jsp">
	                          <i class="fa fa-dashboard"></i>
	                          <span>Home</span>
	                        </a>
              	  		</li>
              	  		<li  class="sub-menu">
              	  			<a href="../Masterisation/masterisation.jsp">
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
              	  			<a href="../options.jsp">
	                          <i class="fa"></i>
	                          <span>Options</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="profil.jsp">
	                          <i class="fa"></i>
	                          <span>Profil</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="../../AfficherAmis">
	                          <i class="fa"></i>
	                          <span>Amis</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="../aide.jsp">
	                          <i class="fa"></i>
	                          <span>Aide</span>
	                        </a>
              	  		</li>
					</ul>
				</div>
			</aside>	
	
	</section>	
		

	<h1>Creation Personnage</h1>

	<form class="form-horizontal" action="CreationPersonnageServlet"
		method="post">
		<div class="form-group">
			<div class="container">
				<div class=" panel-group content content-boxed overflow-hidden">

					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse1"> Personnage</a>
							</h4>
						</div>
						<div id="collapse1" class="panel-collapse collapse in"
							style="margin-top: 10px; margin-bottom: 10px">
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

					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse2"> Apparence</a>
							</h4>
						</div>
						<div id="collapse2" class="panel-collapse collapse in"
							style="margin-top: 10px; margin-bottom: 10px">

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


					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse3"> Caractéristiques</a>
							</h4>
						</div>
						<div id="collapse3" class="panel-collapse collapse in"
							style="margin-top: 10px; margin-bottom: 10px">

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

				<div style="margin-top: 30px">
					<button type="submit"
						class="col-xs-offset-10 col-xs-2 btn btn-default">Création
						Personnage</button>
				</div>

			</div>

		</div>
	</form>

	<!-- js placed at the end of the document so the pages load faster -->
		<div id="Importation des scripts">
		    <script src="../../dashgum/assets/js/jquery.js"></script>
		    <script src="../../dashgum/assets/js/jquery-1.8.3.min.js"></script>
		    <script src="../../dashgum/assets/js/bootstrap.min.js"></script>
		    <script class="include" type="text/javascript" src="../../dashgum/assets/js/jquery.dcjqaccordion.2.7.js"></script>
		    <script src="../../dashgum/assets/js/jquery.scrollTo.min.js"></script>
		    <script src="../../dashgum/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
		    <script src="../../dashgum/assets/js/jquery.sparkline.js"></script>
		
		
		    <!--common script for all pages-->
		    <script src="../../dashgum/assets/js/common-scripts.js"></script>
		    
		    <script type="text/javascript" src="../../dashgum/assets/js/gritter/js/jquery.gritter.js"></script>
		    <script type="text/javascript" src="../dashgum/assets/js/gritter-conf.js"></script>
		
		    <!--script for this page-->
		    <script src="../../dashgum/assets/js/sparkline-chart.js"></script>    
			<script src="../../dashgum/assets/js/zabuto_calendar.js"></script>
			
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