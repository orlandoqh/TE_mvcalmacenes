
<%@page import="com.emergentes.modelo.Tareas"%>
<%
    Tareas item =(Tareas) request.getAttribute("mitarea");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= (item.getId() == 0)?"Nuevo Registro" : "Editar registro"%></h1>
        <form action="MainController" method="post">
            <input type="hidden" name="id" value="<%= item.getId()%>"/>
            <table>
                <tr>
                    <td>Tarea</td>
                    <td><input type="text" name="tarea" value="<%= item.getTarea()%>"/></td>
                </tr>
                <tr>
                    <td>Pioridad</td>
                    <td><select name="pioridad">
                            <option value ="alto">Alto</option>
                            <option value ="alto">Medio</option>
                            <option value="bajo">Bajo</option><%= item.getPioridad()%>"</select></td>
                </tr>
                <tr>
                    <td>Completado</td>
                    <td><input type="checkbox" name="completado" value="<%= item.getCompletado()%>" checked="checked" /></td>
                    
                
                    
                    
                </tr>   
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>