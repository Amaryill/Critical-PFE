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
		

	<h1>Fiche Personnage</h1>

	<form class="form-horizontal">
		<ul class="nav nav-pills nav-justified container-fluid styleA">
			<li class="active"><a data-toggle="pill" href="#home">Description</a></li>
			<li><a data-toggle="tab" href="#menu1">Caractéristiques</a></li>
			<li><a data-toggle="tab" href="#menu2">Inventaire</a></li>
			<li><a data-toggle="tab" href="#menu3">Compétences</a></li>
		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active"
				style="margin-top: 30px">
				<div class="row">
					<label class="control-label col-xs-2" for="pseudo_ancien">Nom personnage :</label> 
					<input type="text" id="nom" name="nom"
						class="control-label col-xs-2 champLecture" value="a" readonly />
				</div>
				<div class="row" style="margin-top: 15px">

					<label class="control-label col-xs-2" for="pseudo_ancien">Race
						:</label> <input type="text" id="nom" name="nom"
						class="control-label col-xs-2 champLecture" value="a" readonly /> <label
						class="control-label col-xs-2" for="pseudo_ancien">Classe
						:</label> <input type="text " id="nom" name="nom"
						class="control-label col-xs-2 champLecture" value="a" readonly />
				</div>
				<div class="row" style="margin-top: 15px">

					<label class="control-label col-xs-2" for="pseudo_ancien">Alignement
						:</label> <input type="text" id="nom" name="nom"
						class="control-label col-xs-2 champLecture" value="a" readonly /> <label
						class="control-label col-xs-2" for="pseudo_ancien">Dieu :</label>
					<input type="text" id="nom" name="nom"
						class="control-label col-xs-2 champLecture" value="a" readonly />
				</div>
			</div>

			<div id="menu1" class="tab-pane fade" style="margin-top: 30px">
				<%
					String[] caracNomComplet = new String[] { "Force", "Intelligence", "Dexterite", "Sagesse", "Constitution",
							"Charisme" };
					String[] carac = new String[] { "for", "dex", "con", "int", "sag", "cha" };
					for (int i = 0; i < 6; i += 2) {
						out.println("<div class=\"row\" style=\"margin-top: 10px\">");
						out.println("<label class=\"control-label col-xs-2\" for=\"pseudo_ancien\">" + caracNomComplet[i]
								+ " :</label>");
						out.println("<input type=\"text\" name=\"" + carac[i] + "\" id=\"" + carac[i]
								+ "\" class=\"control-label col-xs-2 champLecture\" value=\"a\" readonly/>");
						out.println("<label class=\"control-label col-xs-2\" for=\"pseudo_ancien\">" + caracNomComplet[i + 1]
								+ " :</label>");
						out.println("<input type=\"text\" name=\"" + carac[i + 1] + "\" id=\"" + carac[i + 1]
								+ "\" class=\"control-label col-xs-2 champLecture\" value=\"a\" readonly/>");
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