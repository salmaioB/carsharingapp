<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<form>
	<table>
		<th colspan="6">Liste message reception</th>
		
		<s:iterator value="listMessageReceive" id="listMessageReceive" >
	    	<tr  style="border: thin solid #6495ed;" >
	    		<td>
	    			<s:if test="%{#listMessageReceive.message.read==0}"><b></s:if>
	    			<s:property value="%{#listMessageReceive.customerAccount.firstName}" />
					<s:if test="%{#listMessageReceive.message.read==0}"></b></s:if>
	    		</td>
	    		<td>
	    			<s:if test="%{#listMessageReceive.message.read==0}"><b></s:if>
	    			<s:property value="%{#listMessageReceive.message.dateTime}" />
	    			<s:if test="%{#listMessageReceive.message.read==0}"></b></s:if>
	    		</td>
	    		<td>
	    			<s:if test="%{#listMessageReceive.message.read==0}"><b></s:if>
	    			<s:property value="%{#listMessageReceive.message.title}" />
	    			<s:if test="%{#listMessageReceive.message.read==0}"></b></s:if>
	    		</td>
	    		<td>
	    			<s:if test="%{#listMessageReceive.message.read==0}"><b></s:if>
	    			<input type="submit" value="Lire"/>
	    			<s:if test="%{#listMessageReceive.message.read==0}"></b></s:if>
	    		</td>
	    		<td style="visibility:hidden;">
	    			<input type="text"  value="<s:property value="%{#listMessageReceive.message.id}" />" />
	    		</td>
	    	    <td style="visibility:hidden;">
	    			<input type="text"  value="<s:property value="%{#listMessageReceive.message.idCustomerTransmitter}" />" />
	    		</td>
			</tr>
	 	</s:iterator>
	</table>
</form>