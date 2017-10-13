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
	<body>
		<div class="container">
		  <h2>Sign up</h2>
		  <form class="form-horizontal" action="SignUpServlet" method="post">
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="email">Pseudo:</label>
		      <div class="col-sm-10">
		        <input class="form-control" id="email" placeholder="Entrer pseudo" name="pseudo">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="pwd">Mot de passe:</label>
		      <div class="col-sm-10">          
		        <input type="password" class="form-control" id="pwd" placeholder="Entrer mot de passe" name="mdp">
		      </div>
		    </div>
		    <div class="form-group">        
		      <label class="control-label col-sm-2" for="pwd">Confirmer votre mot de passe:</label>
		      <div class="col-sm-10">          
		        <input type="password" class="form-control" id="pwd" placeholder="Confirmer mot de passe" name="mdpconfirme">
		      </div>
		    </div>
		    <div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		      	<button type="submit" class="btn btn-default" >Sign Up</button>
		      </div>
		    </div>
		    
		  </form>
		</div>
	</body>
</html>