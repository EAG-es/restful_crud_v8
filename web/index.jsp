<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Restful CRUD (Jardineria)</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            var entidad = null;
            var entidad_a_crear = null;
            var funcion_post = null;
            function enviar_ajax(url, metodo, usuario, clave, div_id, objeto_js, content_type, accept) {
                var xMLHttpRequest = new XMLHttpRequest();
                var data;
                xMLHttpRequest.open(metodo, url, true);
                if (typeof content_type === 'undefined') {
                    xMLHttpRequest.setRequestHeader("Content-Type", "application/json");
                } else if (content_type !== null ) {
                    xMLHttpRequest.setRequestHeader("Content-Type", content_type);
                }
                if (typeof accept === 'undefined') {
                    xMLHttpRequest.setRequestHeader("Accept", "application/json");                        
                } else if (accept !== null ) {
                    xMLHttpRequest.setRequestHeader("Accept", accept);
                }
                xMLHttpRequest.setRequestHeader("javax.persistence.jdbc.user", usuario);
                xMLHttpRequest.setRequestHeader("javax.persistence.jdbc.password", clave);
                xMLHttpRequest.onreadystatechange = function () {
                    if (xMLHttpRequest.readyState === 4) { 
                        if (xMLHttpRequest.status >= 200
                            && xMLHttpRequest.status < 300) {
                            entidad = JSON.parse(xMLHttpRequest.responseText);
                            document.getElementById(div_id).innerHTML
                                =  JSON.stringify(entidad);
                            if (funcion_post !== null) {
                                funcion_post(entidad);
                                funcion_post = null;
                            }
                        } else {
                          document.getElementById(div_id).innerHTML
                                =  "Error en la recepcion: <br>" 
                                + xMLHttpRequest.status
                                + " : <br>"
                                + xMLHttpRequest.responseText;
                        }
                    }
                };
                if (typeof objeto_js !== 'undefined') {
                    if (typeof objeto_js === 'object') {
                        data = JSON.stringify(objeto_js);
                    } else {
                        data = objeto_js;
                    }
                }
                xMLHttpRequest.send(data);
            }
        </script>                    
    </head>
    <body>
        <h1>Restful CRUD (Jardineria)</h1>
        <h2>Get</h2>
        <a id="a_get_cuenta" href="#a_get_cuenta" onclick="enviar_ajax('webresources/inser.restful.restful_crud.producto/count', 'GET', 'jardineria', '2021jardineria', 'id_get_cuenta', null, null, 'text/plain')">get cuenta</a><br>
        <div id="id_get_cuenta">Resultado cuenta</div>
        <a id="a_get_todos" href="#a_get_todos" href="#" onclick="enviar_ajax('webresources/inser.restful.restful_crud.producto', 'GET', 'jardineria', '2021jardineria', 'id_get_todos')">get todos</a><br>
        <div id="id_get_todos">Resultado get todos</div>
        <a id="a_get_rango" href="#a_get_rango" onclick="enviar_ajax('webresources/inser.restful.restful_crud.producto/0/14', 'GET', 'jardineria', '2021jardineria', 'id_get_rango')">get rango 0 a 14</a><br>
        <div id="id_get_rango">Resultado get rango</div>
        <a id="a_get_rango_ordenacion_ascendente" href="#a_get_rango_ordenacion_ascendente" onclick="enviar_ajax('webresources/inser.restful.restful_crud.producto/0/14/nombre/asc', 'GET', 'jardineria', '2021jardineria', 'id_get_rango_ordenacion_ascendente')">get rango 0 a 14 ordenacion por nombre ascendente</a><br>
        <div id="id_get_rango_ordenacion_ascendente">Resultado get rango ordenacion ascendente</div>
        <a id="a_get" href="#a_get" 
           onclick="
                funcion_post = function(entidad) {
                    entidad_a_crear = entidad;
                    document.getElementById('id_entidad_a_crear').innerHTML
                        =JSON.stringify(entidad_a_crear);
                };
                enviar_ajax('webresources/inser.restful.restful_crud.producto/22225', 'GET', 'jardineria', '2021jardineria', 'id_get');
                ">get_recurso(22225)</a><br>
        <div id="id_get">Resultado get</div>
        <h2>Delete</h2>
        <a id="a_delete" href="#a_delete" onclick="enviar_ajax('webresources/inser.restful.restful_crud.producto/22225', 'DELETE', 'jardineria', '2021jardineria', 'id_delete')">delete </a><span id="id_entidad_a_crear"></span><br>
        <div id="id_delete">Resultado delete</div>
        <h2>Post</h2>
        <a id="a_find_like" href="#a_find_like" onclick="enviar_ajax('webresources/inser.restful.restful_crud.producto/0/14', 'POST', 'jardineria', '2021jardineria', 'id_find_like', '%acero%')">find rango 0 a 14 like descripcion '%acero%'</a><br>
        <div id="id_find_like">Resultado find like</div>
        <a id="a_find_like_orden" href="#a_find_like_orden" onclick="enviar_ajax('webresources/inser.restful.restful_crud.producto/0/14/codigoProducto/desc', 'POST', 'jardineria', '2021jardineria', 'id_find_like_orden', '%acero%')">find rango 0 a 14 like descripcion '%acero%' ordenado por codigoProducto descendente</a><br>
        <div id="id_find_like_orden">Resultado find like</div>
    </body>
</html>
