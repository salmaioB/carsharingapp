<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<tiles:insertAttribute name="head" />

	<table style="width:100%; height:500px;">
		<tr style="height:15%;">
			<td colspan="2" style="width:100%; border-width:1px; border-style:solid; ">
				<tiles:insertAttribute name="header" />
			</td>
		</tr>
		<tr style="height:75%;">
			<td style="width:20%; border-width:1px; border-style:solid; ">
				<tiles:insertAttribute name="left" />
			</td>
			<td style="width:80%;border-width:1px; border-style:solid; ">
				<table style="width:100%; height:100%;">
					<tr style="height:20%;">
						<td style="width:20%; border-width:1px; border-style:solid; ">
							<tiles:insertAttribute name="menu" />
						</td>
					</tr>
					<tr style="height:80%;">
						<td style="width:20%; border-width:1px; border-style:solid; ">
							<tiles:insertAttribute name="body" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr style="height:10%;">
			<td colspan="2" style="width:50%; border-width:1px; border-style:solid; ">
				<tiles:insertAttribute name="footer" />
			</td>
		</tr>
	</table>

</html>
<!--

<html>
<head>
	<script type="text/javascript" src="js/jquery-1.4.1.min.js"></script>
	<script type="text/javascript" src="js/jtabs/jquery.tabs.js"></script>
	<script type="text/javascript" src="js/jtabs/jquery.history_remote.pack.js"></script>
		
	<link type="text/css" href="css/jquery.tabs.css" rel="stylesheet" />
	<link type="text/css" href="css/jquery.tabs.css" rel="stylesheet" />
	
	<script type="text/javascript"> 
		$(document).ready( function () { 
			$('#container').tabs({ fxFade: true, fxSpeed: 'normal' });
		} ) ;  
	</script> 
</head>
<body>
	<div id="container"> 
 		<ul> 
			<li><a href="#fragment-1"><span>Accueil</span></a></li> 
            <li><a href="#fragment-2"><span>Inscription</span></a></li> 
            <li><a href="#fragment-3"><span>Rechercher</span></a></li> 
         </ul> 
            <div id="fragment-1"> 
		       <h2>
		      <s:property value="message"/> -
		      <s:textfield name="testMessage" /> -
		    	</h2>
            </div> 
            <div id="fragment-2"> 
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
            </div> 
            <div id="fragment-3"> 
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
            </div> 
        </div> 
  </body>
</html>
-->