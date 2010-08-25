<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="cs.define.Define"%>

<head>
	<title>Car sharing</title>
	<script type="text/javascript">
		var WEB_ROOT_URL = "<%=Define.webRootUrl %>";
		var WEB_USE_LANGUAGE = "<s:property value="language"/>";
	</script>
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	
	<script type="text/javascript" src="js/jquery.ui/jquery.validate.js"></script>
		
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.widget.js"></script>
			
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.datepicker.js"></script>
	<script type="text/javascript" src="js/jquery.ui/jquery.ui.tabs.js"></script>
	<script type="text/javascript" src="js/jquery.ui/jquery-ui-personalized-1.6rc6.js"></script>

		
	<script type="text/javascript" src="js/jquery.corner.js"></script>
    <script type="text/javascript" src="js/jquery.evenment.js"></script>
    
    <script type="text/javascript" src="js/googleMapAddressByPosition.js"></script>	
    <script type="text/javascript" src="js/googlemap.js"></script>
    
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=<s:property value="language"/>"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.time/jquery.ui.all.js"></script>
	<script type="text/javascript" src="js/jquery.time/jquery.utils.js"></script>
	<script type="text/javascript" src="js/jquery.time/jquery.strings.js"></script>
	<script type="text/javascript" src="js/jquery.time/jquery.anchorHandler.js"></script>
	<script type="text/javascript" src="js/jquery.time/ui.timepickr.js"></script>

	<!--
	<link type="text/css" href="css/jquery.tabs.css" rel="stylesheet" >
	-->
	<link type="text/css" href="css/themes/base/jquery.ui.all.css" rel="stylesheet" >
	<link type="text/css" href="css/css.css" rel="stylesheet" >
	<link type="text/css" href="css/ui.timepickr.css" rel="stylesheet" >
	<link type="text/css" href="css/accordion.css" rel="stylesheet">
	
	<style type="text/css">
		.body{
			min-height:300px;
		}
		.left{
			height:100%;
		}
		.corner {
			background-color:#AAAAAA;
		}
	</style>
	<script type="text/javascript">
		var mapPostInitialize = false;
		var mapProfilInitialize = false;
		$(document).ready( function () { 
			$('#container').tabs({
		        select: function(e, ui) {
					// onglet post == ui.index == 1
			        if ( mapPostInitialize == false && ui.index == 1)
			        {
			        	mapPostInitialize=true;
						initializeMapEmpty('divMapStart');
						initializeMapEmpty('divMapStop');
			        }
					// onglet post == ui.index == 3
			        if ( mapProfilInitialize == false && ui.index == 2)
			        {
			        	mapProfilInitialize = true;
						//Initialisation de la carte du profil
						initializeMapEmpty('divMapProfil');
			        }
					// onglet post == ui.index == 3
			        if ( ui.index == 3)
			        {
				        //Requete ajax pour récuperer les messages boite de reception
			        	$.ajax({
			                method: 'post',
			                url: WEB_ROOT_URL+'CSAppWeb/MessageReceive',
			                success: function(data)
			                {
				                 $('#receive').html(data);
	
								//Execution des accordions
				 				$.accordian('#list2 > div', '#item21', {
									titles:'.title',
									contents:'.content',
									showSpeed:150,
									hideSpeed:250
								});
			                }
			        	});

					    //Requete ajax pour récuperer les messages boite de reception
				        $.ajax({
				                method: 'post',
				                url: WEB_ROOT_URL+'CSAppWeb/MessageSend',
				                success: function(data)
				                {
				                 	$('#send').html(data);

									//Execution des accordions
					 				$.accordian('#list1 > div', '#item11', {
										titles:'.title',
										contents:'.content',
										showSpeed:150,
										hideSpeed:250
									});	    				
			                	}
			                  });
			        }
		            return true;
	       		}
					
			});
		} ) ; 
		
		$(document).ready( function () { 
			$('#containerLeft').tabs({ fxFade: true, fxSpeed: 'normal' });
		} ) ;
		
		$(document).ready( function () {
			$('#menuMessages').tabs({ fxFade: true, fxSpeed: 'normal' });
			$('#menuTrip').tabs({ fxFade: true, fxSpeed: 'normal' });
			//$(".corner").corner();
		} ) ;
	</script>
	<script type="text/javascript">
		//calendrier
		$(function() {
			$("#datepickerPost").datepicker({	minDate: new Date(),
											showOn: 'button',
											buttonImage: WEB_ROOT_URL +'CSAppWeb/img/calendar.gif',
											buttonImageOnly: true
			});
			$("#datepickerSearch").datepicker({	minDate: new Date(),
											showOn: 'button',
											buttonImage: WEB_ROOT_URL +'CSAppWeb/img/calendar.gif',
											buttonImageOnly: true
			});
		});
	
	    $(function(){
	      $('#hours').timepickr();
	    });
	</script>
	
		<script type="text/javascript">

			$.accordian = function(items, first, options) {

				var active = first;
				var running = 0;

				var titles = options && options.titles || '.title';
				var contents = options && options.contents || '.content';
				var onClick = options && options.onClick || function(){ updateReadMessage( $(this).attr('title') ); $(this).attr('style',''); };
				var onShow = options && options.onShow || function(){};
				var onHide = options && options.onHide || function(){};
				var showSpeed = options && options.showSpeed || 'slow';
				var hideSpeed = options && options.hideSpeed || 'fast';

				$(items).not(active).children(contents).hide();
				$(items).not(active).each(onHide);
				//$(active).each(onShow);

				//$(active).each(onShow);
				$(active).children(contents).hide();
				//$(items).children(contents).hide();
				//$(items).each(onHide);
				
				$(items).children(titles).click(function(e){
					
					var p = $(contents, this.parentNode);
					$(this.parentNode).each(onClick);

					//if (running || !p.is(":hidden")) return false;
					running = 2;

					$(active).children(contents).not(':hidden').slideUp(hideSpeed, function(){--running;});
					p.slideDown(showSpeed, function(){--running;});

					$(active).each(onHide);
					active = '#' + $(this.parentNode)[0].id;
					$(active).each(onShow);

					return false;
				});

			};

			function simpleLog(message) {
				$('<div>' + message + '</div>').appendTo('#log');
			}

			$(function(){

				$.accordian('#list1 > div', '#item11');

				$.accordian('#list2 > div', '#item22', {
					titles:'.mytitle',
					contents:'.mycontent',
					onClick:function(){ simpleLog(this.id + ' clicked')},
					onShow:function(){simpleLog(this.id + ' shown'); $(this).removeClass('off').addClass('on');},
					onHide:function(){simpleLog(this.id + ' hidden'); $(this).removeClass('on').addClass('off');},
					showSpeed:250,
					hideSpeed:550
				});

			});

		</script>
		<script type="text/javascript">
			function calculPrice(price1,price2,price3,price4,price5,price6,price7,price8,priceTotal,cityStop)
			{
				var price = 0;
				//alert($("#"+price1).val());
				if($("#"+price1).val() != "") {
					$("#"+price2).attr("disabled", false);
					price += parseFloat($("#"+price1).val());
				}

				if($("#"+price2).val() != "") {
					$("#"+price3).attr("disabled", false);
					price += parseFloat($("#"+price2).val());
				}
				
				if($("#"+price3).val() != ""){
					 $("#"+price4).attr("disabled", false);
					 price += parseFloat($("#"+price3).val());
				}
				
				if($("#"+price4).val() != ""){
					 $("#"+price5).attr("disabled", false);
					 price += parseFloat($("#"+price4).val());
				}
					 
				if($("#"+price5).val() != ""){
					 $("#"+price6).attr("disabled", false);
					 price += parseFloat($("#"+price5).val());
				}

				if($("#"+price6).val() != ""){
					 $("#"+price7).attr("disabled", false);
					 price += parseFloat($("#"+price6).val());
				}

				if($("#"+price7).val() != ""){
					 $("#"+price8).attr("disabled", false);
					 price += parseFloat($("#"+price7).val());
				}

				if($("#"+price8).val() != ""){
					 price += parseFloat($("#"+price8).val());
				}
				if($("#"+cityStop).val() != ""){
					 price += parseFloat($("#"+cityStop).val());
				}
				
				$("#"+priceTotal).val( price );
			}
		</script>
		
		<script type="text/javascript">
			//Exécution du controle des formulaires
			$(document).ready(function(){
				if($('#checkaddress_form') == null) alert('#checkaddress_form');
				$('#checkaddress_form').validate();
			});			
		</script>
</head> 