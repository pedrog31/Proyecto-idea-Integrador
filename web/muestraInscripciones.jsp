
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
        <h1>Inscripciones a Proyectos</h1>
        <div class="tabla">
                <table>
                    <tr>
                        <th>Radicado</th>
                        <th>Título de Idea</th>
                    </tr>
                    <c:forEach var="inscripcion" items="${inscripciones}" varStatus="cont">
                        <tr>
                            <td>${inscripcion.getRadicado()}</td> 
                            <td>
                                <button type="button" class="accordion"><c:out value="${ideas.get(count-1).getTitulo()}"/></button>
                                <div class="panel">
                                    <p>Estado: 
                                        <c:out value="${inscripcion.getEstado()}"/>
                                    </p>
                                    <p>Identificador: <c:out value="${inscripcion.getIdIdea()}"/></p>

                                    <p>Semestre:<br/> 
                                        <c:out value="${inscripcion.getSemestre()}"/>
                                    </p>

                                    <p>Estudiantes inscritos<br/>
                                    <ul>

                                        <c:forEach var="estudiante" items="${inscripcion.getInscritos()}">

                                            <li>
                                                <c:out value="${estudiante.getIdPersona()}"/>
                                                <c:out value="${estudiante.getNombre()}"/>
                                                <c:out value="${estudiante.getCorreo()}"/>

                                            </li>
                                        </c:forEach>
                                    </ul>
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
            <a href="lobbyAdm" class="boton">Volver al Inicio</a>


        </div>
    </body>

</html>
