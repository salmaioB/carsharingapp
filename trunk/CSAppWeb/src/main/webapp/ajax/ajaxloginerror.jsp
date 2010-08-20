<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<form method="post" id="login_form" action="<%=cs.define.Define.webRootUrl%>CSAppWeb/Accueil">
	<span style="width: 160px;">Login</span> <input id="username" name="username" class="" size="8"/>
	<span style="width: 160px;">Password</span><input id="password" name="password" type="password" size="8"/>
	<input type="submit" class="check" value="<s:property value="tr.tr_html(38)"/>"/>		     
</form>