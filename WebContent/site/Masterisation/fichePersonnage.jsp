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
			
		  <jsp:include page="../include/import_aside.jsp"/>	
	
		
		
		<section id="main-content">
				<section class="wrapper">
				
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
			</section>
		</section>
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
		<jsp:include page="../include/import_script.jsp" />

</body>
</html>