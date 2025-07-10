
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <c:import url="header.jsp" />
    <title>Quest started</title>
    <style>
        body{
            margin-left: 16px;
            margin-top: 10px;
            background: url(background.jpg) no-repeat;
            background-size: 100%;
        }
    </style>
</head>
<body>
<div class="position-fixed text-warning p-2 border border-warning rounded-pill ">
<h1>SPACEQUEST</h1>
</div><br><br><br><br>

    <p class="lead text-warning col-md-6">${quest.getText()}</p>
<div class="text-warning">
    <c:if test="${stage==1}">
        <p class="lead">Ваши приказания?</p>
        <form action="/controller-servlet" method="GET">
            <c:forEach var="answer" items="${quest.getAnswers()}">
            <input class="form-check-input" type="radio" id="this" name="chosen" checked value="${answer.value}">
            <label class="form-check-label" for="this"><p class="lead"> ${answer.key}</p></label><br>
            </c:forEach>
            <button type="submit" class="btn btn-outline-warning">Подтвердить</button>
        </form>
    </c:if>
<c:if test="${stage==0}">
    <p class="lead col-md-6">${quest.getAnswers().entrySet().iterator().next().getKey()}</p>
    <form action="/controller-servlet" method="GET">
        <button value="1" name="chosen" type="submit" class="btn btn-outline-success">Пройти еще раз</button>
    </form>
</c:if>
</div>
<div class="position-fixed text-success p-3 border border-success rounded bg-black ">
    <h6 class="text-center fw-bold"> Статистика прохождения</h6>
    <p class="mb-1">Игрок: ${sessionScope.name}</p>
    <p class="mb-1">Количество игр: ${questCounter}</p>
    <p class="mb-1">Успешно доставленных грузов: ${sessionScope.successCounter}</p>
</div>
</body>
</html>
