<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Artist</title>
</head>
<body>

<h2>Create New Artist</h2>

<form action="<%= request.getContextPath() %>/addArtist" method="post">

    <label for="name">Artist Name:</label>
    <input type="text" id="name" name="name" required>
    <br><br>

    <label for="nationality">Nationality:</label>
    <input type="text" id="nationality" name="nationality" required>
    <br><br>

    <button type="submit">Save Artist</button>

</form>

<br>
<a href="artists">Back to Artist List</a>

</body>
</html>