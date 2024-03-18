let params = new URLSearchParams(window.location.search)
let n = params.get('name')
let ln = params.get('lastName')
let d = params.get('dni')
let a = params.get('age')
let ne = params.get('event')
let p = params.get('podium')

const nameInput = document.querySelector("#name")
const lastNameInput = document.querySelector("#lastName")
const dniInput = document.querySelector("#dni")
const ageInput = document.querySelector("#age")
const eventInput = document.querySelector("#events")
const podiumInput = document.querySelector("#podium")

nameInput.value = n
lastNameInput.value = ln
dniInput.value = d
ageInput.value = a
podiumInput.value = p

if(ne == "Torneo Escolar de Fútbol"){
    eventInput.value = 1
}
if(ne == "Torneo Buzzer Beater"){
    eventInput.value = 4
}
if(ne == "Challenge Basketball Tournament"){
    eventInput.value = 2
}
if(ne == "Torneo Escolar de Natación UNAB"){
    eventInput.value = 3
}
if(ne == "Copa Atletismo Escolar"){
    eventInput.value = 5
}

document.querySelector("#btn").addEventListener('click',()=>{
    const  xhr = new XMLHttpRequest()


    xhr.open("POST","http://localhost:3008/sample-jakarta/update_servlet",true)
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onreadystatechange=function (){
        if(xhr.readyState === 4 && xhr.status === 200){
            if(xhr.responseText){
                alert("actualización satisfactoria")
                location.href = "../pages/managmentStudent.html"
            }else{
                alert("actualización no satisfactoria")
            }
        }
    }
    var name = document.querySelector("#name").value
    var lastName = document.querySelector("#lastName").value
    var dni = document.querySelector("#dni").value
    var age = document.querySelector("#age").value
    var event = document.querySelector("#events").value
    var podium = document.querySelector("#podium").value

    var data = `name=${name}&lastName=${lastName}&dni=${dni}&age=${age}&event=${event}&podium=${podium}`

    xhr.send(data)
})

window.onload = function() {
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
    container.style.marginBottom = "100px"



    var header = document.querySelector(".header");
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
};