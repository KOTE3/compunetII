<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.Artist" %>
<%@ page import="com.example.model.Track" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Buscar Artista</title>
</head>
<body>

<h2>Buscar Artista por Nombre</h2>

<form action="searchArtist" method="post">
    <label>Nombre del artista:</label>
    <input type="text" name="name" required />
    <button type="submit">Buscar</button>
</form>

<br>

<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
        <p style="color:red;"><%= error %></p>
<%
    }

    Artist artist = (Artist) request.getAttribute("artist");
    if (artist != null) {
%>

<h3>Datos del Artista</h3>
<ul>
    <li>ID: <%= artist.getId() %></li>
    <li>Nombre: <%= artist.getName() %></li>
    <li>Nacionalidad: <%= artist.getNationality() %></li>
</ul>

<h3>Canciones del Artista</h3>

<%
    if (artist.getTracks() == null || artist.getTracks().isEmpty()) {
%>
        <p>Este artista no tiene canciones registradas.</p>
<%
    } else {
%>
        <ul>
        <% for (Track track : artist.getTracks()) { %>
            <li>
                <%= track.getTitle() %> |
                Género: <%= track.getGenre() %> |
                Álbum: <%= track.getAlbumTitle() %> |
                Duración: <%= track.getDuration() %> seg
            </li>
        <% } %>
        </ul>
<%
        }
    }
%>

<br>
<a href="index.jsp">Volver al inicio</a>

</body>
</html>