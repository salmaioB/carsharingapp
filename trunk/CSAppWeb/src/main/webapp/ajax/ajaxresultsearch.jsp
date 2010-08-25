<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<br />

<table cellpadding="3" cellspacing="3">
	<s:iterator value="owca" id="owca">
		<tr style="height:10px; font-size: 0.7em; " >
			<td style="border:1px solid black; width:500px;" colspan="2"><span>Depart : <span style="color:blue;"><s:property value="%{#owca.startingCity}" /></span></span> <span>Arrive : <span style="color:blue;"><s:property value="%{#owca.finishingCity}" /></span></span></td>
		</tr>
		<tr style="border:1px solid black;">
			<td style="font-size: 0.8em; border:1px solid black; width:800px;">
				<table>
					<tr>
						<td>
							<s:if test="%{#owca.gender==1}" >
								<img src="img/icon/icon_customer_man.png" />
							</s:if>
							<s:else>
								<img src="img/icon/icon_customer_woman.png" />
							</s:else>
						</td>
						<td >
							<div style="font-size: 1.2em; color:blue;">
								<s:property value="%{#owca.pricePerPassenger}" /> 
							</div>
							<span style="font-size: 0.8em; color:blue;">
								euros par passager
							</span>
						</td>
						<td style="font-size: 1.2em; color:gray;">
							<s:property value="%{#owca.numberOfPlaceRemaining}" /> pl.
						</td>
						<td>
							<span style="font-size: 0.8em; color:gray;">
								<s:property value="tr.tr_html(44)"/>
							</span>
						</td>
						<td style=" width:500px; align:right; " >
							<s:if test="%{#owca.acceptAnimals==0}">
								<img src="img/icon/accept_animals_red.png" style="width:35px;" />
							</s:if>
							<s:elseif test="%{#owca.acceptAnimals==1}">
								<img src="img/icon/accept_animals_green.png" style="width:35px;" />
							</s:elseif>
							<s:elseif test="%{#owca.acceptAnimals==2}">
								<img src="img/icon/accept_animals_yellow.png" style="width:35px;" />
							</s:elseif>
												
							<s:if test="%{#owca.acceptRadio==0}">
								<img src="img/icon/accept_radio_red.png" style="width:35px;" />
							</s:if>
							<s:elseif test="%{#owca.acceptRadio==1}">
								<img src="img/icon/accept_radio_green.png" style="width:35px;" />
							</s:elseif>
							<s:elseif test="%{#owca.acceptRadio==2}">
								<img src="img/icon/accept_radio_yellow.png" style="width:35px;" />
							</s:elseif>
							
							<s:if test="%{#owca.acceptSmoker==0}">
								<img src="img/icon/accept_smoker_red.png" style="width:35px;" />
							</s:if>
							<s:elseif test="%{#owca.acceptSmoker==1}">
								<img src="img/icon/accept_smoker_green.png" style="width:35px;" />
							</s:elseif>
							<s:elseif test="%{#owca.acceptSmoker==2}">
								<img src="img/icon/accept_smoker_yellow.png" style="width:35px;" />
							</s:elseif>
							
							<s:if test="%{#owca.acceptToDiscuss==0}">
								<img src="img/icon/accept_discuss_red.png" style="width:35px;" />
							</s:if>
							<s:elseif test="%{#owca.acceptToDiscuss==1}">
								<img src="img/icon/accept_discuss_green.png" style="width:35px;" />
							</s:elseif>
							<s:elseif test="%{#owca.acceptToDiscuss==2}">
								<img src="img/icon/accept_discuss_yellow.png" style="width:35px;" />
							</s:elseif>
							
							<s:if test="%{#owca.acceptToMakeADetour==0}">
								<img src="img/icon/accept_to_make_a_detour_red.png" style="width:35px;" />
							</s:if>
							<s:elseif test="%{#owca.acceptToMakeADetour==1}">
								<img src="img/icon/accept_to_make_a_detour_green.png" style="width:35px;" />
							</s:elseif>
							<s:elseif test="%{#owca.acceptToMakeADetour==2}">
								<img src="img/icon/accept_to_make_a_detour_yellow.png" style="width:35px;" />
							</s:elseif>				
						</td>
						<td>
							<a href="#" onclick="printTrip(<s:property value="%{#owca.id}"/>)">fiche trajet</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</s:iterator>
</table>