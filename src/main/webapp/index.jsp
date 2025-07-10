<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="header.jsp" />
    <title>JR.QUEST.AAA</title>
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
<div class="position-fixed text-warning p-2 border border-warning rounded-pill">
    <h1>SPACEQUEST</h1>
</div><br><br><br>
<div class="col-md-6 text-warning">

    <p class="lead ">Далёкое будущее. Космический буксир транспортирует к Земле груз - обогатительный комплекс, предназначенный для
        переработки двадцати миллионов тонн руды. Ввиду значительной продолжительности полёта команда погружена в анабиоз, судно ведёт автопилот.
        Когда автоматика пробуждает команду корабля, экипаж из семи человек поначалу полагает, что рейс окончен, однако вскоре узнаёт, что они
        находятся на орбите неисследованной планеты JR-404.<br>Вы капитан этого корабля по имени:</p>
</div>
<section >
    <div class=" input-group mb-3">

        <form  action="controller-servlet">
            <div class="input-group mb-3">
            <input type="text" class="form-control " maxlength="10" name="name" placeholder="Только буквы"  aria-describedby="button-addon2" required pattern="[A-Za-zА-Яа-яЁё]+">
            <button value="1" name="chosen" type="submit" class="btn btn-outline-warning" id="button-addon2">Начать квест</button>
                </div>
        </form>
    </div>
</section>

</body>
</html>