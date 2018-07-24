<%--
  Created by IntelliJ IDEA.
  User: olesi
  Date: 7/22/2018
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>



<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Registration</title>

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <c:set var="language" value="${not empty param.language ? param.language
    : not empty language ? language : pageContext.request.locale}" scope="session" />


    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="Messages" />
</head>
<body>
<div align="center">
    <h1>Registration</h1>
    <c:if test="${not empty errorMessage}">
        <h2><fmt:message key="${errorMessage}"/></h2>
    </c:if>

    <c:if test="${not empty loginExistsMessage}">
        <h2>${loginExistsMessage}</h2>
    </c:if>
    <form action="/registration" method="post">
        <table>
            <tr>
                <th><fmt:message key="message.login"/></th>
                <td>
                    <input type="text" name="login">
                </td>
            </tr>
            <tr>
                <th><fmt:message key="message.password"/></th>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit"><fmt:message key="message.login"/></button>
                </td>
            </tr>

        </table>
    </form>

</div>

</body>
</html>
