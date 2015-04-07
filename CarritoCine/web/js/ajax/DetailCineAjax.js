/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
                
    $('#hoy').click(function(){
        $.ajax({
            type: 'GET',
            url: 'CineAjaxServlet',
            data:{
                dia:'hoy', 
                page: 'detCine', 
                codCine: $('#codCine').val()
                },
            success: function(dados){
                $('#divListaPeliculas').html(dados);
            }
        }); 
    });
    $('#man').click(function(){
        $.ajax({
            type: 'GET',
            url: 'CineAjaxServlet',
            data: {
                dia:'man', 
                page: 'detCine', 
                codCine: $('#codCine').val()
                },
            success: function(dados){
                $('#divListaPeliculas').html(dados);
            }
        }); 
    });
    $('#pas').click(function(){
        $.ajax({
            type: 'GET',
            url: 'CineAjaxServlet',
            data: {
                dia:'pas', 
                page: 'detCine', 
                codCine: $('#codCine').val()
                },
            success: function(dados){
                $('#divListaPeliculas').html(dados);
            }
        }); 
    });
});