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
						Votre role
					</td>
					<td>
						<select name="address"  id="address" class="selectcl ui-widget select ui-corner-all">
	           			   <option value="">select</option>
	            			<option value="1">Conducteur</option>
	            			<option value="2">Passager</option>
	            		</select>
					</td>
				</tr>
				<tr>
					<td>
						<span style="width: 160px;">Depart</span> <input id="startPost" name="startPost" class="" size="20" />
						<input type="button" class="PostSearchStart" value="Depard" onclick="initinitializePositionByAdress('startPost','divMapStart');"/>
					</td>
					<td>
						<div id="divMapStart" style="width: 300px; height: 200px"></div>
					</td>
				</tr>
				<tr>
					<td>
						<span style="width: 160px;">Arrive</span><input id="stopPost" name="stopPost" size="20"/>
						<input type="button" class="PostSearchStop" value="Arrive" onclick="initinitializePositionByAdress('stopPost','divMapStop');"/>
					</td>
					<td>
						<div id="divMapStop" style="width: 300px; height: 200px"></div>
					</td>
				</tr>
				<tr>
					<td>
						<span style="width: 160px;">Nombre de passager</span>
					</td>
					<td>
						<input id="nbPassagerPost" name="nbPassagerPost" size="4" />
					</td>
				</tr>
				<tr>
					<td>
						<span style="width: 160px;">Date</span>
					</td>
					<td>
						<input readonly="readonly" type="text" id="datepickerPost" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" class="Etape2Post" value="Etape 2"/>
					</td>
				</tr>
			</table>
			<!-- <input type="submit" class="Cpost" value="Poster"/> -->
		</form>
	<br />
	<div id="postPrintMap"></div>
	</div>
</div>
<br />
<div id="etape2">
mm
</div>
<div id="etape3">
kk
</div>