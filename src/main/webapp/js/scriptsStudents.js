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
                    let eventString = item.event;
                    let eventNameMatch = eventString.match(/name='(.*?)'/);
                    let eventDescriptionMatch = eventString.match(/description='(.*?)'/);
                    let disciplineMatch = eventString.match(/discipline=Discipline{(.*?)}/);

                    let disciplineString = disciplineMatch[1];
                    let disciplineNameMatch = disciplineString.match(/name='(.*?)'/);
                    let disciplineDescriptionMatch = disciplineString.match(/description='(.*?)'/);
                    let disciplineGroupMatch = disciplineString.match(/group=(\w+)/);

                    res.innerHTML += `<tr>
                        <td>${count}</td>
                        <td>${item.name}</td>
                        <td>${item.lastName}</td>
                        <td>${item.dni}</td>
                        <td>${item.age}</td>
                        <td>${eventNameMatch[1]}</td>
                        <td>${disciplineNameMatch[1]}</td>
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

document.querySelector("#update").addEventListener('click',()=>{
    const  xhr = new XMLHttpRequest()


    xhr.open("POST","http://localhost:3008/sample-jakarta/affiliated_update",true)
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onreadystatechange=function (){
        if(xhr.readyState === 4 && xhr.status === 200){
            if(xhr.responseText){
                let data = JSON.parse(xhr.response)

                for(let item of data) {
                    console.log("aa")
                    let eventString = item.event;
                    let eventNameMatch = eventString.match(/name='(.*?)'/);
                    let eventDescriptionMatch = eventString.match(/description='(.*?)'/);
                    let disciplineMatch = eventString.match(/discipline=Discipline{(.*?)}/);

                    let disciplineString = disciplineMatch[1];
                    let disciplineNameMatch = disciplineString.match(/name='(.*?)'/);
                    let disciplineDescriptionMatch = disciplineString.match(/description='(.*?)'/);
                    let disciplineGroupMatch = disciplineString.match(/group=(\w+)/);

                    location.href = "../pages/formUpdateAffiliated.php?name=" + item.name + "&lastName=" + item.lastName + "&dni=" + item.dni + "&age=" + item.age+ "&event=" + eventNameMatch[1];
                }
            }else{
                alert("Consulta no satisfactoria")
            }
        }
    }

    var dni = document.querySelector("#dni2").value
    console.log(dni)

    var data = `dni=${dni}`

    xhr.send(data)
})
document.querySelector("#delete").addEventListener('click',(event)=>{
    const  xhr = new XMLHttpRequest()


    xhr.open("POST","http://localhost:3008/sample-jakarta/affiliated_delete",true)
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onreadystatechange=function (){
        if(xhr.readyState === 4 && xhr.status === 200){
            if(xhr.responseText){
                alert("Eliminación satisfactoria")
            }else{
                alert("Eliminación no satisfactoria")
            }
        }
    }

    var dni = document.querySelector("#dni").value
    console.log(dni)

    var data = `dni=${dni}`

    xhr.send(data)
})

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
}
onload()