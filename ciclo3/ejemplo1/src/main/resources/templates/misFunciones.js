
function consultarProductos(){
    $.ajax({
    url:"https://g393ded18d1ab19-minticdatabase.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/prueba/productos",
    type:"GET",
    dataType:"JSON",
    success:function(respuesta){
        console.log(respuesta);
    }
    });
}