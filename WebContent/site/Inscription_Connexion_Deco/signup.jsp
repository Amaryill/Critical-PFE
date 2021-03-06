<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		 <!-- Bootstrap core CSS -->
	    <link href="../../dashgum/assets/css/bootstrap.css" rel="stylesheet">
	    <!--external css-->
	    <link href="../../dashgum/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	        
	    <!-- Custom styles for this template -->
	    <link href="../../dashgum/assets/css/style.css" rel="stylesheet">
	    <link href="../../dashgum/assets/css/style-responsive.css" rel="stylesheet">
		<title>Critical</title>
	</head>
	
	<body class="bg-image"
	style="background-image: url('../../assets/img/login-bg.jpg');">
	
	 <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	
		<div id="login-page">
			<div class="container">
				<form class="form-login" action="../../SignUpServlet" method="post">
					<h2 class="form-login-heading">Inscription</h2>
					
					<div class="login-wrap">
						<input type="text" class="form-control" placeholder="Entrer login" name="login" autofocus>
						<br>
						<input type="text" class="form-control" placeholder="Entrer email" name="email">
						<br>
						<input type="password" class="form-control" placeholder="Entrer mot de passe" name="mdp" autofocus>
						<br>
						<input type="password" class="form-control" placeholder="Confirmez mot de passe" name="mdpconfirme">
						<br>
						<input type="text" class="form-control" placeholder="Entrer pseudo" name="pseudo">
						<hr>
						<button class="btn btn-theme btn-block" type="submit"> S'inscrire</button>
			            
						
												      	      			
					</div>
					
				</form>
			</div>
		</div>
	
			
		
		<!-- js placed at the end of the document so the pages load faster -->
	    <script src="../../dashgum/assets/js/jquery.js"></script>
	    <script src=".../dashgum/assets/js/bootstrap.min.js"></script>
	
	    <!--BACKSTRETCH-->
	    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
	    <script type="text/javascript" src="../../dashgum/assets/js/jquery.backstretch.min.js"></script>
	    <script>
	        $.backstretch("/assets/img/login-bg.jpg", {speed: 500});
	    </script>
		
	</body>
</html>