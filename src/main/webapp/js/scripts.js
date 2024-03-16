
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

    var data = `name=${name}&lastName=${lastName}&dni=${dni}&age=${age}`

    xhr.send(data)

})
