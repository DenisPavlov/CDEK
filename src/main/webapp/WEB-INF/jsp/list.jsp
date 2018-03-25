<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>

<section>
    <h3>Список записей</h3>

    <form method="post" action="/cdek/list/filter">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" name="name" ></dd>
            <%--<dd><input type="text" name="name" value="${param.endTime}"></dd>--%>
        </dl>
        <button type="submit">Фильтр</button>
    </form>
    <hr>
    <a href="/cdek/list/create">Добавить строку</a>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        </thead>
        <c:forEach items="${entitys}" var="entity">
            <jsp:useBean id="entity" scope="page" type="desktestproject.model.Entity"/>
            <tr>
                <td>${entity.id}</td>
                <td>${entity.name}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>