<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
int i=0;
%>
<div class="demo">
	<div>Liste message envoye</div>
		<div id="list1" >
			<s:iterator value="listMessageSend" id="listMessageSend" >
			<%i++; %>
			<div id="item1<%=i%>" title="<s:property value="%{#listMessageSend.message.id}" />"
				<s:if test="%{#listMessageSend.message.isRead==0}"> 
				style="font-weight:bold;"
				</s:if>
			>
				<div class="title" >
	    			<s:property value="%{#listMessageSend.customerAccount.firstName}" />
		    		<s:property value="%{#listMessageSend.message.dateTimeWrited}" />
		    		<s:property value="%{#listMessageSend.message.title}" />
				</div>
				<div class="content" >
					<s:property value="%{#listMessageSend.message.content}" /><br />
				</div>
			</div>
	 	</s:iterator>
	 </div>
 </div>