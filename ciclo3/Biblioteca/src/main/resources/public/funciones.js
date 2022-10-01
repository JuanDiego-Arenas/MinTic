function listarLibros(){
    $.ajax({
        url: "http://localhost:8080/ListarLibros",
        type: "GET",
        datatype: "JSON",
        success:function(respuesta){
            console.log(respuesta);
            mostrarTabla(respuesta);
        }
    });
}

function mostrarTabla(filas){
    let miTabla = "<table>";
    for(i = 0; i < filas.length; i++){
        miTabla += "<tr>"
        miTabla += "<td>" + filas[i].isbn + "</td>";
        miTabla += "<td>" + filas[i].titulo + "</td>";
        miTabla += "<td>" + filas[i].autor + "</td>";
        miTabla += "<td>" + filas[i].editorial + "</td>";
        miTabla += "<td>" + filas[i].no_page + "</td>";
        miTabla+="<td><button onclick='cargarDatos("+filas[i].isbn+")'>Editar</button>"
        miTabla+="<td><button onclick='eliminarLibro("+filas[i].isbn+")'>Eliminar</button>"
        miTabla += "</tr>"
    }
    miTabla += "</table>";
    $('#tabla').empty();
    $("#tabla").append(miTabla);
}

function consultarLibro(){
    let codigo = $("#isbn").val();
    $.ajax({
        url: "http://localhost:8080/BuscarLibro/"+codigo,
        type: "GET",
        datatype: "JSON",
        success:function(respuesta){
            console.log(respuesta);
            $('#tabla').empty();
            texto=respuesta.isbn+" -- "+respuesta.titulo+" -- "+respuesta.autor + "\n";
            $('#tabla').empty();
            $('#libro').append(texto);
        }
    });
}

function buscarAutor(){
    let autor=$("#busautor").val();
    $.ajax({
        url:"http://localhost:8080/BuscarAutor/" + autor,
        type: "GET",
        datatype: "JSON",
        success:function(respuesta){
            console.log(respuesta);
            mostrarTabla(respuesta);
        }
    });
}

function guardarLibro(){
    let datos =
    {
        isbn:$('#isbn_insert').val(),
        titulo:$('#titulo').val(),
        autor:$('#autor').val(),
        editorial:$('#editorial').val(),
        no_page:parseInt($('#paginas').val())
    }

    let datosEnvio = JSON.stringify(datos);
    $.ajax({
        url:"http://localhost:8080/InsertarLibro",
        type: "POST",
        data: datosEnvio,
        contentType:"application/JSON",
        datatype: "JSON",
        success:function(respuesta){
            alert(respuesta)
        }
    });

}