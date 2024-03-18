
document.querySelector("#btn").addEventListener('click',()=>{
    const  xhr = new XMLHttpRequest()


    xhr.open("POST","http://localhost:3008/sample-jakarta/affiliated_servlet",true)
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onreadystatechange=function (){
        if(xhr.readyState === 4 && xhr.status === 200){
           if(xhr.responseText){
               alert("inserción satisfactoria")
           }else{
               alert("inserción no satisfactoria")
           }
        }
    }
    var name = document.querySelector("#name").value
    var lastName = document.querySelector("#lastName").value
    var dni = document.querySelector("#dni").value
    var age = document.querySelector("#age").value
    var event = document.querySelector("#events").value

    var data = `name=${name}&lastName=${lastName}&dni=${dni}&age=${age}&event=${event}`

    xhr.send(data)

})
window.onload = function() {
    document.body.style.backgroundColor = "#f5f5f5";
    document.body.style.fontFamily = "Arial, sans-serif";


    var container = document.querySelector(".container");
    container.style.backgroundImage = "url('Recursos/ColorHeader.png')";  // Usa tu imagen con fondo transparente
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

    var header = document.querySelector(".header");
    header.style.color = "white";
    header.style.fontSize = "20px";
    header.style.margin = "0";  // Elimina el espacio alrededor del texto

    var header2 = document.querySelector(".header2");
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

    var subtitles = document.querySelectorAll(".subtitles");
    for(var i = 0; i < subtitles.length; i++) {
        subtitles[i].style.backgroundImage = "url('Recursos/ColorHeader.png')";
        subtitles[i].style.padding = "20px";
        subtitles[i].style.margin = "2px 0";
        subtitles[i].style.textAlign = "left";
        subtitles[i].style.fontSize = "5px";
        subtitles[i].style.color = "#FFFFFF";
        subtitles[i].style.backgroundSize = "cover";
        subtitles[i].style.font = "inherit";
        subtitles[i].style.fontWeight = "bold";
        var altura = container.offsetHeight; // Obtiene la altura del contenedor
        subtitles[i].style.borderTopRightRadius = altura / 2 + 'px';
        subtitles[i].style.borderBottomRightRadius = altura / 2 + 'px';
    }

    var tabla = document.getElementById('miTabla');
    tabla.style.width = '100%';
    tabla.style.borderCollapse = 'collapse';

    var celdas = tabla.getElementsByTagName('td');
    for (var i = 0; i < celdas.length; i++) {
        celdas[i].style.border = '1px solid #ddd';
        celdas[i].style.padding = '8px';
        celdas[i].style.textAlign = 'center';
    }
    var encabezados = tabla.getElementsByTagName('th');
    for (var i = 0; i < encabezados.length; i++) {
        encabezados[i].style.backgroundColor = '#f2f2f2';
        encabezados[i].style.color = 'black';
        encabezados[i].style.padding = '12px';
    }

    // Establecer un estilo para las filas al pasar el mouse
    tabla.onmouseover = function(event) {
        if (event.target.tagName === 'TD') {
            event.target.style.backgroundColor = '#f5f5f5';
        }
    };

    // Revertir el estilo de las filas cuando el mouse deja la celda
    tabla.onmouseout = function(event) {
        if (event.target.tagName === 'TD') {
            event.target.style.backgroundColor = '';
        }
    }

    var name = document.querySelector("#name").value
    var lastName = document.querySelector("#lastName").value
    var dni = document.querySelector("#dni").value
    var age = document.querySelector("#age").value

    var data = `name=${name}&lastName=${lastName}&dni=${dni}&age=${age}`
};
