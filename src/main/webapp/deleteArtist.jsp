<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Artist" %>

<html>
<head>
    <title>Eliminar Artista</title>
</head>
<body>

<h2>Eliminar Artista por ID</h2>

<%
    List<Artist> artists = (List<Artist>) request.getAttribute("artists");
    if (artists != null && !artists.isEmpty()) {
%>

<h3>Artistas registrados:</h3>
<ul>
    <% for (Artist artist : artists) { %>
        <li>ID: <%= artist.getId() %> - <%= artist.getName() %></li>
    <% } %>
</ul>

<form action="deleteArtist" method="post">
    <label>Ingrese el ID del artista a eliminar:</label>
    <input type="number" name="artistId" required />
    <br><br>
    <button type="submit">Eliminar</button>
</form>

<%
    } else {
%>
    <p>No hay artistas registrados.</p>
<%
    }
%>

<br>
<a href="index.jsp">Volver al inicio</a>

</body>
</html>