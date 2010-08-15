<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="corner" align="center">
	<form method="post" id="post_form">
		<span style="width: 160px;">Date</span> <input value="<s:property value="datepickerPost" />" readonly="readonly" id="datepickerPost" name="datepickerPost" class="" size="20"/><br />
		<span style="width: 160px;">Heure</span> <input value="<s:property value="hour" />" readonly="readonly" id="hour" name="hour" class="" size="2" />:<input readonly="readonly" value="<s:property value="minutes" />" id="minutes" name="minutes" size="2" /><br />
		
		<span style="width: 160px;">Ville depart</span> <input value="<s:property value="villeStartPost" />" id="villeStartPost" name="villeStartPost" class="" size="20"/><br />
		<span style="width: 160px;">Ville passage 1</span> <input id="villepassage1Post" name="villepassage1Post" class="" size="20"/><br />
		<span style="width: 160px;">Ville passage 2</span> <input id="villepassage2Post" name="villepassage2Post" class="" size="20"/><br />
		<span style="width: 160px;">Ville passage 3</span> <input id="villepassage3Post" name="villepassage3Post" class="" size="20"/><br />
		<span style="width: 160px;">Ville passage 4</span> <input id="villepassage4Post" name="villepassage4Post" class="" size="20"/><br />
		<span style="width: 160px;">Ville passage 5</span> <input id="villepassage5Post" name="villepassage5Post" class="" size="20"/><br />
		<span style="width: 160px;">Ville passage 6</span> <input id="villepassage6Post" name="villepassage6Post" class="" size="20"/><br />
		<span style="width: 160px;">Ville passage 7</span> <input id="villepassage7Post" name="villepassage7Post" class="" size="20"/><br />
		<span style="width: 160px;">Ville passage 8</span> <input id="villepassage8Post" name="villepassage8Post" class="" size="20"/><br />
		<span style="width: 160px;">Ville arrive</span> <input value="<s:property value="villeStopPost" />"  id="villeStopPost" name="villeStopPost" class="" size="20"/><br />

		<input type="submit" class="Etape3Post" value="Etape 3" />	
	</form>
<br />
<div id="postPrintMap"></div>
</div>