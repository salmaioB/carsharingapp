function calculPrice(price1,price2,price3,price4,price5,price6,price7,price8,priceTotal,cityStop)
		{
			var price = 0;

			if($("#"+price1).val() != "") { $("#"+price2).attr("disabled", false); price += parseFloat($("#"+price1).val()); }
			if($("#"+price2).val() != "") { $("#"+price3).attr("disabled", false); price += parseFloat($("#"+price2).val()); }
			if($("#"+price3).val() != ""){ $("#"+price4).attr("disabled", false); price += parseFloat($("#"+price3).val()); }
			if($("#"+price4).val() != ""){ $("#"+price5).attr("disabled", false); price += parseFloat($("#"+price4).val()); }
			if($("#"+price5).val() != ""){ $("#"+price6).attr("disabled", false); price += parseFloat($("#"+price5).val());}
			if($("#"+price6).val() != ""){ $("#"+price7).attr("disabled", false); price += parseFloat($("#"+price6).val());}
			if($("#"+price7).val() != ""){ $("#"+price8).attr("disabled", false); price += parseFloat($("#"+price7).val());}
			if($("#"+price8).val() != ""){ price += parseFloat($("#"+price8).val()); }
			if($("#"+cityStop).val() != ""){ price += parseFloat($("#"+cityStop).val()); }
				
			$("#"+priceTotal).val( price );
		}