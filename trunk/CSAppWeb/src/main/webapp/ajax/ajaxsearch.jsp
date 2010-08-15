<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="corner" >
	<form method="post" id="search_form">
		<span style="width: 160px;">Date</span> <input readonly="readonly" type="text" id="datepickerSearch" /><br />
		<span style="width: 160px;"><s:property value="tr.tr_html(8)"/></span> <input name="start" class="" size="10"/><br />
		<span style="width: 160px;"><s:property value="tr.tr_html(9)"/></span><input name="stop" size="10"/><br />
		<input type="submit" class="Csearch" value="<s:property value="tr.tr_html(5)"/>""/>		     
	</form>
</div>