<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="cs.define.Define"%>

<head>
	<title>Car sharing</title>
	<script type="text/javascript">
		var WEB_ROOT_URL = "<%=Define.webRootUrl %>";
		var WEB_USE_LANGUAGE = "<s:property value="language"/>";
	</script>
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.core.js"></script>
	
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.widget.js"></script>

 	<script type="text/javascript" src="js/jquery.ui/jquery.ui.accordion.js"></script>
   
 	<script type="text/javascript" src="js/jquery.ui/jquery.ui.tabs.js"></script>
 
 	<script type="text/javascript" src="js/jquery.ui/jquery.validate.js"></script>
  	
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.datepicker.js"></script>
	
	<script type="text/javascript" src="js/jquery.corner.js"></script>
	
	<script type="text/javascript" src="js/jquery.evenment.js"></script>
	<script type="text/javascript" src="js/jquery.evenment.onload.js"></script>

	<script type="text/javascript" src="js/googleMapAddressByPosition.js"></script>	
	<script type="text/javascript" src="js/googlemap.js"></script>
    
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=<s:property value="language"/>"></script>
 <!--
  	<script type="text/javascript" src="js/jquery.time/jquery.utils.js"></script>
	<script type="text/javascript" src="js/jquery.time/jquery.strings.js"></script>
	
	<script type="text/javascript" src="js/jquery.time/jquery.anchorHandler.js"></script>
-->
	<script type="text/javascript" src="js/js.function.job.js"></script>

<!-- 
   	<script type="text/javascript" src="js/jquery.time/jquery.ui.all.js"></script>
 
	<script type="text/javascript" src="js/jquery.time/ui.timepickr.js"></script> 
 -->
 <!--
 	<script type="text/javascript" src="js/js.accordion.js"></script>
 -->
<!--
	<link type="text/css" href="css/jquery.tabs.css" rel="stylesheet" >
-->
	<link type="text/css" href="css/themes/base/jquery.ui.all.css" rel="stylesheet" >
<!-- 
	<link type="text/css" href="css/css.css" rel="stylesheet" >
 -->
	<link type="text/css" href="css/ui.timepickr.css" rel="stylesheet" >
	<link type="text/css" href="css/accordion.css" rel="stylesheet">
	
	<style type="text/css">
		.body{
			min-height:300px;
		}
		.left{
			height:100%;
		}
		.corner {
			background-color:#DDE8E6;
		}
	</style>
	
	<script type="text/javascript">
		$(document).ready( function () { 
			$('#containerLeft').tabs({ fxFade: true, fxSpeed: 'normal' });
		} ) ;
		
		$(document).ready( function () {
			$('#menuMessages').tabs({ fxFade: true, fxSpeed: 'normal' });
			$('#menuTrip').tabs({ fxFade: true, fxSpeed: 'normal' });
			$(".corner").corner();
		} ) ;
	</script>	
	<script type="text/javascript">
		$(document).ready( function () {
			
			//Sous menu de mes offres
			$('#menuTrip').tabs({
		        select: function(e, ui) {
		        	//Mes offres poster
					if ( ui.index == 0 )
		        	{
						loadMyTripPost();
		        	}
		        	//Mes offres accepter
					if ( ui.index == 1 )
		        	{
						loadMyTripAgree();
		        	}  
				}
			});
			//Sous menu des messages
			$('#menuMessages').tabs({
		        select: function(e, ui) {
					// onglet message send== ui.index == 0
			        if ( ui.index == 0)
			        {
			        	loadMessageSend();    
				    }
			       //Onglet message receive == ui.index == 0
				   if ( ui.index == 1)
				   {
				   		loadMessageReceive();
				   }
		     	}
			});

			//Menu principale
			$('#container').bind('tabsshow', function(event, ui) {
				//post d'une offre
    			if (ui.panel.id == "post") {
					initializeMapEmpty('divMapStart');
					initializeMapEmpty('divMapStop');
    			}
    			//profil
    			if (ui.panel.id == "profil") {
    				initializeMapEmpty('divMapProfil');
    			}
    			//profil
    			if (ui.panel.id == "registration") {
    				initializeMapEmpty('divMapProfil');
    			}
    			
    			//message
    			if (ui.panel.id == "message") 
        		{
					loadMessageReceive();
		        	loadMessageSend();
    			}//Fin du panel message
    				
    			//My trip
			    if ( ui.panel.id == "trip")
			    {
				    loadMyTripAgree();
				    loadMyTripPost();
				    
			     }//Fin de MY Trip
			});//Fin du menu principale
			$('#container').tabs();
				
		});//Fin du olnad
	</script>
	<script type="text/javascript">
		//calendrier
		$(function() {
			$("#datepickerPostt").datepicker({	minDate: new Date(),
											showOn: 'button',
											buttonImage: '/CSAppWeb/img/calendar.gif',
											buttonImageOnly: true
			});
			$("#datepickerSearch").datepicker({	minDate: new Date(),
											showOn: 'button',
											buttonImage: '/CSAppWeb/img/calendar.gif',
											buttonImageOnly: true
			});
			$("#datepickerPostDate").datepicker({	minDate: new Date(),
				showOn: 'button',
				buttonImage: '/CSAppWeb/img/calendar.gif',
				buttonImageOnly: true
			});
		});
	</script>
		<script type="text/javascript">
			function countNumberOfMessageNotRead()
			{
				setTimeout("countNumberOfMessageNotRead()",15000);
				ajaxNumberOfMessageNotRead();
			}
			//Exécution du controle des formulaires
			$(document).ready(function(){

				$('#register_form').validate({
					success: function(form) {
						form.submit();
					}
				}
				);
				
				$('#checkaddress_form').validate({
					success: function(form) {
						ajaxCheckInAjax();
					}
				}
				);
				$('#search_form').validate({
					success: function(form) {
						ajaxSearch();
					}
				}
				);
				var isError = true;
				
				$('#post_form').validate({
				    invalidHandler: function(form, validator) {
				      var errors = validator.numberOfInvalids();
				      //alert("errors : " + errors);
				      isError = true;
				    },
					submitHandler: function(form) {
						//goToEtape2OfPost();
						isError = false;	
					}
				});
				$('.Etape2Post').click(function() {
					if(isError==false) { goToEtape2OfPost(); isError = true; }
				});
				
			});
	</script>
	<s:if test="isLoging()">
		<script type="text/javascript">
			countNumberOfMessageNotRead();
		</script>
	</s:if>
	<style type="text/css">
		label { width: 10em; float: left; }
		label.error { float: none; color: red; padding-left: .5em; vertical-align: top; }
		p { clear: both; }
		.submit { margin-left: 12em; }
		em { font-weight: bold; padding-right: 1em; vertical-align: top; }
	</style>
	<style type="text/css">
		img {
			border-width : 0;
			border : 0;
		} 
	</style>
</head> 