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
		
		
		<!-- <link rel="stylesheet" href="WebContent/assets/css/bootstrap-theme.min.css">
		<script src="WebContent/assets/js/bootstrap.min.js"></script>-->
		
		
		<title>Options</title>
</head>
<body>
	<h2>Modifier mon pseudo</h2>
	<form class="form-horizontal" action="ModifPseudo" method="post">
		<div class="form-group">
			<div class="col-xs-6 col-xs-offset-2">
				<div class="form-material form-material-primary">
					<label class="control-label" for="pseudo_ancien">Ancien
						pseudo:</label> <input type="text" class="form-control" id="text"
						placeholder="Entrer pseudo" name="pseudo_ancien">
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-6 col-xs-offset-2">
				<div class="form-material form-material-primary">
					<label class="control-label" for="pseudo_nouveau">Nouveau
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
	<h2>Modifier son mot de passe</h2>
	<form class="form-horizontal" action="ModifMdp" method="post">

		<div class="form-group">
			<div class="col-xs-6 col-xs-offset-2">
				<div class="form-material form-material-primary">
					<label class="control-label" for="mdp">Ancien mot de passe:</label>
					<input type="password" class="form-control" id="pwd"
						placeholder="Entrer mot de passe actuel" name="mdp_ancien">
				</div>
			</div>
			<div class="col-xs-6 col-xs-offset-2">
				<div class="form-material form-material-primary">
					<label class="control-label" for="mdp">Confirmer:</label> <input
						type="password" class="form-control" id="pwd"
						placeholder="Confirmer" name="confirmer">
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-6 col-xs-offset-2">
				<div class="form-material form-material-primary">
					<label class="control-label" for="mdp">Nouveau mot de
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
		<li class="active"><a href="options.jsp">Options</a></li>
		<li><a href="profil.jsp">Profil</a></li>
		<li><a href="#">Amis</a></li>
		<li><a href="#">Aide</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li><a href="deconnexion.jsp">Deconnexion</a></li>
	</ul>
</div>
</nav>
</html>