<%-- 
    Document   : index
    Created on : 23-may-2016, 9:06:19
    Author     : PedroGallego
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <title>INSCRIPCIÓN PROYECTO INTEGRADOR</title>
    </head>
    <body>
        <section class="container">
            <div class="img">
                <img src="http://original.livestream.com/filestore/logos/1a940f0c-d77c-2a99-9885-acbfc54b6292-banner.jpg" height="130" width="1330">
            </div>
            <br/>
            <div class="main">
                <br /><br />
                <h1>Iniciar Sesión</h1>            
                <br /><br /> 
                <form method="post" action="Ingreso">
                    <table cellpadding="2" cellspacing="2"> 
                        <tr>
                            <th>Ingrese Usuario:</th>
                            <td><input type = "text" placeholder=" usuario" name = "user"></td>
                        </tr>
                        <tr>
                            <th>Ingrese cotraseña:</th>
                            <td><input type="password" placeholder=" contraseña" name = "clave"></td>
                        </tr>
                    </table>    
                    <br />
                    <table>
                        <tr>
                            <td>
                                <span>
                                    <%
                                        String error = "";
                                        if(request.getParameter("error") != null){
                                            out.print(request.getParameter("error"));
                                        }else{
                                            out.print("");
                                        }
                                    %>
                                </span>               
                            </td>
                        </tr>
                    </table>
                    <br/>
                    <br /><br />
                    <input type="submit" value="Ingresar">
                </form>
            </div>  
        </section>  
    </body>
</html>