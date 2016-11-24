<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Emerson's Game</title>
    </head>
    <body>
        <h1>New Race</h1>

        <form action="<c:url value="/races"/>" method="post">
            <label for="name">Name</label>
            <input id="name" name="name" />

            <br />

            <input id="submit" type="submit" />
        </form>
    </body>
</html>
