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
	    
	    <!-- importation des classes -->
	    <%@page import="fr.eseo.criticalPfe.java.model.scenario.Univers" %>
	    
		<!-- Verification de la variable session -->
		<% if (request.getSession().getAttribute("utilisateur") == null) {
			response.sendRedirect("login.jsp");
		}
		%>
		
		<title>Masterisation</title>
	</head>
	<body class="bg-image"
	style="background-image: url('../../assets/img/login-bg.jpg');">
		
		
		<!--  Header et aside -->
		<section id="container">
		

			<jsp:include page="../include/import_header.jsp" />
			
		  	<jsp:include page="../include/import_aside.jsp"/>	
	
		</section>	
		 
		<!-- **********************************************************************************************************************************************************
	      MAIN CONTENT
	      *********************************************************************************************************************************************************** -->
		<section id="main-content">
			<section class="wrapper">
			
			<form class="form-horizontal" method="post" action="/Critical-PFE/AffichageListeUnivers">
				<div class="col-xs-2 col-xs-offset-0">
					<button class="btn btn-theme btn-block" type="submit" id="afficher univers">Retour</button>
				</div>
			</form>
			
			<br><br>
			<% Univers univers = (Univers)request.getSession().getAttribute("univers"); %>
			
			<br>
			
			<form class="form-horizontal" method="post" action="/Critical-PFE/SuppressionUnivers">
				<input type="hidden" name="idUnivers" id="idUnivers" value = <%=univers.getId() %>>
				<div class="col-xs-2 col-xs-offset-0">
					<button class="btn btn-theme btn-block" type="submit" id="afficher univers">Supprimer l'univers</button>
				</div>
			</form>
			<br>
			
			<h1 style="color:black;">
			<%= univers.getNomUnivers() %>
			</h1>
			<h2 style="color:black;">Changer le nom de l'univers </h2>
					<form class="form-horizontal" action="/Critical-PFE/RenommerUnivers" method="post">
						<div class="form-group">
							<div class="col-xs-3 col-xs-offset-0">
								<div class="form-material form-material-primary">
									<label class="control-label" for="pseudo_nouveau" style="color:black;">Nouveau
										nom:</label> <input type="text" class="form-control" id="nomUnivers"
										placeholder="Entrer nom d'Univers" name="nomUnivers">
								</div>
							</div>
						</div>
					<input type="hidden" name="idUnivers" id="idUnivers" value = <%=univers.getId() %>>
						<div class="form-group">
							<div class="col-xs-6 col-xs-offset-0">
								<button type="submit" class="btn btn-default">Modifier</button>
							</div>
						</div>
					</form>
			
			
			</section>
		</section>
		
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
		    <script type="text/javascript" src="../../dashgum/assets/js/gritter-conf.js"></script>
		
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