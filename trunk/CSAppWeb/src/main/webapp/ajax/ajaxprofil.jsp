<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="corner">
	<form method="post" id="checkaddress_form" name="checkaddress_form">
		<table>	
				<tr>
					<s:if test="getIsCurrentCustomer()">
						<td>
							<em>*</em><span style="width: 160px;">Login</span>
						</td>
						<td>
							<input id="customerLogin" name="customerLogin" class="required" size="20" value="<s:property value="customerAccountProfil.customerLogin" />"/>
						</td>
					</s:if>
					<s:else>
						<td colspan="2"></td>
					</s:else>
					<td rowspan="10" >
						<s:if test="getIsCurrentCustomer()">
							<input type="submit" class="checkAddress" value="<s:property value="tr.tr_html(49)"/>" style="width:500px;"/>
							<br />
							<input type="submit" class="testAddress" value="<s:property value="tr.tr_html(35)"/>" style="width:500px;" />
							<div id="divProfilMapAnddroid" style="height:300px;">
								<div id="divMapProfil" style="width: 500px; height: 300px"></div>
							</div>
						</s:if>
						<s:else>
							<input type="submit" class="checkAddress" value="<s:property value="tr.tr_html(50)"/>" style="width:500px;"/>
							<br />
							<input type="submit" class="testAddress" value="<s:property value="tr.tr_html(51)"/>" style="width:500px;" />
							<div id="divProfilMapAnddroid" style="height:300px;">
								<div id="divMapProfil" style="width: 500px; height: 300px"></div>
							</div>
						</s:else>
					</td>
				</tr>
			<s:if test="getIsCurrentCustomer()">
				<tr>
					<td>
						<span style="width: 160px;"><em>*</em><s:property value="tr.tr_html(29)"/></span>
					</td>
					<td colspan="2">
						<input class="required"  name="customerPassword" type="password" size="20" value="<s:property value="customerAccountProfil.customerPassword" />"/>
					</td>
				</tr>
			</s:if>
			<tr>
				<td>
					<span style="width: 160px;"><em>*</em><s:property value="tr.tr_html(18)"/></span>
				</td>
				<td colspan="2">
					<input class="required" name="lastName"  size="20" value="<s:property value="customerAccountProfil.lastName" />"
					<s:if test="!getIsCurrentCustomer()"> readonly="readonly" </s:if>
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><em>*</em><s:property value="tr.tr_html(19)"/></span>
				</td>
				<td colspan="2">
					<input class="required" name="firstName" size="20" value="<s:property value="customerAccountProfil.firstName" />"
					<s:if test="!getIsCurrentCustomer()"> readonly="readonly" </s:if>
					/>
				</td>	
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><em>*</em><s:property value="tr.tr_html(20)"/></span>
				</td>
				<td colspan="2">
					<input class="required email" name="emailAddress" size="20" value="<s:property value="customerAccountProfil.emailAddress" />"
					<s:if test="!getIsCurrentCustomer()"> readonly="readonly" </s:if>
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(21)"/></span>
				</td>
				<td colspan="2">
					<input class="number" name="phone" size="20" value="<s:property value="customerAccountProfil.phone" />"
					<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(22)"/></span>
				</td>
				<td colspan="2">
					<input class="number" name="mobile" size="20" value="<s:property value="customerAccountProfil.mobile" />"
					<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(12)"/></span>
				</td>
				<td colspan="2">
					<input id="address" name="address" size="20" value="<s:property value="customerAccountProfil.address" />"
					<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(11)"/></span>
				</td>
				<td colspan="2">
					<input id="ville" name="ville" size="20" value="<s:property value="customerAccountProfil.country" />"
					<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(23)"/></span>
				</td>
				<td colspan="2">
					<input class="number" id="zipCode" name="zipCode" size="20" value="<s:property value="customerAccountProfil.zipCode" />" 
					<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
					/>
				</td>
			</tr>
			<tr>
				<td>
					sexe
				</td>
				<td>
					<span style="border:2px;">
						<span style="width:100px; position:relative; bottom:4px;"><s:property value="tr.tr_html(42)"/></span><input type="radio" id="gender" name="gender" value="1" <s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if> <s:if test="customerAccountProfil.gender==1">checked="checked"</s:if> ><img src="img/icon/icon_customer_man.png" width="30"/>
						<span style="width:100px; position:relative; bottom:4px;">| </span> 
						<span style="width:100px; position:relative; bottom:4px;"><s:property value="tr.tr_html(43)"/></span><input type="radio" id="gender" name="gender" value="0" <s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if> <s:if test="customerAccountProfil.gender==0">checked="checked"</s:if>><img src="img/icon/icon_customer_woman.png" width="30"/> 
					</span>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(24)"/></span>
				</td>
				<td colspan="2">
					<input type="checkbox" name="acceptAnimals" 
						<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
						<s:if test="customerAccountProfil.acceptAnimals==1">checked="checked"</s:if> 
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(25)"/></span>
				</td>
				<td colspan="2">
					<input type="checkbox" name="acceptRadio" 
						<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
						<s:if test="customerAccountProfil.acceptRadio==1">checked="checked"</s:if> 
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(26)"/></span>
				</td>
				<td colspan="2">
					<input type="checkbox" name="acceptSmoker" 
						<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
						<s:if test="customerAccountProfil.acceptSmoker==1">checked="checked"</s:if> 
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(27)"/></span>
				</td>
				<td colspan="2">
					<input type="checkbox" name="acceptToDiscuss" 
						<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
						<s:if test="customerAccountProfil.acceptToDiscuss==1">checked="checked"</s:if> 
					/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(28)"/></span>
				</td>
				<td colspan="2">
					<input type="checkbox" name="acceptToMakeADetour" 
						<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
						<s:if test="customerAccountProfil.acceptToMakeADetour==1">checked="checked"</s:if> 
						<s:if test="getIsCurrentCustomer()">style="disabled:true;"</s:if>
					/>
				</td>
			</tr>
			<s:if test="getIsCurrentCustomer()">
				<tr>
					<td colspan="2">
						<input type="submit" class="checkin submit" value="<s:property value="tr.tr_html(36)"/>" />
					</td>
				</tr>
			</s:if>
		</table>
	</form>
</div>