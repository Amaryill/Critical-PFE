<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<%@page import="fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur"%>

<jsp:include page="../include/import_dashgum.jsp" />
<!-- Verification de la variable session -->
<%
	if (request.getSession().getAttribute("utilisateur") == null) {
		response.sendRedirect("login.jsp");
	}
	Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");
%>



<title>Profil</title>
</head>

<body class="bg-image"
	style="background-image: url('../../assets/img/login-bg.jpg');">
	<!--  Header et aside -->
	<section id="container"> <jsp:include
		page="../include/import_header.jsp" /> <jsp:include
		page="../include/import_aside.jsp" /> <!-- **********************************************************************************************************************************************************
	      MAIN CONTENT
	      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper"> <br>
	<br>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h2 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Présentation</a>
			</h2>
		</div>



		<div id="collapse1" class="panel-collapse collapse in"
			style="margin-top: 10px; margin-bottom: 10px">
			<form class="form-horizontal" action="../../ModifPresentation"
				method="post">
				<div class="col-xs-12" style="margin-top: 10px">
					<textarea id="presentation" name="presentation"
						style="resize: none; height: 200px; width: 100%"><%=utilisateur.getPresentation()%></textarea>
				</div>
				<div class="row">
					<div class="col-xs-12" style="padding-top: 10px">
						<div class="col-xs-2 col-xs-offset-10">
							<button type="submit" class="btn btn-theme btn-block">Sauvegarder</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>



	</section> </section> </section>


	<!-- js placed at the end of the document so the pages load faster -->
	<jsp:include page="../include/import_script.jsp" />


</body>


</html>