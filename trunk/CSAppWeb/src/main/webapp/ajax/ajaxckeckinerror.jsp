<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<form method="post" id="checkaddress_form">
	<table>
		<tr>
			<td>
				<span style="width: 160px;">Login</span>
			</td>
			<td>
				<input name="customerLogin" id="customerLogin" size="10"/>
			</td>
		</tr>
		<tr>
			<td>
				<span style="width: 160px;">Password</span>
			</td>
			<td>
				<input name="customerPassword" id="customerPassword" type="password" size="10"/>
			</td>
		</tr>
		<tr>
			<td>
				<span style="width: 160px;"><s:property value="tr.tr_html(20)"/></span>
			</td>
			<td>
				<input name="emailAddress" id="emailAddress" size="10"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" class="checkin" value="<s:property value="tr.tr_html(37)"/>"/>
			</td>
		</tr>
	</table>     
</form>