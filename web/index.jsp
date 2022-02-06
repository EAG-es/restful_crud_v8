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
            function enviar_ajax(url, metodo, usuario, clave, div_id, objeto_js) {
                var xMLHttpRequest = new XMLHttpRequest();
                xMLHttpRequest.open(metodo, url, true);
                xMLHttpRequest.setRequestHeader("Content-Type", "application/json");
                xMLHttpRequest.setRequestHeader("Accept", "application/json");
                xMLHttpRequest.setRequestHeader("javax.persistence.jdbc.user", usuario);
                xMLHttpRequest.setRequestHeader("javax.persistence.jdbc.password", clave);
                xMLHttpRequest.onreadystatechange = function () {
                    if (xMLHttpRequest.readyState === 4) { 
                        if (xMLHttpRequest.status >= 200
                            && xMLHttpRequest.status < 300) {
                            var json = JSON.parse(xMLHttpRequest.responseText);
                            document.getElementById(div_id).innerHTML
                                =  JSON.stringify(json);
                        } else {
                          document.getElementById(div_id).innerHTML
                                =  "Error en la recepcion: <br>" 
                                + xMLHttpRequest.status
                                + " : <br>"
                                + xMLHttpRequest.responseText;
                        }
                    }
                };
                var data = JSON.stringify(objeto_js);
                xMLHttpRequest.send(data);
            }
        </script>                    
    </head>
    <body>
        <h1>Restful CRUD (Jardineria)</h1>
        <h2>Get</h2>
        <a href="#" onclick="enviar_ajax('webresources/inser.restful.restful_crud.producto/22225', 'GET', 'jardineria', '2021jardineria', 'id_get')">get_recurso()</a><br>
        <div id="id_get">Resultado get</div>
    </body>
</html>
