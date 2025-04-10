function negrita(){
    window.document.execCommand("bold", false, "null");
}
function cursiva(){
    document.execCommand("italic", false, "null");
}
function subrayado(){
    document.execCommand("underline", false, "null");
}
function alineai(){
    document.execCommand("justifyLeft", false, "null");
}
function alineac(){
    document.execCommand("justifyCenter", false, "null");
}
function alinead(){
    document.execCommand("justifyRight", false, "null");
}
function alineaf(){
    document.execCommand("justifyFull", false, "null");
}
function listano(){
    document.execCommand("insertUnorderedList", false, "null");
}
function listao(){
    document.execCommand("insertOrderedList", false, "null");
}
function subi(){
    document.execCommand("subscript", false, "null");
}
function supi(){
    document.execCommand("superscript", false, "null");
}
function fontcolor(){
    color = prompt("Introduce el color de la fuente");
    document.execCommand("foreColor", false, color);
}
function backcolor(){
    color = prompt("Introduce el color de fondo");
    document.execCommand("backColor", false, color);
}
function insertarimg(){
    imagen = prompt("Introduce la ruta y el nombre del archivo");
    document.execCommand("insertImage", false, imagen);
}
function hipervinculo(){
    var enlace = prompt("Introduce la URL: ", "http://");
    document.execCommand("createLink", false, enlace);
}
function publicar(){
    var conte = document.getElementById("contenido").innerHTML;
    document.getElementById("Mesajes").innerHTML = conte;
}