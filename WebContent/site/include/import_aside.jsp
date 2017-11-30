<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- **********************************************************************************************************************************************************
	      MAIN SIDEBAR MENU
	      *********************************************************************************************************************************************************** -->
	      <!--sidebar start-->
		  <aside>
				<div id="sidebar" class="nav-collapse">
					<ul class="sidebar-menu" id="nav-accordion">
						<p class="centered"><a href="profile.html"><img src="/Critical-PFE/assets/img/Critical_dice_logo_large.png" class="img-circle" width="60"></a></p>
              	  		<h5 class="centered"><% String login = request.getSession().getAttribute("utilisateur").toString();%><%= login %></h5>
              	  		
              	  		<li class="mt">
              	  			<a href="/Critical-PFE/site/index.jsp">
	                          <i class="fa fa-dashboard"></i>
	                          <span>Home</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
	              	  			<a class="active" href="#">
		                          <i class="fa"></i>
		                          <span>Masterisation</span>
		                        </a>
		                        <ul class="sub"> 
		                        	<li><a href="/Critical-PFE/site/Masterisation/masterisation.jsp">Portail de MJ</a></li>
		                        	<li><a href="/Critical-PFE/site/Masterisation/creationPersonnage.jsp">Cr�er un personnage</a></li>
		                        	<li><a href="/Critical-PFE/site/Masterisation/fichePersonnage.jsp">Voir mes personnages</a></li>
		                        	<li><a href="/Critical-PFE/site/Masterisation/modificationUnivers.jsp">Modifier mes univers</a></li>
		                        
		                        </ul>
	              	  	</li>
              	  		<li class="sub-menu">
              	  			<a href="#">
	                          <i class="fa"></i>
	                          <span>Partie en cours</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="/Critical-PFE/site/options.jsp">
	                          <i class="fa"></i>
	                          <span>Options</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="/Critical-PFE/site/Profil/profil.jsp">
	                          <i class="fa"></i>
	                          <span>Profil</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="/Critical-PFE/AfficherAmis">
	                          <i class="fa"></i>
	                          <span>Amis</span>
	                        </a>
              	  		</li>
              	  		<li class="sub-menu">
              	  			<a href="/Critical-PFE/site/aide.jsp">
	                          <i class="fa"></i>
	                          <span>Aide</span>
	                        </a>
              	  		</li>
					</ul>
				</div>
			</aside>