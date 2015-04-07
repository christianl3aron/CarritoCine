/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
                
    $('select[name=cmbCiudad]').on('change',function(){
        $.ajax({
            type: 'GET',
            url: 'CineAjaxServlet',
            data: {
                codigoCiudad: $('select[name=cmbCiudad]').val(), 
                page: 'index'
            },
            success: function(dados){
                $('select[name=cmbCine] option').remove();
                $('select[name=cmbCine]').append(' <option value="" disabled selected>Seleccione el cine</option>');
                var pegadados=dados.split(":");
                for(var i=0;i<pegadados.length-1;i++){
                    var codigosala=pegadados[i].split("-")[0];
                    var nombresala=pegadados[i].split("-")[1];
                    $('select[name=cmbCine]').append('<option value = "'+codigosala+'">'+nombresala+'</option>');
                }
            }
        });  
    });
    $('select[name=cmbCine]').on('change',function(){
        $.ajax({
            type: 'GET',
            url: 'PeliculaAjaxServlet',
            data: {
                codigoCine: $('select[name=cmbCine]').val(), 
                pagina: 'index'
            },
            success: function(dados){
                $('select[name=cmbPelicula] option').remove();
                $('select[name=cmbPelicula]').append(' <option value="" disabled selected>Seleccione el cine</option>');
                var pegadados=dados.split(":");
                for(var i=0;i<pegadados.length-1;i++){
                    var codigosala=pegadados[i].split("-")[0];
                    var nombresala=pegadados[i].split("-")[1];
                    $('select[name=cmbPelicula]').append('<option value = "'+codigosala+'">'+nombresala+'</option>');
                }
            }
        });  
    })
    $('select[name=cmbPelicula]').on('change',function(){
        $('#btnAceptar').attr('href','DetailServlet?codigo='+$('select[name=cmbPelicula]').val()+'&obj=pelicula');
    })
});

