<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="etape1">
	<div class="corner">
		Etape 1
	</div>
	<br />
	<div class="corner" align="center">
		<form method="post" id="post_form">
			<table>
				<tr>
					<td>
						<s:property value="tr.tr_html(17)"/>
					</td>
					<td>
						<span style="width:100px;"><s:property value="tr.tr_html(39)"/></span><input type="radio" id="role" name="role" value="1"><br />
						<span style="width:100px;"><s:property value="tr.tr_html(40)"/></span><input type="radio" id="role" name="role" value="2"> 
					</td>
				</tr>
				<tr>
					<td>
						<span style="width: 160px;">Date</span>
					</td>
					<td>
						<input readonly="readonly" type="text" name="datepickerPost" id="datepickerPost" />
					</td>
				</tr>
				<tr style="height:120px;">
					<td>
						<s:property value="tr.tr_html(10)"/>
					</td>
					<td>
						<input name="hours" id="hours" type="text" value="08:30" />
					</td>
				</tr>
				<tr>
					<td>
						<span style="width: 160px;"><s:property value="tr.tr_html(15)"/> </span> 
						<br /> <s:property value="tr.tr_html(12)"/> : <input id="addressStartPost" name="addressStartPost" class="" size="20" />
						<br /> <s:property value="tr.tr_html(11)"/> : <input id="villeStartPost" name="villeStartPost" class="" size="20" />
						<br /> <input type="button" class="PostSearchStart" value="<s:property value="tr.tr_html(14)"/>" onclick="initinitializePositionByAdress('villeStartPost','addressStartPost','divMapStart');"/>
					</td>
					<td>
						<div id="divMapStart" style="width: 300px; height: 200px"></div>
					</td>
				</tr>
				<tr>
					<td>
						<span style="width: 160px;"><s:property value="tr.tr_html(16)"/> </span>
						<br /> <s:property value="tr.tr_html(12)"/> : <input id="addressStopPost" name="addressStopPost" size="20"/>
						<br /> <s:property value="tr.tr_html(11)"/> : <input id="villeStopPost" name="villeStopPost" class="" size="20" />
						<br /> <input type="button" class="PostSearchStop" value="<s:property value="tr.tr_html(14)"/>" onclick="initinitializePositionByAdress('villeStopPost','addressStopPost','divMapStop');"/>
					</td>
					<td>
						<div id="divMapStop" style="width: 300px; height: 200px"></div>
					</td>
				</tr>
				<tr>
					<td>
						<span style="width: 160px;"><s:property value="tr.tr_html(13)"/></span>
					</td>
					<td>
						<input id="nbPassagerPost" name="nbPassagerPost" size="4" />
					</td>
				</tr>
				<tr>
					<td>
						<span style="width: 160px;">description</span>
					</td>
					<td>
						<textarea id="description" name="description" tyle="width:350px; height:100px;"  ></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" class="Etape2Post" value="Etape 2"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>