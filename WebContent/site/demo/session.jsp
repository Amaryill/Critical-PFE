<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="Dashboard">
	    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

		<jsp:include page="/site/include/import_dashgum.jsp" />
		
		<!-- Verification de la variable session -->
		<% if (request.getSession().getAttribute("utilisateur") == null) {
			response.sendRedirect("login.jsp");
		}
		%>
		
		<link rel="shortcut icon" href="TemplateData/favicon.ico">
		 <link rel="stylesheet" href="TemplateData/style.css">
		<script src="TemplateData/UnityProgress.js"></script>  
		<script src="Build/UnityLoader.js"></script>
		<script>
		  var gameInstance = UnityLoader.instantiate("gameContainer", "Build/demo.json", {onProgress: UnityProgress});
		</script>
		
		<title>Index</title>
	</head>
	
	<body class="bg-image"
	style="background-image: url('assets/img/login-bg.jpg');">
	
	<!--  Header et aside -->
		<section id="container">
			
			<jsp:include page="/site/include/import_header.jsp" />
			<jsp:include page="/site/include/import_aside.jsp"/>
		</section>
		<section id="main-content" class="wrapper">
			
		<div class="webgl-content" id="gameContainer" style="width: 1100px; height: 750px; margin: auto"></div>
		  <div class="footer">
			<div class="webgl-logo"></div>
			<div class="fullscreen" onclick="gameInstance.SetFullscreen(1)"></div>
			<div class="title">Application</div>
		  </div>
		
		</section>	
		
		
		

		<jsp:include  page="/site/include/import_script.jsp" />
		
	
		</div>
	
	
	</body>
	
	
</html>