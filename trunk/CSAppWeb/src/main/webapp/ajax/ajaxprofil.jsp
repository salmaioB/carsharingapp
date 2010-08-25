<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="corner">
	<form method="post" id="checkaddress_form" name="checkaddress_form">
		<table>	
			<tr>
				<td>
					<em>*</em><span style="width: 160px;">Login</span>
				</td>
				<td>
					<input id="customerLogin" name="customerLogin" class="required" size="20" value="<s:property value="customerAccount.customerLogin" />"/>
				</td>
				<td rowspan="10" >
					<input type="submit" class="checkAddress" value="Valider la position de l'adresse" size="50"/>
					<br />
					<input type="submit" class="testAddress" value="<s:property value="tr.tr_html(35)"/>" size="50" />
					<div id="divProfilMapAnddroid" style="height:300px;">
						<div id="divMapProfil" style="width: 500px; height: 300px"></div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><em>*</em><s:property value="tr.tr_html(29)"/></span>
				</td>
				<td colspan="2">
					<input class="required"  name="customerPassword" type="password" size="20" value="<s:property value="customerAccount.customerPassword" />"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><em>*</em><s:property value="tr.tr_html(18)"/></span>
				</td>
				<td colspan="2">
					<input class="required" name="lastName"  size="20" value="<s:property value="customerAccount.lastName" />"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><em>*</em><s:property value="tr.tr_html(19)"/></span>
				</td>
				<td colspan="2">
					<input class="required" name="firstName" size="20" value="<s:property value="customerAccount.firstName" />"/>
				</td>	
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><em>*</em><s:property value="tr.tr_html(20)"/></span>
				</td>
				<td colspan="2">
					<input class="required email" name="emailAddress" size="20" value="<s:property value="customerAccount.emailAddress" />"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(21)"/></span>
				</td>
				<td colspan="2">
					<input class="number" name="phone" size="20" value="<s:property value="customerAccount.phone" />"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(22)"/></span>
				</td>
				<td colspan="2">
					<input class="number" name="mobile" size="20" value="<s:property value="customerAccount.mobile" />"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(12)"/></span>
				</td>
				<td colspan="2">
					<input id="address" name="address" size="20" value="<s:property value="customerAccount.address" />"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(11)"/></span>
				</td>
				<td colspan="2">
					<input id="ville" name="ville" size="20" value="<s:property value="customerAccount.country" />"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(23)"/></span>
				</td>
				<td colspan="2">
					<input class="number" id="zipCode" name="zipCode" size="20" value="<s:property value="customerAccount.zipCode" />" />
				</td>
			</tr>
			<tr>
				<td>
					sexe
				</td>
				<td>
					<span style="border:2px;">
						<span style="width:100px; position:relative; bottom:4px;"><s:property value="tr.tr_html(42)"/></span><input type="radio" id="gender" name="gender" value="1" <s:if test="customerAccount.gender==1">checked="checked"</s:if> ><img src="img/icon/icon_customer_man.png" width="30"/>
						<span style="width:100px; position:relative; bottom:4px;">| </span> 
						<span style="width:100px; position:relative; bottom:4px;"><s:property value="tr.tr_html(43)"/></span><input type="radio" id="gender" name="gender" value="0" <s:if test="customerAccount.gender==0">checked="checked"</s:if>><img src="img/icon/icon_customer_woman.png" width="30"/> 
					</span>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(24)"/></span>
				</td>
				<td colspan="2">
					<input type="checkbox" name="acceptAnimals" 
						<s:if test="customerAccount.acceptAnimals==1">checked="checked"</s:if> 
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(25)"/></span>
				</td>
				<td colspan="2">
					<input type="checkbox" name="acceptRadio" 
						<s:if test="customerAccount.acceptRadio==1">checked="checked"</s:if> 
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(26)"/></span>
				</td>
				<td colspan="2">
					<input type="checkbox" name="acceptSmoker" 
						<s:if test="customerAccount.acceptSmoker==1">checked="checked"</s:if> 
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(27)"/></span>
				</td>
				<td colspan="2">
					<input type="checkbox" name="acceptToDiscuss" 
						<s:if test="customerAccount.acceptToDiscuss==1">checked="checked"</s:if> 
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(28)"/></span>
				</td>
				<td colspan="2">
					<input type="checkbox" name="acceptToMakeADetour" 
						<s:if test="customerAccount.acceptToMakeADetour==1">checked="checked"</s:if> 
					/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" class="checkin submit" value="<s:property value="tr.tr_html(36)"/>" />
				</td>
			</tr>  
		</table>
	</form>
</div>