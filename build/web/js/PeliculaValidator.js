/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



function validar()
{               
    if($('#txtTitulo').val()==""){
        alert("Ingrese el titulo de la pelicula");
        $('#txtTitulo').focus();
        return false;
    }
    if($('#txtDuracion').val()==0){
        alert("duracion zero vacio");
        $('#txtTitulo').focus();
        return false;
    }
    if($('#txtActores').val()==""){
        alert("Ingrese los nombres de los actores");
        $('#txtTitulo').focus();
        return false;
    }
    if($('#txtSinopsis').val()==""){
        alert("Ingrese la sinopsis");
        $('#txtTitulo').focus();
        return false;
    }
    if($('#txtPais').val()==""){
        alert("Ingrese el país de origen");
        $('#txtTitulo').focus();
        return false;
    }
    if($('#txtDirector').val()==""){
        alert("Ingrese el nombre del director");
        $('#txtDirector').focus();
        return false;
    }
    if($('#txtTrailer').val()==""){
        alert("Ingrese el enlace del video");
        $('#txtTrailer').focus();
        return false;
    }
    if($('#txtImagen1').val()==""){
        alert("Ingrese Imgagen1");
        $('#txtImagen1').focus();
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
            