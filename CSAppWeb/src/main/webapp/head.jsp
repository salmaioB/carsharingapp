<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<head>
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>

	<script type="text/javascript" src="js/jtabs/jquery.tabs.js"></script>
	<script type="text/javascript" src="js/jtabs/jquery.history_remote.pack.js"></script>

	<script type="text/javascript" src="js/jquery.ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.datepicker.js"></script>
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.accordion.js"></script>

	<script type="text/javascript" src="js/jquery.corner.js"></script>
		
    <script type="text/javascript" src="js/jquery.login.js"></script>	
    		
	<link type="text/css" href="css/jquery.tabs.css" rel="stylesheet" />
	<link type="text/css" href="css/jquery.tabs.css" rel="stylesheet" />
	<link type="text/css" href="css/themes/base/jquery.ui.all.css" rel="stylesheet" />
	<link type="text/css" href="css/css.css" rel="stylesheet" />
	
	<style type="text/css">
	.body{
		height:400px;
	}
	.left{
		height:100%;
	}
	.corner {
		background-color:#AAAAAA;
	}
	</style>
	<script type="text/javascript"> 
		$(document).ready( function () { 
			$('#container').tabs({ fxFade: true, fxSpeed: 'normal' });
		} ) ; 
		$(document).ready( function () { 
			$('#containerLeft').tabs({ fxFade: true, fxSpeed: 'normal' });
		} ) ;
		$(document).ready( function () { 
			$(".corner").corner();
		} ) ;
	</script>

	<script type="text/javascript">
	//Mes trip
	$(function() {
		$("#accordionMyTrip").accordion({
			
		});
	});
	</script>
	
	<script type="text/javascript">
	//calendrier
	$(function() {
		$("#datepicker").datepicker({	minDate: new Date(),
										showOn: 'button',
										buttonImage: 'http://localhost:8888/CSAppWeb/img/calendar.gif',
										buttonImageOnly: true
		});
	});
	</script>
	
	<!--
	<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=true_or_false&amp;key=ABQIAAAAhwuFv1NAstZCHH8AiSuPuxTb-vLQlFZmc2N8bgWI8YDPp5FEVBR9pSe4Gzwwt40rlHUJkOdIyMxO4A" type="text/javascript"></script>
	-->
	<script type="text/javascript" src="js/googlemap.js"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>

</head>