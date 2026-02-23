<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Track" %>
<%@ page import="com.example.model.Artist" %>

<!DOCTYPE html>
<html>
<head>
    <title>Tracks</title>
    <style>
        body { font-family: Arial; }
        table { border-collapse: collapse; width: 90%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        form { margin: 0; }
    </style>
</head>
<body>


<br><br>

<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Genre</th>
        <th>Duration</th>
        <th>Album</th>
        <th>Artists</th>
     </tr>

<%
    List<Track> tracks = (List<Track>) request.getAttribute("tracks");

    if (tracks != null && !tracks.isEmpty()) {
        for (Track track : tracks) {
%>
    <tr>
        <td><%= track.getId() %></td>
        <td><%= track.getTitle() %></td>
        <td><%= track.getGenre() %></td>
        <td><%= track.getDuration() %></td>
        <td><%= track.getAlbumTitle() %></td>

        <td>
            <%
                if (track.getArtists() != null && !track.getArtists().isEmpty()) {
                    for (Artist artist : track.getArtists()) {
            %>
                <%= artist.getName() %><br>
            <%
                    }
                } else {
            %>
                No artists
            <%
                }
            %>
        </td>

 
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="7">No tracks registered.</td>
    </tr>
<%
    }
%>

</table>

<br><br>
<a href="index.jsp">Back to Home</a>

</body>
</html>