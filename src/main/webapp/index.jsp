<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>
    <meta charset="UTF-8" content="text/html">
</head>
<body>
<div align="center">
    <h2>Select your language</h2>

    <table>
        <tr>
            <td>
                <form action="/" method="post">
                    <input type="hidden" name="language" value="en">
                    <button type="submit">English</button>

                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form method="POST" action="/">
                    <input type="hidden" name="language" value="ua">
                    <button type="submit">Українська</button>
                </form>
            </td>
        </tr>
    </table>
</div>

</body>
</html>
