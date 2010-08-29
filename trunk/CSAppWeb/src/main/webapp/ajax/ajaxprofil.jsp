<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="corner">
	<s:if test="isLoging">
		<form method="post" id="checkaddress_form" name="checkaddress_form">
	</s:if>
	<s:else>
		<form method="post" id="register_form" action="CheckIn">
	</s:else>
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
					<span>
						<input type="radio" name="acceptAnimals" 
							value="1"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptAnimals==1">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_animals_green.png" width="30" title="<s:property value="tr.tr_html(24)"/>" />
					</span>
					<span>
						<input type="radio" name="acceptAnimals" 
							value="0"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptAnimals==0">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_animals_red.png" width="30" title="<s:property value="tr.tr_html(63)"/>" />
					</span>
					<span>
						<input type="radio" name="acceptAnimals" 
							value="2"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptAnimals==2">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_animals_yellow.png" width="30" title="<s:property value="tr.tr_html(62)"/>" />
					</span>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(25)"/></span>
				</td>
				<td colspan="2">
					<span>
						<input type="radio" name="acceptRadio" 
							value="1"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptRadio==1">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_radio_green.png" width="30" title="<s:property value="tr.tr_html(25)"/>" />
					</span>
					<span>
						<input type="radio" name="acceptRadio" 
							value="1"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptRadio==0">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_radio_red.png" width="30" title="<s:property value="tr.tr_html(64)"/>" />
					</span>
					<span>
						<input type="radio" name="acceptRadio" 
							value="2"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptRadio==2">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_radio_yellow.png" width="30" title="<s:property value="tr.tr_html(62)"/>" />
					</span>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(26)"/></span>
				</td>
				<td colspan="2">
					<span>
						<input type="radio" name="acceptSmoker" 
							value="1"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptSmoker==1">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_smoker_green.png" width="30" title="<s:property value="tr.tr_html(26)"/>" />
					</span>
					<span>
						<input type="radio" name="acceptSmoker"
							value="0"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptSmoker==0">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_smoker_red.png" width="30" title="<s:property value="tr.tr_html(65)"/>" />
					</span>
					<span>
						<input type="radio" name="acceptSmoker" 
							value="2"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptSmoker==2">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_smoker_yellow.png" width="30" title="<s:property value="tr.tr_html(62)"/>"/>
					</span>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(27)"/></span>
				</td>
				<td colspan="2">
					<span>
						<input type="radio" name="acceptToDiscuss" 
							value="1"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptToDiscuss==1">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_to_discuss_green.png" width="30" title="<s:property value="tr.tr_html(27)"/>" />
					</span>
					<span>
						<input type="radio" name="acceptToDiscuss"
							value="0"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptToDiscuss==0">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_to_discuss_red.png" width="30" title="<s:property value="tr.tr_html(66)"/>"/>
					</span>
					<span>
						<input type="radio" name="acceptToDiscuss" 
							value="2"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptToDiscuss==2">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_to_discuss_yellow.png" width="30" title="<s:property value="tr.tr_html(62)"/>"/>
					</span>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(28)"/></span>
				</td>
				<td colspan="2">
					<span>
						<input type="radio" name="acceptToMakeADetour" 
							value="1"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptToMakeADetour==1">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_to_make_a_detour_green.png" width="30" title="<s:property value="tr.tr_html(28)"/>" />
					</span>
					<span>
						<input type="radio" name="acceptToMakeADetour"
							value="0"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptToMakeADetour==0">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_to_make_a_detour_red.png" width="30" title="<s:property value="tr.tr_html(67)"/>" />
					</span>
					<span>
						<input type="radio" name="acceptToMakeADetour" 
							value="2"
							<s:if test="!getIsCurrentCustomer()">readonly="readonly"</s:if>
							<s:if test="customerAccountProfil.acceptToMakeADetour==2">checked="checked"</s:if>
						/>
						<img src="img/icon/accept_to_make_a_detour_yellow.png" width="30" title="<s:property value="tr.tr_html(62)"/>" />
					</span>
				</td>
			</tr>
			<s:if test="getIsCurrentCustomer()">
				<tr>
					<td colspan="2">
						<input type="submit" class="checkin submit" value="<s:property value="tr.tr_html(36)"/>" />
					</td>
				</tr>
			</s:if>
			<s:if test="isLoging">
				<tr>
					<td colspan="2">
						<input type="submit" value="<s:property value="tr.tr_html(36)"/>" />
					</td>
				</tr>
			</s:if>
		</table>
	</form>
	<s:if test="!getIsCurrentCustomer()">
		<table>
			<tr>
				<td colspan="2">
					<div id="sending<s:property value="customerAccountProfil.lastName" />"
					 	name="sending<s:property value="customerAccountProfil.lastName" />" 
					 	style="background-color:#009ACF; display:none;">
						<s:property value="tr.tr_html(47)"/>
					</div>
					<form method="post" id="form_sendMessage<s:property value="customerAccountProfil.lastName" />">
						<input type="text" id="idOffer" name="idOffer" style="display:none;" value="<s:property value="idOffer"/>" />
						<input type="text" id="idCustomer" name="idCustomer" style="display:none;" value="<s:property value="customerAccountProfil.id"/>" />
						<input type="text" 	id="title<s:property value="customerAccountProfil.lastName" />" 
											name="titleSendSearch"/><br />
						<input 	name="contentSendSearch" 
									id="content<s:property value="customerAccountProfil.lastName" />" 
									style="width:100%; height:100px;" />
						<input type="button" value="<s:property value="tr.tr_html(30)"/>" onclick="ajaxSendMessageCustomer('<s:property value="customerAccountProfil.lastName" />');"/>
					</form>
				</td>
			</tr>
		</table>
	</s:if>
</div>