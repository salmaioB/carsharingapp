<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<span style="float:left;">
	<a href="http://localhost:8888/CSAppWeb/Accueil">
		<img src="http://static.comuto.com/static/images/logo_covoituragefr.gif" />
	</a>
</span>


<span style="float:right;">
	<table>
		<tr>
			<td>
				<a href="http://<%=cs.define.Define.address%>:<%=cs.define.Define.port%>/CSAppWeb/Accueil?langage=fr">
					<img src="img/flag_FR.jpg" height="60px;"/>
				</a>
			</td>
			<td>
				<a href="http://<%=cs.define.Define.address%>:<%=cs.define.Define.port%>/CSAppWeb/Accueil?langage=en">
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