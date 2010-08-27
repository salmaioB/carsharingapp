<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="body" id="search"> 
   	<s:include value="/ajax/ajaxsearch.jsp" />
</div>
<s:if test="isLoging()"> 
	<div class="body" id="post">
		<s:include value="/ajax/ajaxposterEtape1.jsp" />

	</div>
	<div class="body" id="profil">
		<s:include value="/ajax/ajaxprofil.jsp" />
	</div>
	<div class="body" id="message"> 
		<s:include value="/ajax/messageCustomer.jsp" />
	</div>
	<div class="body" id="trip">	
		<s:include value="/ajax/mytrip.jsp" />
 	</div>
</s:if>
<s:else>
	<div class="body" id="registration">	
		<s:include value="/ajax/ajaxprofil.jsp" />
 	</div>
</s:else>