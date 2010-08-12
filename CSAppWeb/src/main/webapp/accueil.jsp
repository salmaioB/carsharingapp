<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<tiles:insertAttribute name="head" />
	<body>
		<table style="width:100%;">
			<tr style="min-height:15%;">
				<td colspan="2" style="width:100%; border-width:0px; border-style:solid; ">
					<tiles:insertAttribute name="header" />
				</td>
			</tr>
			<tr style="min-height:75%;">
				<td style="width:20%; border-width:0px; border-style:solid; ">
					<tiles:insertAttribute name="left" />
				</td>
				<td  style="min-width:80%; border-width:0px; border-style:solid;">
					<div id="container" > 
					<!-- 
						<table style="width:100%; height:100%;">
							<tr style="height:20%;">
								<td style="width:20%; border-width:1px; border-style:solid; ">
								 -->
									<tiles:insertAttribute name="menu" />
								<!--
								</td>
							</tr>
							<tr style="height:80%;">
								<td style="width:20%; border-width:1px; border-style:solid; ">
									-->
									<tiles:insertAttribute name="body" />
									<!--
								</td>
							</tr>
						</table>
					-->
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" style=" border-width:0px; border-style:solid; ">
					<tiles:insertAttribute name="footer" />
				</td>
			</tr>
		</table>
	</body>
</html>