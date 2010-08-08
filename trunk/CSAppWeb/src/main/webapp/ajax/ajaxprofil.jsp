<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<form method="post" id="checkaddress_form">
	<span style="width: 160px;">Login</span> <input name="customerLogin" class="" size="4"/><br />
	<span style="width: 160px;">Password</span><input name="customerPassword" type="password" size="4"/><br />
	<span style="width: 160px;">last name</span><input name="lastName"  size="4"/><br />
	<span style="width: 160px;">first name</span><input name="firstName" size="4"/><br />
	<span style="width: 160px;">email address</span><input name="emailAddress" size="4"/><br />
	<span style="width: 160px;">phone</span><input name="phone" size="4"/><br />
	<span style="width: 160px;">mobile</span><input name="mobile" size="4"/><br />
	<span style="width: 160px;">address</span><input name="address" size="4"/><br />
	<span style="width: 160px;">ville</span><input name="ville" size="4"/><br />
	<span style="width: 160px;">cp</span><input name="cp" size="4"/><br />
	<span style="width: 160px;">accept animals</span><input type="checkbox" name="acceptAnimals" size="4"/><br />
	<span style="width: 160px;">accept radio</span><input type="checkbox" name="acceptRadio" size="4"/><br />
	<span style="width: 160px;">accept smoker</span><input type="checkbox" name="acceptSmoker" size="4"/><br />
	<span style="width: 160px;">accept to discuss</span><input type="checkbox" name="acceptToDiscuss" size="4"/><br />
	<span style="width: 160px;">accept to make a detour</span><input type="checkbox" name="acceptToDiscuss" size="4"/><br />
	<input type="submit" class="checkin"/>		     
</form>
<form method="POST" id="checkAddressNext">
	<input type="submit" class="checkAddress" value="Valide la position de l'adresse"/>
</form>