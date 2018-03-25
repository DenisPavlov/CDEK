<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<%--<jsp:include page="fragments/headTag.jsp"/>--%>
<body>
<%--<jsp:include page="fragments/bodyHeader.jsp"/>--%>

<section>
    <jsp:useBean id="entity" type="cdektestproject.model.Entity" scope="request"/>
    <h3>Добавить запись</h3>
    <hr>
    <form method="post" action="add">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" name="name" value="${entity.name}"></dd>
        </dl>
        <button type="submit">Добавить</button>
        <button onclick="window.history.back()" type="button">Отмена</button>
    </form>
</section>
<%--<jsp:include page="fragments/footer.jsp"/>--%>
</body>
</html>
