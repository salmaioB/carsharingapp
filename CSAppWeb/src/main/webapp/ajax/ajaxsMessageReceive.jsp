<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
int i=0;
%>
<div class="demo">
	<div>Liste message reception</div>
		<div id="list2" >
			<s:iterator value="listMessageReceive" id="listMessageReceive" >
			<%i++; %>
			<div id="item2<%=i%>" title="<s:property value="%{#listMessageReceive.message.id}" />"
				<s:if test="%{#listMessageReceive.message.isRead==0}"> 
				style="font-weight:bold;"
				</s:if>
			>
				<div class="title" >
	    			<s:property value="%{#listMessageReceive.customerAccount.firstName}" />
		    		<s:property value="%{#listMessageReceive.message.dateTimeWrited}" />
		    		<s:property value="%{#listMessageReceive.message.title}" />
				</div>
				<div class="content" >
					<s:property value="%{#listMessageReceive.message.content}" /><br />
					<form id="form_sendResponse<s:property value="%{#listMessageReceive.message.id}" />">
						<input id="idMessage" name="idMessage" style="display:none;" type="text" value="<s:property value="%{#listMessageReceive.message.id}" />" />
						<textarea name="content" id="content" style="width:90%; height:100px;"></textarea>
						<input type="button" value="envoyer" class="sendResponse" onclick="ajaxSendResponse(<s:property value="%{#listMessageReceive.message.id}" />)"/>
					</form>
				</div>
			</div>
	 	</s:iterator>
	 </div>
 </div>