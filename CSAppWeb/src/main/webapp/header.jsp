<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<span style="float:left;">
	<a href=" /CSAppWeb/Accueil">
		<img src="img/icon/icon_logo.png" height="70" />
	</a>
</span>

<span style="float:right;">
	<table>
		<tr>
			<td>
				<a href="/CSAppWeb/Accueil?langage=fr">
					<img src="img/flag_FR.jpg" height="60px;"/>
				</a>
			</td>
			<td>
				<a href="/CSAppWeb/Accueil?langage=en">
					<img src="img/flag_UK.jpg" height="60px;"/>
				</a>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="divToLogin"  >
					<%
						if( session.getAttribute("customerId") == null)
						{
					%>
					<s:include value="/ajax/ajaxloginerror.jsp" />
					<%
						}
						else
						{
					%>
					<s:include value="/ajax/ajaxloginsuccess.jsp" />
					<%
						}
					%>
				</div>
			</td>
		</tr>
	</table>
</span>