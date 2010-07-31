<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<head>
	<sx:head/>
	<script type="text/javascript" src="js/jquery-1.4.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.login.js"></script>	
	<script type="text/javascript" src="js/jtabs/jquery.tabs.js"></script>
	<script type="text/javascript" src="js/jtabs/jquery.history_remote.pack.js"></script>
		
	<link type="text/css" href="css/jquery.tabs.css" rel="stylesheet" />
	<link type="text/css" href="css/jquery.tabs.css" rel="stylesheet" />
	
	<script type="text/javascript"> 
		$(document).ready( function () { 
			$('#container').tabs({ fxFade: true, fxSpeed: 'normal' });
		} ) ; 
		$(document).ready( function () { 
			$('#containerLeft').tabs({ fxFade: true, fxSpeed: 'normal' });
		} ) ;  
	</script>
</head>