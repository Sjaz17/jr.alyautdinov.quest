<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>JR.QUEST.AAA</title>
    <style>
        body{
            margin-left: 16px;
        }
    </style>
</head>
<body>
<h1>SPACEQUEST</h1>
<div class="col-md-6">

    <p class="lead">Далёкое будущее. Космический буксир транспортирует к Земле груз - обогатительный комплекс, предназначенный для
        переработки двадцати миллионов тонн руды. Ввиду значительной продолжительности полёта команда погружена в анабиоз, судно ведёт автопилот.
        Когда автоматика пробуждает команду корабля, экипаж из 7-ми человек поначалу полагает, что рейс окончен, однако вскоре узнаёт, что они
        находится на орбите неисследованной планеты JR-404.<br>Вы капитан этого корабля по имени:</p>
</div>
<section >
    <div class="input-group mb-3">

        <form  action="quest-servlet">
            <div class="input-group mb-3">
            <input type="text" class="form-control" maxlength="10" name="name" placeholder="Только буквы"  aria-describedby="button-addon2" required pattern="[A-Za-zА-Яа-яЁё]+">
            <button value="1L" name="chosen" type="submit" class="btn btn-outline-success" id="button-addon2">Начать квест</button>
                </div>
        </form>
    </div>
</section>
</body>
</html>