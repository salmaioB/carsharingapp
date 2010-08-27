<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="corner">
	Etape 2
</div>
<div class="corner" align="center">
	<form method="post" id="post_form_etape_2">
		<table>
			<tr>
				<td>
					<span style="width: 160px;">Date</span>
				</td>
				<td>
					<input value="<s:property value="datepickerPost" />" readonly="readonly" id="datepickerPost" name="datepickerPost" type="text" size="20"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(10)"/></span>
				</td>
				<td>
					<input value="<s:property value="hour" />" readonly="readonly" id="hour" name="hour" class="" size="2" />:<input readonly="readonly" value="<s:property value="minutes" />" id="minutes" name="minutes" size="2" />
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;">role</span>
				</td>
				<td>
					<input value="<s:property value="role" />" readonly="readonly" id="role" name="role" style="display:none;" />
					<input value="
						<s:if test="role==0">
							<s:property value="tr.tr_html(40)"/>
						</s:if>
						<s:else>
							<s:property value="tr.tr_html(39)"/>
						</s:else>
					" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(13)"/></span>
				</td>
				<td>
					<input readonly="readonly" value="<s:property value="nbPassagerPost" />" readonly="readonly" id="nbPassagerPost" name="nbPassagerPost" class="" size="2" />
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;">description</span>
				</td>
				<td>
					<input readonly="readonly" id="description" name="description" style="width:350px; height:100px;"  value="<s:property value="description"/>">
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(15)"/></span>
				</td>
				<td>
					<input readonly="readonly" value="<s:property value="addressStartPost" />" id="addressStartPost" name="addressStartPost" size="20" />
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(16)"/></span>
				</td>
				<td>
					<input readonly="readonly" value="<s:property value="addressStopPost" />" id="addressStopPost" name="addressStopPost" size="20" />
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(32)"/></span>
				</td>
				<td>
					<input value="<s:property value="villeStartPost" />" id="villeStartPost" name="villeStartPost" class="" size="20"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 1</span>
				</td>
				<td>
					<input id="villepassage1Post" name="villepassage1Post" class="" size="20"/>
					<input id="priceTrip1" name="priceTrip1" size="3" onchange="calculPrice('priceTrip1','priceTrip2','priceTrip3','priceTrip4','priceTrip5','priceTrip6','priceTrip7','priceTrip8','priceTotal','priceTripStop');">
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 2</span>
				</td>
				<td>
					<input id="villepassage2Post" name="villepassage2Post" class="" size="20"/>
					<input id="priceTrip2" name="priceTrip2" size="3" disabled="disabled" onchange="calculPrice('priceTrip1','priceTrip2','priceTrip3','priceTrip4','priceTrip5','priceTrip6','priceTrip7','priceTrip8','priceTotal','priceTripStop');">
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 3</span>
				</td>
				<td>
					<input id="villepassage3Post" name="villepassage3Post" class="" size="20"/>
					<input id="priceTrip3" name="priceTrip3" size="3" disabled="disabled" onchange="calculPrice('priceTrip1','priceTrip2','priceTrip3','priceTrip4','priceTrip5','priceTrip6','priceTrip7','priceTrip8','priceTotal','priceTripStop');">
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 4</span>
				</td>
				<td>
					<input id="villepassage4Post" name="villepassage4Post" class="" size="20"/>
					<input id="priceTrip4" name="priceTrip4" size="3" disabled="disabled" onchange="calculPrice('priceTrip1','priceTrip2','priceTrip3','priceTrip4','priceTrip5','priceTrip6','priceTrip7','priceTrip8','priceTotal','priceTripStop');">
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 5</span>
				</td>
				<td>
					<input id="villepassage5Post" name="villepassage5Post" class="" size="20"/>
					<input id="priceTrip5" name="priceTrip5" size="3" disabled="disabled" onchange="calculPrice('priceTrip1','priceTrip2','priceTrip3','priceTrip4','priceTrip5','priceTrip6','priceTrip7','priceTrip8','priceTotal','priceTripStop');">
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 6</span>
				</td>
				<td>
					<input id="villepassage6Post" name="villepassage6Post" class="" size="20"/>
					<input id="priceTrip6" name="priceTrip6" size="3" disabled="disabled" onchange="calculPrice('priceTrip1','priceTrip2','priceTrip3','priceTrip4','priceTrip5','priceTrip6','priceTrip7','priceTrip8','priceTotal','priceTripStop');">
				<td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 7</span>
				</td>
				<td>
					<input id="villepassage7Post" name="villepassage7Post" class="" size="20"/>
					<input id="priceTrip7" name="priceTrip7" size="3" disabled="disabled" onchange="calculPrice('priceTrip1','priceTrip2','priceTrip3','priceTrip4','priceTrip5','priceTrip6','priceTrip7','priceTrip8','priceTotal','priceTripStop');">
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 8</span>
				</td>
				<td>
					<input id="villepassage8Post" name="villepassage8Post" class="" size="20"/>
					<input id="priceTrip8" name="priceTrip8" size="3" disabled="disabled" onchange="calculPrice('priceTrip1','priceTrip2','priceTrip3','priceTrip4','priceTrip5','priceTrip6','priceTrip7','priceTrip8','priceTotal','priceTripStop');">
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(33)"/></span>
				</td>
				<td>
					<input value="<s:property value="villeStopPost" />"  id="villeStopPost" name="villeStopPost" class="" size="20"/>
					<input class="required" id="priceTripStop" name="priceTripStop" size="3" onchange="calculPrice('priceTrip1','priceTrip2','priceTrip3','priceTrip4','priceTrip5','priceTrip6','priceTrip7','priceTrip8','priceTotal','priceTripStop');">
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(48)"/></span>
				</td>
				<td align="right">
					<input id="priceTotal" name="priceTotal" size="3" disabled="disabled" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" class="Etape3Post" value="Etape 3" />
				</td>
			</tr>
		</table>
	</form>
<br />
<div id="postPrintMap"></div>
</div>