/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



function validar()
{          
    if($( $('select[name=cmbPelicula]')).val()=="0"){
        alert("Seleccione una pelicula");
        $('select[name=cmbPelicula]').focus();
        return false;
    }               
    if($( $('select[name=cmbCine]')).val()=="0"){
        alert("Seleccione un Cine");
        $('select[name=cmbCine]').focus();
        return false;
    }
    if($( $('select[name=cmbSala]')).val()=="0"){
        alert("Seleccione una sala");
        $('select[name=cmbSala]').focus();
        return false;
    }
    if($( $('#time')).val()==""){
        alert("inserte una hora y fecha validos");
        $('#time').focus();
        return false;
    }                  
                         
                
}
            
function isText(event) {
    if (event) {
        var charCode = (event.which) ? event.which : event.keyCode;
        if (charCode > 47 && charCode < 58 )
            return false;
    }
    return true;
}
            
function eliminar(codigo)
{
    if (confirm("Desea eliminar el registro?"))
    {
        window.location="FuncionServlet?accion=eliminar&codigo="+codigo;
    }
}
        