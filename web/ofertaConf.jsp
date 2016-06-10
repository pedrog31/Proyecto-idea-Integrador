
<%@page import="java.util.ArrayList"%>
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
        <script language="JavaScript" >
            function emergente()
        </script>
    </head>
    
    <body>
        <h1>IDEAS A OFERTAR</h1>
        <%!List<String> idIdeas = new ArrayList<String>();%>
        <div class="tabla">
            <form name="ofertaForm" action="ConfOferta" method="post">
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Título</th>
                    </tr>
                    <c:forEach var="idea" items="${listaIdeas}">
                        <tr>
                            <td name="id" value="${idea.getIdentificador()}">${idea.getIdentificador()}</td> 
                            <%idIdeas.add(request.getParameter("id"));%>
                            <td>
                                <button type="button" class="accordion"><c:out value="${idea.getTitulo()}"/></button>
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
                                    <ul>

                                        <c:forEach var="area" items="${idea.getRequisitos().getAreas()}" varStatus="ite">

                                            <li>
                                                <c:out value="${area}"/>

                                                <ul>
                                                    <c:forEach var="materia" items="${idea.getRequisitos().getListasDeRequisitos().get(ite.count-1)}">
                                                        <li>
                                                            <c:out value="${materia.getCodigo()}"/>
                                                            <c:out value="${materia.getNombre()}"/>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
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
                <label>Ingrese el semestre para el cual se generará la oferta</label>
                <input type="text" name="semestre"/>
            </form>
            <%
                request.setAttribute("listaIdeas", idIdeas);
                //request.getRequestDispatcher("ConfOferta.jsp").forward(request, response);
            %>
            <a href="javascript:document.ofertaForm.submit();" class="boton">Confirmar oferta</a>

            
            
            
        </div>
    </body>

</html>
