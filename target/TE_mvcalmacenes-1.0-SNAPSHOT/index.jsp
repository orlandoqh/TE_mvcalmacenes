<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.Participantes"%>

<% ArrayList<Participantes> lista = (ArrayList<Participantes>) session.getAttribute("listtar");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Tareas</h1>
        <a href="MainController?op=nuevo">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Categoria</th>
                <th>Confirmado</th>
                <th>Fecha de inscripcion</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if (lista != null) {
                    for (Participantes item : lista) {
            %>
            <tr>
                <td><%= item.getId()%></td>
                <td><%= item.getNombres()%></td>
                <td><%= item.getApellidos%></td>
                <td><%= item.getCompletado()%></td>
               
        <td><a href="MainController?op=editar&id=<%= item.getId()%>">Editar</a></td>
        <td> <a href="MainController?op=eliminar&id=<%= item.getId()%>"
                onclick='return confirm("Esta seguro de eliminar el registro ?");'>Eliminar</a></td>
    </tr>
    <%

            }
        }
    %>
</table>
</body>
</html>
