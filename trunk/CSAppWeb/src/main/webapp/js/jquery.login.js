$(document).ready(function()
{
	//Ajout des évenements ajax
        $('input.check').click(function()
        {
                var postData = $("input", '#login_form').serialize();
                
                $.ajax({
                        method: 'post',
                        url: 'http://localhost:8888/CSAppWeb/LoginActionAjax',
                        data: postData,
                        success: function(data)
                        {
                         $('#divToLogin').html(data);
                         $('#containerLeft').html("");
                        }
                          });
                
                return false;
        });
        $('input.chekin').click(function()
                {
                        var postData = $("input", '#checkin_form').serialize();
                        
                        $.ajax({
                                method: 'post',
                                url: 'http://localhost:8888/CSAppWeb/CheckInAjax',
                                data: postData,
                                success: function(data)
                                {
                                 $('#divToLogin').html(data);
                                }
                                  });
                        
                        return false;
                });
        $('input.checkout').click(function()
                {
                        var postData = $("input", '#checkout_form').serialize();
                        
                        $.ajax({
                                method: 'post',
                                url: 'http://localhost:8888/CSAppWeb/CheckOutAjax',
                                data: postData,
                                success: function(data)
                                {
                                 $('#divToLogin').html(data);
                                }
                                  });
                        
                        return false;
                });
        $('input.checkAddress').click(function()
                {
                        var postData = $("input", '#checkaddress_form').serialize();
                        
                        $.ajax({
                                method: 'post',
                                url: 'http://localhost:8888/CSAppWeb/CheckAddress',
                                data: postData,
                                success: function(data)
                                {
                                 $('#profil').html(data);
                                 
                                 initialize();
                                }
                                  });
                        
                        return false;
                });
        $('input.Cpost').click(function()
                {
                        var postData = $("input", '#post_form').serialize();
                        
                        $.ajax({
                                method: 'post',
                                url: 'http://localhost:8888/CSAppWeb/PrintMapPost',
                                data: postData,
                                success: function(data)
                                {
                                 $('#post').html(data);
                                 
                                 initialize();
                                }
                                  });
                        
                        return false;
                });
        $('input.Csearch').click(function()
                {
                        var postData = $("input", '#search_form').serialize();
                        
                        $.ajax({
                                method: 'post',
                                url: 'http://localhost:8888/CSAppWeb/PrintMapSearch',
                                data: postData,
                                success: function(data)
                                {
	                                 $('#search').html(data);
	                                 
	                                 initializeMapParcours();
                                }
                                  });
                        
                        return false;
                });
})