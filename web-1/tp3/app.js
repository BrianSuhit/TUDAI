"use strict";

// identifico el evento
let btnEnviar = document.querySelector("#btn-enviar");        

// asigno el event listener
btnEnviar.addEventListener("click", tomarDatos);

function tomarDatos(){
    
    // leer el valor del input
    let nombre = document.querySelector("#input-nombre").value;

    alert(nombre);  
    
    // escribir en el HTML
    let texto = document.querySelector("#titulo-secundario");
    texto.innerHTML = nombre;
}