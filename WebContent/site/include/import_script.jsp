<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- js placed at the end of the document so the pages load faster -->
	    <script src="/Critical-PFE/dashgum/assets/js/jquery.js"></script>
	    <script src="/Critical-PFE/dashgum/assets/js/jquery-1.8.3.min.js"></script>
	    <script src="/Critical-PFE/dashgum/assets/js/bootstrap.min.js"></script>
	    <script class="include" type="text/javascript" src="/Critical-PFE/dashgum/assets/js/jquery.dcjqaccordion.2.7.js"></script>
	    <script src="/Critical-PFE/dashgum/assets/js/jquery.scrollTo.min.js"></script>
	    <script src="/Critical-PFE/dashgum/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	    <script src="/Critical-PFE/dashgum/assets/js/jquery.sparkline.js"></script>
	
	
	    <!--common script for all pages-->
	    <script src="/Critical-PFE/dashgum/assets/js/common-scripts.js"></script>
	    
	    <script type="text/javascript" src="/Critical-PFE/dashgum/assets/js/gritter/js/jquery.gritter.js"></script>
	    <script type="text/javascript" src="/Critical-PFE/dashgum/assets/js/gritter-conf.js"></script>
	
	    <!--script for this page-->
	    <script src="/Critical-PFE/dashgum/assets/js/sparkline-chart.js"></script>    
		<script src="/Critical-PFE/dashgum/assets/js/zabuto_calendar.js"></script>
		
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
	        
	        $(document).ready(function (){
	   			var link = window.location.href;
 	   			var tableauLink = ["index.jsp","options.jsp","ami.jsp","aide.jsp","profil.jsp","masterisation.jsp","fichePersonnage.jsp",
 	   				"creationPersonnage.jsp"]
 	   			var tableauId = ["index","options","amis","aide","profil","masterisation","masterisation","masterisation"]
 	   			for (i=0;i<tableauLink.length;i++){
 	   				if (link.indexOf(tableauId[i]) !== -1){
 	   					$('#'+tableauId[i]).addClass('active');
 	   				}
 	   			}
 	   		})
	   	 	</script>
	   	 	
	   	 	
	   	 	
	   	 	
	   	 	<!-- 	   class="active"  -->

	   		
	   
	   	 	
