<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<br />

<table cellpadding="3" cellspacing="3">
	<s:iterator value="owca" id="owca">
		<tr style="height:10px; font-size: 0.7em; " >
			<td style="border:1px solid black; width:500px;" colspan="2"><span><s:property value="tr.tr_html(8)"/> : <span style="color:blue;"><s:property value="%{#owca.offer.startingCity}" /></span></span> <span><s:property value="tr.tr_html(9)"/> : <span style="color:blue;"><s:property value="%{#owca.offer.finishingCity}" /></span></span></td>
		</tr>
		<tr style="border:1px solid black;">
			<td style="font-size: 0.8em; border:1px solid black; width:800px;">
				<table>
					<tr>
						<td>
							<s:if test="%{#owca.customerAccount.gender==1}" >
								<img src="img/icon/icon_customer_man.png" title="<s:property value="%{#owca.customerAccount.firstName}" />" />
							</s:if>
							<s:else>
								<img src="img/icon/icon_customer_woman.png" title="<s:property value="%{#owca.customerAccount.firstName}" /> "/>
							</s:else>
						</td>
						<td >
							<div style="font-size: 1.2em; color:blue;">
								<s:property value="%{#owca.offer.pricePerPassenger}" /> 
							</div>
							<span style="font-size: 0.8em; color:blue;">
								euros par passager
							</span>
						</td>
						<td style="font-size: 1.2em; color:gray;">
							<s:property value="%{#owca.offer.numberOfPlaceRemaining}" /> pl.
						</td>
						<td>
							<span style="font-size: 0.8em; color:gray;">
								<s:property value="tr.tr_html(44)"/>
							</span>
						</td>
						<td style=" width:500px; align:right; " >
							<s:if test="%{#owca.customerAccount.acceptAnimals==0}">
								<img src="img/icon/accept_animals_red.png" style="width:35px;" title="<s:property value="tr.tr_html(63)"/>"/>
							</s:if>
							<s:elseif test="%{#owca.customerAccount.acceptAnimals==1}">
								<img src="img/icon/accept_animals_green.png" style="width:35px;" title="<s:property value="tr.tr_html(24)"/>"/>
							</s:elseif>
							<s:elseif test="%{#owca.customerAccount.acceptAnimals==2}">
								<img src="img/icon/accept_animals_yellow.png" style="width:35px;" title="<s:property value="tr.tr_html(62)"/>" />
							</s:elseif>
												
							<s:if test="%{#owca.customerAccount.acceptRadio==0}">
								<img src="img/icon/accept_radio_red.png" style="width:35px;" title="<s:property value="tr.tr_html(64)"/>"/>
							</s:if>
							<s:elseif test="%{#owca.customerAccount.acceptRadio==1}">
								<img src="img/icon/accept_radio_green.png" style="width:35px;" title="<s:property value="tr.tr_html(25)"/>"/>
							</s:elseif>
							<s:elseif test="%{#owca.customerAccount.acceptRadio==2}">
								<img src="img/icon/accept_radio_yellow.png" style="width:35px;" title="<s:property value="tr.tr_html(62)"/>"/>
							</s:elseif>
							
							<s:if test="%{#owca.customerAccount.acceptSmoker==0}">
								<img src="img/icon/accept_smoker_red.png" style="width:35px;" title="<s:property value="tr.tr_html(65)"/>" />
							</s:if>
							<s:elseif test="%{#owca.customerAccount.acceptSmoker==1}">
								<img src="img/icon/accept_smoker_green.png" style="width:35px;" title="<s:property value="tr.tr_html(26)"/>"/>
							</s:elseif>
							<s:elseif test="%{#owca.customerAccount.acceptSmoker==2}">
								<img src="img/icon/accept_smoker_yellow.png" style="width:35px;" title="<s:property value="tr.tr_html(62)"/>"/>
							</s:elseif>
							
							<s:if test="%{#owca.customerAccount.acceptToDiscuss==0}">
								<img src="img/icon/accept_to_discuss_red.png" style="width:35px;" title="<s:property value="tr.tr_html(66)"/>" />
							</s:if>
							<s:elseif test="%{#owca.customerAccount.acceptToDiscuss==1}">
								<img src="img/icon/accept_to_discuss_green.png" style="width:35px;" title="<s:property value="tr.tr_html(27)"/>"/>
							</s:elseif>
							<s:elseif test="%{#owca.customerAccount.acceptToDiscuss==2}">
								<img src="img/icon/accept_to_discuss_yellow.png" style="width:35px;" title="<s:property value="tr.tr_html(62)"/>"/>
							</s:elseif>
							
							<s:if test="%{#owca.customerAccount.acceptToMakeADetour==0}">
								<img src="img/icon/accept_to_make_a_detour_red.png" style="width:35px;" title="<s:property value="tr.tr_html(67)"/>" />
							</s:if>
							<s:elseif test="%{#owca.customerAccount.acceptToMakeADetour==1}">
								<img src="img/icon/accept_to_make_a_detour_green.png" style="width:35px;" title="<s:property value="tr.tr_html(28)"/>"/>
							</s:elseif>
							<s:elseif test="%{#owca.customerAccount.acceptToMakeADetour==2}">
								<img src="img/icon/accept_to_make_a_detour_yellow.png" style="width:35px;" title="<s:property value="tr.tr_html(62)"/>" />
							</s:elseif>				
						</td>
						<td>
							<a href="#" onclick="printTrip(<s:property value="%{#owca.id}"/>,'<s:property value="divPrintResultat"/>')"><s:property value="tr.tr_html(45)"/></a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</s:iterator>
</table>