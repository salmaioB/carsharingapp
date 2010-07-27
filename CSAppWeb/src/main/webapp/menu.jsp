<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

	<div id="container"> 
 		<ul> 
			<li><a href="#fragment-1"><span>Accueil</span></a></li> 
            <li><a href="#fragment-2"><span>Rechercher</span></a></li> 
         </ul> 
            <div id="fragment-1"> 
		       <h2>
		      		Accueil
		    	</h2>
            </div> 
            <div id="fragment-2"> 
               Rechercher
            </div> 
        </div> 
        
Message : <s:property value="message"/> 