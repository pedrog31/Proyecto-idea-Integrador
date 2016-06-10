
<%@page import="co.edu.udea.PInscriptionSystem.Repositorio.Dto.Requisito"%>
<%@page import="co.edu.udea.PInscriptionSystem.Repositorio.Dto.Idea"%>
<%@page import="co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.IdeaDao"%>
<%@page import="co.edu.udea.PInscriptionSystem.Repositorio.Dao.*"%>
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
        

        <div class="tabla">
            <h2>Proyectos disponibles semestre xxx</h2>
                
            <form method="post" action="SeleccionarIdea">
                <table border="1px solid black;">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Título</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        InterfaceIdeaDao idao = new IdeaDao();
                        List<Idea> prueba = idao.getOfertaSemestre("20161");
                        for(Idea id : prueba){
                        %>
                        <tr>
                            <td><input type="radio" name="add" onclick="redireccion()"></td>
                            <td>
                                <p class="accordion"><%out.print(id.getTitulo());%></p>
                                <div class="panel">
                                    <p>Identificador: <%out.print(id.getIdentificador());%></p>

                                    <p>Descripción del problema:<br/> 
                                       <%out.print(id.getDescripcion());%>
                                    </p>

                                    <p>Número de integrantes: <%out.print(id.getNroEstudiantesxEquipo());%></p>                 
                                    <p>Grupos disponibles: <%out.print(id.getDisponibilidad());%></p>
                                    <p>Postulante: <%out.print(id.getPostulante());%></p>
                                    <p>Profesor que avala: <%out.print(id.getAvalador().getNombre()+"  "+id.getAvalador().getCorreo());%></p>
                                    <p>Requisitos:<br/>
                                        <%
                                            Requisito r = id.getRequisitos();
                                            out.print(r.getA1()+""+r.getA2()+r.getA3()+r.getA4()+r.getA5()+r.getA6()+r.getA7()+r.getA8());%>
                                    </p>   
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
                        <% }%> 
                    </tbody>
                </table>
                    <a href="login2.jsp">Volver</a>
                    <input type="submit" value="Inscribir Idea">    
            </form>
            <br/>
            <hr color="black"/>
        </div>
        
        

        
    </body>
    
</html>
