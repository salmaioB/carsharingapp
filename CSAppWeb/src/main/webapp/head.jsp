<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="cs.define.Define"%>

<head>
	<title>Car sharing</title>
	<script type="text/javascript">
		var WEB_ROOT_URL = "<%=Define.webRootUrl %>";
	</script>
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.accordion.js"></script>
		
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.datepicker.js"></script>
	
	<script type="text/javascript" src="js/jquery.ui//jquery.ui.tabs.js"></script>

	<script type="text/javascript" src="js/jquery.ui//jquery-ui-personalized-1.6rc6.js"></script>	
	
	<script type="text/javascript" src="js/jquery.corner.js"></script>
		
    <script type="text/javascript" src="js/jquery.evenment.js"></script>
    
    <script type="text/javascript" src="js/googleMapAddressByPosition.js"></script>	
    <script type="text/javascript" src="js/googlemap.js"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<!--
	<link type="text/css" href="css/jquery.tabs.css" rel="stylesheet" >
	-->
	<link type="text/css" href="css/themes/base/jquery.ui.all.css" rel="stylesheet" >
	<link type="text/css" href="css/css.css" rel="stylesheet" >
	
	<style type="text/css">
	.body{
		min-height:300px;
	}
	.left{
		height:100%;
	}
	.corner {
		background-color:#AAAAAA;
	}
	</style>
	<script type="text/javascript"><!--
		var mapPostInitialize = false;
		$(document).ready( function () { 
			$('#container').tabs({
		        select: function(e, ui) {
				// onglet post == ui.index == 1
		        if ( mapPostInitialize == false && ui.index == 1)
		        {
		        	mapPostInitialize=true;
					initializeMapEmpty('divMapStart');
					initializeMapEmpty('divMapStop');
		        }
			    //        var t = $(e.target);%
		            // alert("data is " +  t.data('load.tabs'));  // undef
		            // alert("data is " +  ui.data('load.tabs'));  // undef
	
		            // This gives a numeric index...
		          //  alert( "selected is " + t.data('selected.tabs') )
		            // ... but it's the index of the PREVIOUSLY selected tab, not the
		            // one the user is now choosing.  
		            return true;
	
		            // eventual goal is: 
		            // ... document.location= extract-url-from(something); return false;
	       		}
					
			});
		} ) ; 
		
		$(document).ready( function () { 
			$('#containerLeft').tabs({ fxFade: true, fxSpeed: 'normal' });
		} ) ;
		
		$(document).ready( function () { 
			$(".corner").corner();
		} ) ;
		
	--></script>

	<script type="text/javascript">
	//Mes trip
	$(function() {
		$("#accordionMyTrip").accordion({
			
		});
	});
	$(function() {
		$("#accordionMessages").accordion();
	});
	</script>
	
	<script type="text/javascript">
	//calendrier
	$(function() {
		$("#datepickerPost").datepicker({	minDate: new Date(),
										showOn: 'button',
										buttonImage: WEB_ROOT_URL +'CSAppWeb/img/calendar.gif',
										buttonImageOnly: true
		});
		$("#datepickerSearch").datepicker({	minDate: new Date(),
										showOn: 'button',
										buttonImage: WEB_ROOT_URL +'CSAppWeb/img/calendar.gif',
										buttonImageOnly: true
		});
	});
	</script>
	
	<!--
	<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=true_or_false&amp;key=ABQIAAAAhwuFv1NAstZCHH8AiSuPuxTb-vLQlFZmc2N8bgWI8YDPp5FEVBR9pSe4Gzwwt40rlHUJkOdIyMxO4A" type="text/javascript"></script>
	-->

</head>