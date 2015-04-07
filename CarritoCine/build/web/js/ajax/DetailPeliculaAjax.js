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
                page: 'detPelicula'
            },
            success: function(dados){
                $('select[name=cmbCine] option').remove();
                $('select[name=cmbCine]').append(' <option value="0" disabled selected>Seleccione el cine</option>');
                $('select[name=cmbDia] option').remove();
                $('select[name=cmbDia]').append(' <option value="0" disabled selected>Seleccione el dia</option>');
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
        $('select[name=cmbDia] option').remove();
        $('select[name=cmbDia]').append(' <option value="0" disabled selected>Seleccione el dia</option>');
        $('select[name=cmbDia]').append('<option value = "1">Hoy</option>');
        $('select[name=cmbDia]').append('<option value = "2">Mañana</option>');
        $('select[name=cmbDia]').append('<option value = "3">Pasado</option>');
    });
    $('select[name=cmbDia]').on('change',function(){
        $.ajax({
            type: 'GET',
            url: 'FuncionAjaxServlet',
            data: {
                codigoCine: $('select[name=cmbCine]').val(), 
                page: 'detPelicula', 
                dia: $('select[name=cmbDia]').val(),
                codigoPelicula:  $('#codigoPelicula').val()
                },
            success: function(dados){
                $('#divFunciones').html(dados);
            }
        });  
    });
});
            

