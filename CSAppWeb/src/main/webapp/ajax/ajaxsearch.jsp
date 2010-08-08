<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="corner" >
	<form method="post" id="search_form">
		<span style="width: 160px;">Date</span> <input input readonly="readonly" type="text" id="datepicker" /><br />
		<span style="width: 160px;">Depart</span> <input name="start" class="" size="10"/><br />
		<span style="width: 160px;">Arrive</span><input name="stop" size="10"/><br />
		<input type="submit" class="Csearch" value="rechercher"/>		     
	</form>
</div>