<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="corner" align="center">
	<form method="post" id="post_form">
		<table>
			<tr>
				<td>
					<span style="width: 160px;">Date</span>
				</td>
				<td>
					<input value="<s:property value="datepickerPost" />" readonly="readonly" id="datepickerPost" name="datepickerPost" class="" size="20"/>
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
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 2</span>
				</td>
				<td>
					<input id="villepassage2Post" name="villepassage2Post" class="" size="20"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 3</span>
				</td>
				<td>
					<input id="villepassage3Post" name="villepassage3Post" class="" size="20"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 4</span>
				</td>
				<td>
					<input id="villepassage4Post" name="villepassage4Post" class="" size="20"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 5</span>
				</td>
				<td>
					<input id="villepassage5Post" name="villepassage5Post" class="" size="20"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 6</span>
				</td>
					<input id="villepassage6Post" name="villepassage6Post" class="" size="20"/>
				<td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 7</span>
				</td>
				<td>
					<input id="villepassage7Post" name="villepassage7Post" class="" size="20"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(34)"/> 8</span>
				</td>
				<td>
					<input id="villepassage8Post" name="villepassage8Post" class="" size="20"/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="width: 160px;"><s:property value="tr.tr_html(33)"/></span>
				</td>
				<td>
					<input value="<s:property value="villeStopPost" />"  id="villeStopPost" name="villeStopPost" class="" size="20"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" class="Etape3Post" value="Etape 3" />
				</td>
			</tr>
		</form>
	</table>
<br />
<div id="postPrintMap"></div>
</div>