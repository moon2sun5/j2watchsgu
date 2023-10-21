function addSP(){

    var newinput1 = document.createElement("select");
    newinput1.className = "form-control1";

    var newinput2 = document.createElement("input");
    newinput2.type = "text";
    newinput2.className = "form-control1";

    var newinput3 = document.createElement("input");
    newinput3.type = "number";
    newinput3.className = "form-control1";

    document.getElementById("form1").insertAdjacentHTML("beforeend", "<hr><br>");

    document.getElementById("form1").insertAdjacentHTML("beforeend", "<label class='labelsp'>Sản phẩm: </label>");
    document.getElementById("form1").appendChild(newinput1);
    document.getElementById("form1").insertAdjacentHTML("beforeend", "<label class='labelsp'>Giá bán: </label>");
    document.getElementById("form1").appendChild(newinput2);
    document.getElementById("form1").insertAdjacentHTML("beforeend", " <label class='labelsp'>Số lượng: </label>");
    document.getElementById("form1").appendChild(newinput3);


}
