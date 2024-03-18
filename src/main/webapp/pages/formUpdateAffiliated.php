<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>GUILLERMO LEON VALENCIA</title>
</head>
<body>
<div class="container">
    <div id="header" class="header">GUILLERMO LEON VALENCIA</div>
    <div id="header2" class="header2">CLUB DEPORTIVO</div>
    <a href="pages/managmentEvent.html" style="text-decoration: none" class="button">Gestionar Eventos</a>
    <a href="pages/managmentStudent.html" style="text-decoration: none" class="button">Gestionar Estudiantes</a>
</div>

<div style="height: 200px">
    <div class="container" style="width: 60%">
        <div class="mb-3">
            <h4 class="display-5" id="register">ACTUALIZAR DATOS</h4>
        </div>
        <div class="mb-3">
            <label class="form-label">Nombre: </label>
            <input value="" class="form-control" type="text" id="name" name="name" size="30">
        </div>
        <div class="mb-3">
            <label class="form-label">Apellido: </label>
            <input class="form-control" type="text" id="lastName" name="lastName" size="30">
        </div>
        <div class="mb-3">
            <label class="form-label">DNI: </label>
            <input class="form-control" type="text" id="dni" name="dni" size="30">
        </div>
        <div class="mb-3">
            <label class="form-label">Edad: </label>
            <input class="form-control" type="text" id="age" name="age" size="30">
        </div>
        <div class="mb-3">
            <select id="events" name="events">
                <option value="1">Torneo Escolar de Fútbol</option>
                <option value="2">Challenge Basketball Tournament</option>
                <option value="3">Torneo Escolar de Natación UNAB</option>
                <option value="4">Torneo Buzzer Beater</option>
                <option value="5">Copa Atletismo Escolar</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Podium: </label>
            <input class="form-control" type="number" id="podium" name="podium" size="30">
        </div>
        <button style="color: black;border: 2px solid black;border-radius: 10px;cursor: pointer;padding: 10px 20px;margin: 20px" id="btn" type="button">ENVIAR</button>
    </div>

    <script src="../js/scriptUpdate.js"></script>
</body>
</html>