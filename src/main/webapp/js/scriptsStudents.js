function loadStudents() {
    const  xhr = new XMLHttpRequest()


    xhr.open("GET","http://localhost:3008/sample-jakarta/affiliated_servlet")
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onreadystatechange=function (){
        if(xhr.readyState === 4 && xhr.status === 200){
            if(xhr.responseText){
                //alert("Consulta satisfactoria:\n"+xhr.response)
                let data = JSON.parse(xhr.response)

                let res = document.querySelector("#res")
                res.innerHTML = ''
                var count = 1
                for(let item of data){
                    res.innerHTML += `<tr>
                        <th scope="row"></th>
                        <td>${count}</td>
                        <td>${item.name}</td>
                        <td>${item.lastName}</td>
                        <td>${item.dni}</td>
                        <td>${item.age}</td>
                    </tr>`
                    count++
                }

            }else{
                alert("Consulta no satisfactoria")
            }
        }
    }

    xhr.send(null)

}
loadStudents();

function onload() {
    document.body.style.backgroundColor = "#f5f5f5";
    document.body.style.fontFamily = "Arial, sans-serif";


    var container = document.querySelector(".container");
    container.style.backgroundImage = "url('../Recursos/ColorHeader.png')";  // Usa tu imagen con fondo transparente
    container.style.backgroundColor = "rgba(0, 0, 0, 0.5)";  // Establece un color de fondo RGBA
    container.style.backgroundBlendMode = 'multiply';  // Mezcla la imagen de fondo con el color de fondo
    container.style.backgroundSize = "cover";
    container.style.padding = "20px";
    container.style.textAlign = "center";
    container.style.clipPath = "polygon(0 0, 100% 0, 100% 85%, 50% 100%, 0 85%)";

    var containerText = document.querySelector(".containerText");
    containerText.style.backgroundColor = "#FFFFFF";  // Establece un color de fondo RGBA
    containerText.style.padding = "20px";
    containerText.style.textAlign = "center";

    var header = document.querySelector("#header");
    header.style.color = "white";
    header.style.fontSize = "20px";
    header.style.margin = "0";  // Elimina el espacio alrededor del texto

    var header2 = document.querySelector("#header2");
    header2.style.color = "white";
    header2.style.fontSize = "40px";
    header2.style.margin = "0";  // Elimina el espacio alrededor del texto
    header2.style.textShadow = "5px 5px 20px rgba(0, 0, 0, 0.5)";

    var buttons = document.querySelectorAll(".button");
    for (var i = 0; i < buttons.length; i++) {
        buttons[i].style.backgroundColor = "transparent";
        buttons[i].style.color = "white";
        buttons[i].style.padding = "10px 20px";
        buttons[i].style.margin = "20px";
        buttons[i].style.cursor = "pointer";
        buttons[i].style.border = "2px solid white";  // Agrega un borde blanco
        buttons[i].style.borderRadius = "10px";  // Hace que las puntas sean redondeadas
    }

    // Agrega el efecto de cambio de color al pasar el cursor sobre los botones
    var style = document.createElement('style');
    style.innerHTML = `
            .button:hover {
                transform: scale(1.1);  // Amplía el botón a un 110% de su tamaño original
                transition: transform 0.3s ease;  // Agrega una animación suave a la transformación
            }
        `;
    document.head.appendChild(style);

    var sections = document.querySelectorAll(".section");
    for (var i = 0; i < sections.length; i++) {
        sections[i].style.backgroundColor = "#FFFFFF";
        sections[i].style.padding = "20px";
        sections[i].style.margin = "2px 0";
        sections[i].style.textAlign = "justify";
        sections[i].style.color = "#191B25";
        sections[i].style.font = "inherit";
    }



    var body = document.getElementsByTagName("body")[0];

    // Crea un elemento <table> y un elemento <tbody>
    var tabla = document.createElement("table");
    var tblBody = document.createElement("tbody");

    // Crea las celdas
    for (var i = 0; i < 6; i++) {
        // Crea las hileras de la tabla
        var hilera = document.createElement("tr");

        for (var j = 0; j < 2; j++) {
            // Crea un elemento <td> y un nodo de texto, haz que el nodo de
            // texto sea el contenido de <td>, ubica el elemento <td> al final
            // de la hilera de la tabla
            var celda = document.createElement("td");
            var textoCelda = document.createTextNode(
                "celda en la hilera " + i + ", columna " + j,
            );
            celda.appendChild(textoCelda);
            hilera.appendChild(celda);
        }

        // agrega la hilera al final de la tabla (al final del elemento tblbody)
        tblBody.appendChild(hilera);
    }

    // posiciona el <tbody> debajo del elemento <table>
    tabla.appendChild(tblBody);
    // appends <table> into <body>
    body.appendChild(tabla);
    // modifica el atributo "border" de la tabla y lo fija a "2";
    tabla.setAttribute("border", "2");


}
onload()