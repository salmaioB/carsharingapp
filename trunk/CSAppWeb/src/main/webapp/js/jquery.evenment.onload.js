$(document).ready(function()
{
      $('input.checkAddress').click(function()
                {
                        var postData = $("input", '#checkaddress_form').serialize();
                        
                        $.ajax({
                                method: 'post',
                                url: WEB_ROOT_URL+'CSAppWeb/CheckAddress',
                                data: postData,
                                success: function(data)
                                {
                                 $('#divProfilMapAnddroid').html(data);
                                 initinitializePositionByAdress("ville","address","divProfilMapAnddroid");
                                }
                                  });
                        
                        return false;
                });
        $('input.testAddress').click(function()
                {
                        var postData = $("input", '#checkaddress_form').serialize();
                        
                        $.ajax({
                                method: 'post',
                                url: WEB_ROOT_URL+'CSAppWeb/PrintPositionAndroid',
                                data: postData,
                                success: function(data)
                                {
		                            $('#divProfilMapAnddroid').html(data);
		                            
		                            initializePosition();
                                }
                                  });
                        
                        return false;
                });
       
})