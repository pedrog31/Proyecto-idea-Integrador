
<%@page import="java.util.List"%>
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
        <h1>PROYECTO INTEGRADOR</h1>
        <p>
            Las asignaturas Proyecto Integrador I y Proyecto Integrador II hacen parte de la versión 3 del 
            plan de estudios del programa de Ingeniería de Sistemas. A la asignatura Proyecto Integrador I 
            pueden acceder los estudiantes después de haber aprobado cien (100) créditos en el programa. 
            El pre-requisito del Proyecto Integrador II es el proyecto Integrador I. El objetivo de las 
            asignaturas es fomentar el trabajo interdisciplinar mediante el enfrentamiento por equipos de un
            problema, cercano a la realidad, que requiere de una solución. Idealmente, el problema cubre 
            aspectos diversos a los que los estudiantes se enfrentarán con el bagaje acumulado en su 
            formación previa, buscando tanto la adquisición de nuevos conocimientos como el desarrollo de 
            nuevas habilidades y actitudes. 
        </p>
        
        <p>
            En el Proyecto Integrador un grupo pequeño de estudiantes se 
            reúne, con el acompañamiento de un tutor, a analizar y resolver un problema seleccionado o 
            diseñado especialmente para el logro de ciertos propósitos de formación. Durante el proceso 
            de interacción de los estudiantes para entender y resolver el problema se logra, además del 
            aprendizaje del conocimiento propio de la materia, que puedan elaborar un diagnóstico de sus 
            propias necesidades de aprendizaje, que comprendan la importancia de trabajar colaborativamente,
            que desarrollen habilidades de análisis y síntesis de información, además de comprometerse con 
            su proceso de aprendizaje.
        </p>
        
        <div class="cabecera"></div>
        <div class="tabla">
            <h2>Proyectos disponibles semestre xxx</h2>
            <table border="1px solid black;">
                <thead>
                    <tr>
                        <th>Título</th>
                    </tr>
                </thead>
                <tbody>
                    <%/* 
                    InterfaceIdeaDao idao = new IdeaDao();
                    List<Idea> prueba = idao.getOfertaSemestre("20161");
                    for(Idea id : prueba){*/
                    %>
                    <tr>
                        <td>
                            <!--
                            <button class="accordion"><%//out.print(id.getTitulo());%></button>
                            <div class="panel">
                                <p>Identificador: <%//out.print(id.getIdentificador());%></p>
                                
                                <p>Descripción del problema:<br/> 
                                   <%//out.print(id.getDescripcion());%>
                                </p>
                                
                                <p>Número de integrantes: <%//out.print(id.getNroEstudiantesxEquipo());%></p>                 
                                <p>Grupos disponibles: <%//out.print(id.getDisponibilidad());%></p>
                                <p>Postulante: <//%out.print(id.getPostulante());%></p>
                                <p>Profesor que avala: <%//out.print(id.getAvalador());%></p>
                                <p>Requisitos:<br/>
                                    <%//out.print(id.getRequisitos());%>
                                </p>   
                            </div>-->
                                    
                            <button class="accordion">Section 1</button>
                            <div class="panel">
                              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                            </div>

                            <button class="accordion">Section 2</button>
                            <div class="panel">
                              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                            </div>

                            <button class="accordion">Section 3</button>
                            <div class="panel">
                              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                            </div>
                                
                            <script>
                            var acc = document.getElementsByClassName("accordion");
                            var i;

                            for (i = 0; i < acc.length; i++) {
                                acc[i].onclick = function(){
                                    this.classList.toggle("active");
                                    this.nextElementSibling.classList.toggle("show");
                                }
                            }
                            </script>
                            
                        </td>
                    </tr>  
                    <% //}%> 
                </tbody>
            </table>
            <br/>
            <hr color="black"/>

        </div>
        
        <a href="login2.jsp">Volver</a>
        <a href="Formulario.jsp">formulario</a>
        
    </body>
    
</html>
