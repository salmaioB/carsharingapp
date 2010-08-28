<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="menuTrip">
	<ul> 
		<li><a href="#myPostOffer"><span>Mes offres poster<div align="center" id="divWaitingMyPostOffer" style="display:none;"><img src="img/ajax-loader.gif" width="120"></div></span></a></li> 
	    <li><a href="#myAgreeOffer"><span>Mes offres accepter<div align="center" id="divWaitingMmAgreeOffer" style="display:none;"><img src="img/ajax-loader.gif" width="120"></div></span></a></li>
	</ul>
	<div id="myPostOffer" class="body" ></div>
	<div id="myAgreeOffer" class="body"></div>
</div>