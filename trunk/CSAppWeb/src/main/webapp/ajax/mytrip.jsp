<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="menuTrip">
	<ul> 
		<li><a href="#myPostOffer"><span><s:property value="tr.tr_html(59)"/><div align="center" id="divWaitingMyPostOffer" style="display:none;"><img src="img/ajax-loader.gif" width="120"></div></span></a></li> 
	    <li><a href="#myAgreeOffer"><span><s:property value="tr.tr_html(60)"/><div align="center" id="divWaitingMmAgreeOffer" style="display:none;"><img src="img/ajax-loader.gif" width="120"></div></span></a></li>
	</ul>
	<div id="myPostOffer" class="body" ></div>
	<div id="myAgreeOffer" class="body"></div>
</div>