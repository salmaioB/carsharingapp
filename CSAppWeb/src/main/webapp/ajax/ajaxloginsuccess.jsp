<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<form method="post" id="checkout_form">
	<span style="width: 160px;"><s:property value="tr.tr_html(2)"/> <s:property value="customerAccount.customerLogin"/>
	(<s:property value="nbMessageNotRead"/>)
	</span>
	<input type="submit" class="checkout" value="<s:property value="tr.tr_html(4)"/>"/>		     
</form>