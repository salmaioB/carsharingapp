<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="menuTrip">
	<ul> 
		<li><a href="#myPostOffer"><span>Mes offres poster</span></a></li> 
	    <li><a href="#myAgreeOffer"><span>Mes offres accepter</span></a></li>
	</ul>
	
	<div id="myPostOffer" class="body" > 
	   	<div align="center" id="divWaitingMyPostOffer" style="display:none;"><img src="img/ajax-loader.gif" width="500"></div>
	</div> 
	<div id="myAgreeOffer" class="body">
		<div align="center" id="divWaitingMmAgreeOffer" style="display:none;"><img src="img/ajax-loader.gif" width="500"></div>
	</div>
</div>