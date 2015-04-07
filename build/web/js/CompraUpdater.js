/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    $('#cantidad').on('change',function(){
        var total=$('#cantidad').val()*$('#hdPrecio').val();
        $('#lblTotal').text(total);
    });
});