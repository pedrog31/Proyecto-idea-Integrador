
<%@page import="co.edu.udea.PInscriptionSystem.Repositorio.Dto.Requisito"%>
<%@page import="co.edu.udea.PInscriptionSystem.Repositorio.Dto.Idea"%>
<%@page import="co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.IdeaDao"%>
<%@page import="co.edu.udea.PInscriptionSystem.Repositorio.Dao.*"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/banco.css">
        <title>Proyecto Integrador</title>        
    </head>
    <script language="JavaScript" >

        function emergente()

    </script>
    <body>
        <h1>IDEAS DE PROYECTOS</h1>
        <div class="tabla">
                <table>
                    <tr>
                        <th>Agregar</th>
                        <th>ID</th>
                        <th>Título</th>
                    </tr>
                    <c:forEach var="idea" items="${listaIdeas}">
                        <tr>
                            <td><input type="checkbox" name="add" value="<c:out value="${idea.getIdentificador()}"/>"/></td>
                            <td>${idea.getIdentificador()}</td> 
                            <td>
                                <button class="accordion"><c:out value="${idea.getTitulo()}"/></button>
                                <div class="panel">
                                    <p>Identificador: <c:out value="${idea.getIdentificador()}"/></p>

                                    <p>Descripción del problema:<br/> 
                                        <c:out value="${idea.getTitulo()}"/>
                                    </p>

                                    <p>Número de integrantes: <c:out value="${idea.getNroEstudiantesxEquipo()}"/></p>                 
                                    <p>Grupos disponibles: <c:out value="${idea.getDisponibilidad()}"/></p>
                                    <p>Postulante: <c:out value="${idea.getPostulante()}"/></p>
                                    <p>Profesor que avala: <c:out value="${idea.getAvalador().getNombre()}"/><c:out value="${idea.getAvalador().getCorreo()}"/></p>
                                    <p>Requisitos:<br/>
                                        ${idea.getRequisitos().getA1()}
                                        ${idea.getRequisitos().getA2()}
                                        ${idea.getRequisitos().getA3()}
                                        ${idea.getRequisitos().getA4()}
                                        ${idea.getRequisitos().getA5()}
                                        ${idea.getRequisitos().getA6()}
                                        ${idea.getRequisitos().getA7()}
                                        ${idea.getRequisitos().getA8()}
                                    </p>   
                                </div>
                                <script>
                                            var acc = document.getElementsByClassName("accordion")
                                    ;
                                    var i;

                                    for (i = 0; i < acc.length; i++) {
                                        acc[i].onclick = function () {
                                            this.classList.toggle("active");
                                            this.nextElementSibling.classList.toggle("show");
                                        }
                                    }
                                </script>

                            </td>
                        </tr> 
                    </c:forEach>
                </table>

                <a href="/PInscriptionSystems/ofertar">Ofertar Proyectos</a>


        </div>
    </body>

</html>
