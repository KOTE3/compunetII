<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Track" %>
<%@ page import="com.example.model.Artist" %>

<html>
<head>
    <title>Eliminar Canción</title>
</head>
<body>

<h2>Eliminar Canción</h2>

<%
    List<Track> tracks = (List<Track>) request.getAttribute("tracks");
    if (tracks == null || tracks.isEmpty()) {
%>
        <p>No hay canciones disponibles para eliminar.</p>
<%
    } else {
%>

<form action="deleteTrack" method="post">

    <label for="trackId">Selecciona la canción:</label>
    <select name="trackId" required>
        <% for (Track track : tracks) { %>
            <option value="<%= track.getId() %>">
                <%= track.getTitle() %>
            </option>
        <% } %>
    </select>

    <br><br>

    <button type="submit">Eliminar</button>

</form>

<%
    }
%>

<br>
<a href="index.jsp">Volver al inicio</a>

</body>
</html>