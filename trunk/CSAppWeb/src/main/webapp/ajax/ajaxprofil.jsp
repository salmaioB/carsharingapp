<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="corner">
	<table>
		<form method="post" id="checkaddress_form">
			<tr>
				<td>
					<span style="width: 160px;">Login</span>
				</td>
				<td>
					<input name="customerLogin" class="" size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(29)"/></span>
				</td>
				<td>
					<input name="customerPassword" type="password" size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(18)"/></span>
				</td>
				<td>
					<input name="lastName"  size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(19)"/></span>
				</td>
				<td>
					<input name="firstName" size="4"/>
				</td>	
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(20)"/></span>
				</td>
				<td>
					<input name="emailAddress" size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(21)"/></span>
				</td>
				<td>
					<input name="phone" size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(22)"/></span>
				</td>
				<td>
					<input name="mobile" size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(12)"/></span>
				</td>
				<td>
					<input name="address" size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(11)"/></span>
				</td>
				<td>
					<input name="ville" size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(23)"/></span>
				</td>
				<td>
					<input name="cp" size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(24)"/></span>
				</td>
				<td>
					<input type="checkbox" name="acceptAnimals" size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(25)"/></span>
				</td>
				<td>
					<input type="checkbox" name="acceptRadio" size="4"/>
				</td>

			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(26)"/></span>
				</td>
				<td>
					<input type="checkbox" name="acceptSmoker" size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(27)"/></span>
				</td>
				<td>
					<input type="checkbox" name="acceptToDiscuss" size="4"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(28)"/></span>
				</td>
				<td>
					<input type="checkbox" name="acceptToDiscuss" size="4"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" class="checkin"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<form method="POST" id="checkAddressNext_form">
						<input type="submit" class="checkAddress" value="Valider la position de l'adresse"/>
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<form method="POST" id="testAddressAndroid_form">
						<input type="submit" class="testAddress" value="Test la geolocalisation avec votre mobile android" />
					</form>
				</td>
			</tr>     
		</form>
	</table>
</div>