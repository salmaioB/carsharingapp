$(document).ready(function()
{
	$('input.toto').click(function()
	{
		alert('Handler for .click() called.');
		
		var postData = $("input", '#login_form').serialize();
		alert(postData);
		
		$.ajax({
			    method: 'post',
	    		url: 'http://localhost:8080/CSAppWeb/LoginActionAjax',
	    		data: postData,
	    		success: function(data)
	    		{
        	 	 $('#divToUpdate').html(data);
	    		}
	  	  	  });
		
		return false;
	});
});

