<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="body" id="search"> 
   	<s:include value="/ajax/ajaxsearch.jsp" />
</div> 
<div class="body" id="post">
	<s:if test="isLoging()">
		<s:include value="/ajax/ajaxposter.jsp" />
	</s:if>
 	<s:else>
    	<div class="corner" >Non identifié</div>
 	</s:else>
</div>
<div class="body" id="profil">
	<s:if test="isLoging()">
		<s:include value="/ajax/ajaxprofil.jsp" />
	</s:if>
 	<s:else>
    	<div class="corner" >Non identifié</div>
 	</s:else>
</div> 
<div class="body" id="message"> 
	<s:if test="isLoging()">
		Message
	</s:if>
 	<s:else>
    	<div class="corner" >Non identifié</div>
 	</s:else>
</div>
<div class="body" id="trip">
	<s:if test="isLoging()">
		<s:include value="/ajax/mytrip.jsp" />
	</s:if>
 	<s:else>
    	<div class="corner" >Non identifié</div>
 	</s:else>
</div> 
        
Message : <s:property value="message"/> <br />
Affiche list : <s:property value="tr.tr_html(1)"/>

<a href="http://<%=cs.define.Define.webRootUrl%>CSAppWeb/Accueil?type=Offer">Offer</a>
<a href="http://<%=cs.define.Define.webRootUrl%>CSAppWeb/Accueil?type=CustomerAccounts">CustomerAccounts</a>

    