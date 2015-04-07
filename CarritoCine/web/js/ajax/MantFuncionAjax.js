/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
                
    $('select[name=cmbCine]').on('change',function(){
        $.ajax({
            type: 'GET',
            url: 'SalaServlet',
            data: 'codigoCine='+$('select[name=cmbCine]').val(),
            success: function(dados){
                $('select[name=cmbSala] option').remove();
                $('select[name=cmbSala]').append('<option value="0" selected>Seleccione una sala</option>');
                var pegadados=dados.split(":");
                for(var i=0;i<pegadados.length-1;i++){
                    var codigosala=pegadados[i].split("-")[0];
                    var nombresala=pegadados[i].split("-")[1];
                    $('select[name=cmbSala]').append('<option value = "'+codigosala+'">'+nombresala+'</option>');
                }
            }
        });  
    })
                
    $('select[name=cmbPelicula]').on('change',function(){
        $.ajax({
            type: 'GET',
            url: 'PeliculaAjaxServlet',
            data: {
                codPelicula: $('select[name=cmbPelicula]').val(), 
                pagina: 'manFunDatos'
            },
            success: function(dados){
                $('#divDetailPelicula').html(dados);
            }
        });  
    })
                
    $('select[name=cmbSala]').on('change',function(){
        $.ajax({
            type: 'GET',
            url: 'FuncionAjaxServlet',
            data: {
                codSala: $('select[name=cmbSala]').val(), 
                page: 'manFunDatos'
            },
            success: function(dados){
                $('#divListaFunciones').html(dados);
            }
        });  
    })
});
            