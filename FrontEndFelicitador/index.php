<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head> 
        <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <meta charset="UTF-8">
        <title>Felicitador</title>
    </head>
    <body>
    <center>
        <?php
           echo "Bienvenido al Felicitador </br>";//use PHP solo para poder ejecutar el Jquery
           echo "Ingrese los siguientes datos de la persona para ver si esta de cumpleaños";
        ?>
        </br>
        </br>
        </br>
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <table class="table table-borderers">
                    <tr>
                        <td>
                            Primer nombre:
                        </td>
                        <td>
                            <input type="text" class="form-control" id="txtNombre1" maxlength="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Segundo nombre:
                        </td>
                        <td>
                            <input type="text" class="form-control"  id="txtNombre2" maxlength="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Apellido paterno:
                        </td>
                        <td>
                            <input type="text" class="form-control"  id="txtApellido1" maxlength="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Apellido materno:
                        </td>
                        <td>
                            <input type="text" class="form-control"  id="txtApellido2" maxlength="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha Nacimiento:
                        </td>
                        <td>
                            <input type="date" class="form-control"  id="txtFechaNac"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <center>
                                <intup type="submit" id="btnVer" class="btn btn-success">Ver</intup>
                                <intup type="button" id="btnLimpiar" class="btn btn-warning">Limpiar</intup>
                            </center>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div id="tablaPersonasId"></div>
    </center>
        <script>
            var listaPersonas = [];//Lista donde guardaré todas las consultas.
            $(document).ready(function(){
                $("#tablaPersonas").hide();//Escondo la tabla personas en un principio
                $("#btnVer").click(function(){
                    var nombre1 = $("#txtNombre1").val();
                    var nombre2 = $("#txtNombre2").val();
                    var apellido1 = $("#txtApellido1").val();
                    var apellido2 = $("#txtApellido2").val();
                    var fecha = $("#txtFechaNac").val();
                    //un pequeño validador
                    if (nombre1 == "" || nombre2 == "" || apellido1 == "" || apellido2 == "" || fecha == "") {
                        alert("Error, no puede ingresar datos vacios");
                        return;
                    }
                    $.ajax({
                        method: "GET",
                        header: 'content-type: application/json; charset=utf-8',
                        url: "http://localhost:8080/FelicitadorDeCumpleanos/app/Felicitador",//Si el proyecto esta en otro equipo, deben cambiar el Localhost por la IP del equipo
                        data:{
                            nombre1,
                            nombre2,
                            apellido1,
                            apellido2,
                            fecha
                        },
                        success: function(respuesta) {
                                alert(respuesta.mensajeCumpleaños);
                                listaPersonas.push(respuesta);
                                RecargaTablaPersonas();
                        },
                        error: function() {
                            alert("No se ha podido obtener la información, verifique sus datos");
                        }
                    });
                });
                function RecargaTablaPersonas(){
                    //En principio iba a usar Datatables, pero opte por lo mas rapido y simple
                    var tabla ='<h1>Lista Personas Consultadas</h1>'+
                                '<table class="table table-striped" style="height:100%;">';
                    $.each( listaPersonas, function( key, item ) {
                        tabla +='<tr>' +
                                    '<td colspan="2">' +
                                    '</td>' +
                                '</tr>' +'<tr>' +
                                    '<td>' +
                                        '   Nombre:' +
                                    '</td>' +
                                    '<td>' +
                                        item.nombre1 + 
                                    '</td>' +
                                '</tr>' +
                                '<tr>' +
                                    '<td>' +
                                        '   Apellido:' +
                                    '</td>' +
                                    '<td>' +
                                        item.apellido1 +
                                    '</td>' +
                                '</tr>' +
                                '<tr>' +
                                    '<td>' +
                                        '   Edad:' +
                                    '</td>' +
                                    '<td>' +
                                        item.edad +
                                    '</td>' +
                                '</tr>' +
                                '<tr>' +
                                    '<td>' +
                                        '   Fecha Nacimiento:' +
                                    '</td>' +
                                    '<td>' +
                                        item.fecha +
                                    '</td>' +
                                '</tr>' +
                                '<tr>' +
                                    '<td>' +
                                        '   Mensaje:' +
                                    '</td>' +
                                    '<td>' +
                                        '<p>' + item.mensajeCumpleaños + '</p>'
                                    '</td>' +
                                '</tr>';
                        });
                            
                        tabla+='</table>';
                        
                    $("#tablaPersonasId").html(tabla);
                    
                };
            });
        </script>
    </body>
</html>
