<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Artist" %>

<!DOCTYPE html>
<html>
<head>
    <title>Artists</title>
    <style>
        body { font-family: Arial; }
        table { border-collapse: collapse; width: 70%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        form { margin: 0; }
    </style>
</head>
<body>



<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Nationality</th>
    </tr>

    <%
        List<Artist> artists = (List<Artist>) request.getAttribute("artists");
        if (artists != null && !artists.isEmpty()) {
            for (Artist artist : artists) {
    %>
    <tr>
        <td><%= artist.getId() %></td>
        <td><%= artist.getName() %></td>
        <td><%= artist.getNationality() %></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="4">No artists registered.</td>
    </tr>
    <%
        }
    %>

</table>

<br><br>

 

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>