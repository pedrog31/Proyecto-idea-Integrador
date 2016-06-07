
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            
            try{
                String usuario = request.getParameter("user");
                String contraseña = request.getParameter("clave");
                if(!usuario.equals("") && !contraseña.equals("")){
                    
                    
                  
                    
                    
                }else{
                    response.sendRedirect("login2.jsp?error=Nombre de usuario o clave incorrecta");
                }
                
            }catch(Exception e){
                response.sendRedirect("login2.jsp?error=Nombre de usuario o clave incorrecta");
            }      
        %>
    </body>
</html>
