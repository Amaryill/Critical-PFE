<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<title>Critical</title>
	</head>
	<body class="bg-image"
	style="background-image: url('/assets/img/Critical_logo.png');">
	
	
		<div class="container">
			<div class="content content-boxed overflow-hidden">
				<div class="row">
				<div class="col-xs-12"></div>
					<div class="text-center">
						<img src="../assets/img/Critical_logo_mini.png"/>
					</div>
			  			<!-- Login form -->
			  			<div style="margin:5%;">
			  				<div class="col-xs-6 col-xs-offset-2">
			  					<h1>Connexion</h1>
			  				</div>
						  
						  <form class="form-horizontal" action="../ConnexionServlet" method="post">
						    <div class="form-group">
						    	<div class="col-xs-6 col-xs-offset-2">
						    		<div class="form-material form-material-primary">
								      <label class="control-label" for="pseudo">Pseudo:</label>
							    	  <input type="text" class="form-control" id="text" placeholder="Entrer pseudo" name="pseudo">
						      		</div>
						      	</div>
						    </div>
						    <div class="form-group">
							    <div class="col-xs-6 col-xs-offset-2">
							    		<div class="form-material form-material-primary">
										      	<label class="control-label" for="mdp">Mdp:</label>     
										        <input type="password" class="form-control" id="pwd" placeholder="Entrer mdp" name="mdp">
										      
							      		</div>
							      </div>
						    </div>
						    <div class="form-group">        
						      <div class="col-xs-6 col-xs-offset-2">
						        <div class="checkbox">
						          <label><input type="checkbox" name="remember"> Se souvenir de moi</label>
						        </div>
						      </div>
						    </div>
						    <div class="form-group">        
						      <div class="col-xs-6 col-xs-offset-2">
						      	<button type="submit" class="btn btn-default" >Se connecter</button>
						      </div>
						    </div>
						    	<div class="col-xs-6 col-xs-offset-2">
						    		<a href="Inscription_Connexion_Deco/signup.jsp">S'enregistrer</a>
						    	</div>
						  </form>
						  </div>
						</div>
							  
			</div>  
		</div>
		
		
	</body>
</html>