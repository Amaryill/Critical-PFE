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
		
		
		
		<title>Options</title>
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
                    <li><a class="logout" href="Inscription_Connexion_Deco/deconnexion.jsp">Déconnexion</a></li>
            	</ul>
            </div>
          </header>
			
		  <jsp:include page="include/import_aside.jsp"/>
	
			<!-- **********************************************************************************************************************************************************
		      MAIN CONTENT
		      *********************************************************************************************************************************************************** -->
		     <!--main content start-->
			<section id="main-content">
				<section class="wrapper">
				
				
					<h2 style="color:black;">Modifier mon pseudo</h2>
					<form class="form-horizontal" action="../ModifPseudo" method="post">
						<div class="form-group">
							<div class="col-xs-6 col-xs-offset-2">
								<div class="form-material form-material-primary">
									<label class="control-label" for="pseudo_ancien" style="color:black;">Ancien
										pseudo:</label> <input type="text" class="form-control" id="text"
										placeholder="Entrer pseudo" name="pseudo_ancien">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-6 col-xs-offset-2">
								<div class="form-material form-material-primary">
									<label class="control-label" for="pseudo_nouveau" style="color:black;">Nouveau
										pseudo:</label> <input type="text" class="form-control" id="text"
										placeholder="Entrer nouveau pseudo" name="pseudo_nouveau">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-6 col-xs-offset-2">
								<button type="submit" class="btn btn-default">Modifier</button>
							</div>
						</div>
					</form>
					<h2 style="color:black;">Modifier son mot de passe</h2>
					<form class="form-horizontal" action="../ModifMdp" method="post">
				
						<div class="form-group">
							<div class="col-xs-6 col-xs-offset-2">
								<div class="form-material form-material-primary">
									<label class="control-label" for="mdp" style="color:black;">Ancien mot de passe:</label>
									<input type="password" class="form-control" id="pwd"
										placeholder="Entrer mot de passe actuel" name="mdp_ancien">
								</div>
							</div>
							<div class="col-xs-6 col-xs-offset-2">
								<div class="form-material form-material-primary">
									<label class="control-label" for="mdp" style="color:black;">Confirmer:</label> <input
										type="password" class="form-control" id="pwd"
										placeholder="Confirmer" name="confirmer">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-6 col-xs-offset-2">
								<div class="form-material form-material-primary">
									<label class="control-label" for="mdp" style="color:black;">Nouveau mot de
										passe:</label> <input type="password" class="form-control" id="pwd"
										placeholder="Entrer nouveau mot de passe" name="mdp_nouveau">
				
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-6 col-xs-offset-2">
								<button type="submit" class="btn btn-default">Modifier</button>
							</div>
						</div>
					</form>
				</section>
			</section>
	</section>	
		 
	


<!-- js placed at the end of the document so the pages load faster -->
		<jsp:include page="include/import_script.jsp" />
			
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