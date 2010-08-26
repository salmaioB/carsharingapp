<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="corner">
<table style="border:1px solid black;">
	<tr style="border:1px solid black;">
		<td style=" font-size: 0.8em; border:1px solid black; "><s:property value="tr.tr_html(46)"/></td>
	</tr>
	<tr>
		<td>
			<s:if test="gender==1" >
				<img src="img/icon/icon_customer_man.png" />
			</s:if>
			<s:else>
				<img src="img/icon/icon_customer_woman.png" />
			</s:else>
			<s:property value="lastName" /> <s:property value="firstName" />
		</td>
	</tr>
	<tr>
		<td style=" font-size: 0.9em; color:purple; ">Preferences</td>
	</tr>
	<tr>
		<td>
			<s:if test="acceptAnimals==0">
				<img src="img/icon/accept_animals_red.png" style="width:35px;" />
			</s:if>
			<s:elseif test="acceptAnimals==1">
					<img src="img/icon/accept_animals_green.png" style="width:35px;" />
				</s:elseif>
				<s:elseif test="acceptAnimals==2">
					<img src="img/icon/accept_animals_yellow.png" style="width:35px;" />
				</s:elseif>
												
				<s:if test="acceptRadio==0">
					<img src="img/icon/accept_radio_red.png" style="width:35px;" />
				</s:if>
				<s:elseif test="acceptRadio==1">
					<img src="img/icon/accept_radio_green.png" style="width:35px;" />
				</s:elseif>
				<s:elseif test="acceptRadio==2">
					<img src="img/icon/accept_radio_yellow.png" style="width:35px;" />
				</s:elseif>
				
				<s:if test="acceptSmoker==0">
					<img src="img/icon/accept_smoker_red.png" style="width:35px;" />
				</s:if>
				<s:elseif test="acceptSmoker==1">
					<img src="img/icon/accept_smoker_green.png" style="width:35px;" />
				</s:elseif>
				<s:elseif test="acceptSmoker==2">
					<img src="img/icon/accept_smoker_yellow.png" style="width:35px;" />
				</s:elseif>
				
				<s:if test="acceptToDiscuss==0">
					<img src="img/icon/accept_discuss_red.png" style="width:35px;" />
				</s:if>
				<s:elseif test="acceptToDiscuss==1">
					<img src="img/icon/accept_discuss_green.png" style="width:35px;" />
				</s:elseif>
				<s:elseif test="acceptToDiscuss==2">
					<img src="img/icon/accept_discuss_yellow.png" style="width:35px;" />
				</s:elseif>
				
				<s:if test="acceptToMakeADetour==0">
					<img src="img/icon/accept_to_make_a_detour_red.png" style="width:35px;" />
				</s:if>
				<s:elseif test="acceptToMakeADetour==1">
					<img src="img/icon/accept_to_make_a_detour_green.png" style="width:35px;" />
				</s:elseif>
				<s:elseif test="acceptToMakeADetour==2">
					<img src="img/icon/accept_to_make_a_detour_yellow.png" style="width:35px;" />
				</s:elseif>	
			</td>
		</tr>
	</table>
</div>