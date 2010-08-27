<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="list1"> 
	<s:iterator value="listMessageSend" id="listMessageSend" >
	 	<h3>
	 		<a href="#" 
	 			<s:if test="%{#listMessageSend.message.isRead==0}"> 
					style="font-weight:bold;"
				</s:if>
	 			title="<s:property value="%{#listMessageSend.message.id}" />"
	 		>
	    		<s:property value="%{#listMessageSend.customerAccount.firstName}" />
		    	<s:property value="%{#listMessageSend.message.dateTimeWrited}" />
		    	<s:property value="%{#listMessageSend.message.title}" />
	 		</a>
	 	</h3>

		<div class="content" >
			<p><s:property value="%{#listMessageSend.message.content}" /></p>
		</div>
	</s:iterator>
</div>
	