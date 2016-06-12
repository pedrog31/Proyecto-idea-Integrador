
<%@page import="co.edu.udea.PInscriptionSystem.Controlador.Prerrequisitos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/formulario.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Formulario de Inscripción</h1>
        
        <div class="pingüino">
            <img src="img/tuxito.png" width="500">
        </div>
        <br/>      
        <p>Inicie sesión con todos los integrantes para continuar</p> 
        <form action="Prerrequisitos" method="post">
            <div class="all">
                <table>
                    <tr>
                        <th>Usuario:</th>
                        <td><input type="text" name="u1"></td>
                    </tr>
                    <tr>
                        <th>Contraseña:</th>
                        <td><input type="password" name="c1"></td>
                    </tr>            
                </table>
            </div>
            <div>
                <table>
                    <tr>
                        <th>Usuario:</th>
                        <td><input type="text" name="u2"></td>
                    </tr>
                    <tr>
                        <th>Contraseña:</th>
                        <td><input type="password" name="c2"></td>
                    </tr>            
                </table>
            </div>
            <div>
                <table>
                    <tr>
                        <th>Usuario:</th>
                        <td><input type="text" name="u3"></td>
                    </tr>
                    <tr>
                        <th>Contraseña:</th>
                        <td><input type="password" name="c3"></td>
                    </tr>            
                </table>
            </div>
            <input type="submit" value="Enviar inscripción">
            <a href="Banco.jsp">Cambiar selección</a>
        </form>
        <div class="pie"></div>
    </body>
</html>
