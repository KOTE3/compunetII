<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Artist" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Track</title>
</head>
<body>

<h2>Create New Track</h2>

<form action="<%= request.getContextPath() %>/addTrack" method="post">

    <label>Title:</label><br>
    <input type="text" name="title" required>
    <br><br>

    <label>Genre:</label><br>
    <input type="text" name="genre" required>
    <br><br>

    <label>Duration (minutes):</label><br>
    <input type="number" step="0.01" name="duration" required>
    <br><br>

    <label>Album Title:</label><br>
    <input type="text" name="albumTitle" required>
    <br><br>

    <label>Select Artists:</label><br>

    <select name="artistIds" multiple size="5" required>
        <%
            List<Artist> artists = (List<Artist>) request.getAttribute("artists");
            if (artists != null) {
                for (Artist artist : artists) {
        %>
            <option value="<%= artist.getId() %>">
                <%= artist.getName() %>
            </option>
        <%
                }
            }
        %>
    </select>

    <br><br>
    <button type="submit">Save Track</button>

</form>

<br>
<a href="tracks">Back to Track List</a>

</body>
</html>