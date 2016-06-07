
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
        <br/>
        <p>Inicie sesión con los demás integrantes para continuar</p>

        <form action="" method="post">
            <div>
                <table>
                    <tr>
                        <th>Usuario:</th>
                        <td><input type="text" name="u1"></td>
                    </tr>
                    <tr>
                        <th>Contraseña:</th>
                        <td><input type="password" name="c1"></td>
                    </tr>            
                    <tr>
                        <th>Nombre:</th>
                        <td><input type="text" name="n1"></td>
                    </tr>
                    <tr>
                        <th>Cédula:</th>
                        <td><input type="text" name="d1"></td>
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
                    <tr>
                        <th>Nombre:</th>
                        <td><input type="text" name="n2"></td>
                    </tr>
                    <tr>
                        <th>Cédula:</th>
                        <td><input type="text" name="d2"></td>
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
                    <tr>
                        <th>Nombre:</th>
                        <td><input type="text" name="n3"></td>
                    </tr>
                    <tr>
                        <th>Cédula:</th>
                        <td><input type="text" name="d3"></td>
                    </tr>
                </table>
            </div>

            <input type="submit" value="Enviar inscripción">
            <a href="Banco.jsp">Cambiar selección</a>
        </form>  
    </body>
</html>
