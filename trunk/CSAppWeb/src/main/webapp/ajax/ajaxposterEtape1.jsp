<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="etape1">
	<div class="corner">
		Etape 1
	</div>
	<br />
	<div class="corner" align="center" style="font-size: 0.9em;">
		<form method="post" id="post_form">
			<table>
				<tr>
					<td>
						<s:property value="tr.tr_html(17)"/>
					</td>
					<td>
						<table>
							<tr>
								<td>
									<span style="width:100px;"><s:property value="tr.tr_html(39)"/></span>
								</td>
								<td>
									<input class="required" type="radio" id="role" name="role" value="1">
								</td>
							</tr>
							<tr>
								<td>
									<span style="width:100px;"><s:property value="tr.tr_html(40)"/></span>
								</td>
								<td>
									<input class="required" type="radio" id="role" name="role" value="0"> 
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<span style="width: 160px;">Date</span>
					</td>
					<td>
						<input class="required" readonly="readonly" type="text" name="datepickerPost" id="datepickerPost" />
					</td>
				</tr>
				<tr style="height:120px;">
					<td>
						<s:property value="tr.tr_html(10)"/>
					</td>
					<td>
						<input  name="hours" id="hours" type="text" value="08:30" />
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td colspan="2">
									<span style="width: 160px;"><s:property value="tr.tr_html(15)"/> </span> 
								</td>
							</tr>
							<tr>
								<td>
									<s:property value="tr.tr_html(12)"/>
								</td>
								<td>
									<input id="addressStartPost" name="addressStartPost" class="" size="20" />
								</td>
							</tr>
							<tr>
								<td>
									<s:property value="tr.tr_html(11)"/>
								</td>
								<td>
									<input class="required" id="villeStartPost" name="villeStartPost" class="" size="20" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="button" class="PostSearchStart" value="<s:property value="tr.tr_html(14)"/>" onclick="initinitializePositionByAdress('villeStartPost','addressStartPost','divMapStart');"/>
								</td>
							</tr> 
						</table>
					</td>
					<td>
						<div id="divMapStart" style="width: 300px; height: 200px"></div>
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td colspan="2">
									<span style="width: 160px;"><s:property value="tr.tr_html(16)"/> </span> 
								</td>
							</tr>
							<tr>
								<td>
									<s:property value="tr.tr_html(12)"/>
								</td>
								<td>
									<input id="addressStopPost" name="addressStopPost" size="20"/>
								</td>
							</tr>
							<tr>
								<td>
									<s:property value="tr.tr_html(11)"/>
								</td>
								<td>
									<input class="required" id="villeStopPost" name="villeStopPost" class="" size="20" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="button" class="PostSearchStop" value="<s:property value="tr.tr_html(14)"/>" onclick="initinitializePositionByAdress('villeStopPost','addressStopPost','divMapStop');"/>
								</td>
							</tr> 
						</table>
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
						<input class="required" id="nbPassagerPost" name="nbPassagerPost" size="4" />
					</td>
				</tr>
				<tr>
					<td>
						<span style="width: 160px;">description</span>
					</td>
					<td>
						<input id="description" name="description" style="width:350px; height:100px;"  />
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