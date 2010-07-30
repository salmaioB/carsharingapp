<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<img src="http://static.comuto.com/static/images/logo_covoituragefr.gif" />

<div style="float:right;">
<table>
	<tr>
		<td>
			<a href="http://localhost:8888/CSAppWeb/Accueil?langage=fr">
				<img src="img/flag_FR.jpg" height="60px;"/>
			</a>
		</td>
		<td>
			<a href="http://localhost:8888/CSAppWeb/Accueil?langage=en">
				<img src="img/flag_UK.jpg" height="60px;"/>
			</a>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<sx:div id="divToUpdate" name="divToUpdate" loadingText="Loading..." href="LoginActionAjax" showLoadingText="true" >
			</sx:div>
		</td>
	</tr>
</table>
</div>