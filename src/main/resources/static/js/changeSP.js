
const fixSPBtns = document.querySelectorAll('.tinhnang2')
const modalSP = document.querySelector('.js-modalSP')
const modalcontainerSP = document.querySelector('.js-containerSP')
const modalcloseSP = document.querySelector('.js-close-SP')

// Hàm hiển thị
function showformchangeSP(){
  //  history.pushState(null, null, "Index.php?id=fixsp");
    modalSP.classList.add('open')
}

// Hàm ẩn
function closeformchangeSP(){
   // history.pushState(null, null, "Index.php?id=qlsp");
    modalSP.classList.remove('open')
}

// Lặp qua từng thẻ button và nghe hành vi click
for( const fixSPBtn of fixSPBtns) {
    fixSPBtn.addEventListener('click', showformchangeSP)
}

// Nghe hành vi click
modalcloseSP.addEventListener('click', closeformchangeSP)

modalSP.addEventListener('click', closeformchangeSP)

// Bấm vào bên trong không bị out
modalcontainerSP.addEventListener('click', function (event) {
    event.stopPropagation()
})

// // Lấy tất cả các nút sửa trên bảng
var editButtons = document.querySelectorAll(".js-change-sanpham");

// // Đăng ký sự kiện click cho từng nút sửa
editButtons.forEach(function(button) {
button.addEventListener("click", function() {
//     const id_product = button.getAttribute('value'); // Lấy giá trị của thuộc tính value trong phần tử button
//     console.log(id_product);
    // var confirmed = confirm("Bạn có chắc muốn xóa sản phẩm #" + id_product + "?");
    // if (confirmed) {
    //     // Gửi yêu cầu xóa đến PHP
    //         window.location.href = "update.php?id_product=" + id_product;
    // }

    var row = this.parentNode.parentNode;

//     // Lấy tất cả các ô (cell) trong hàng hiện tại và lưu chúng vào một mảng (array)
    var cells = row.getElementsByTagName("td");

//     // // Đặt giá trị của mỗi ô trong mảng vào các trường (input) tương ứng trên form
//     // document.getElementById("name_product").value = cells[1].textContent;
//     // document.getElementById("code").value = cells[2].textContent;
//     // // document.getElementById("img").value = cells[3].getElementsByTagName("img")[0].getAttribute("src");
//     // // document.getElementById("price").value = cells[4].textContent;
//     // document.getElementById("quantity").value = cells[5].textContent;
  //  document.getElementById("name_wire").value = cells[6].textContent;
   // document.getElementById("name_glass").value = cells[7].textContent;
   // document.getElementById("name_pin").value = cells[8].textContent;
//     // document.getElementById("color").value = cells[9].textContent;
//     // document.getElementById("size").value = cells[10].textContent;
   // document.getElementById("name_brand").value = cells[11].textContent;
//     // document.getElementById("origin").value = cells[12].textContent;

    var select = document.getElementById("name_wire");
    var valueToSelect = cells[6].textContent;
    for(var i=0; i<select.options.length; i++) {
        if(select.options[i].text === valueToSelect) {
            select.selectedIndex = i;
            break;
        }
    }   

    var select1 = document.getElementById("name_glass");
    var valueToSelect1 = cells[7].textContent;
    for(var i=0; i<select1.options.length; i++) {
        if(select1.options[i].text === valueToSelect1) {
            select1.selectedIndex = i;
            break;
        }
    }  

    var select2 = document.getElementById("name_pin");
    var valueToSelect2 = cells[8].textContent;
    for(var i=0; i<select2.options.length; i++) {
        if(select2.options[i].text === valueToSelect2) {
            select2.selectedIndex = i;
            break;
        }
    }  

    var select3 = document.getElementById("name_brand");
    var valueToSelect3 = cells[11].textContent;
    for(var i=0; i<select3.options.length; i++) {
        if(select3.options[i].text === valueToSelect3) {
            select3.selectedIndex = i;
            break;
        }
    }  
    
var select = document.getElementById("name_category");
var valueToSelect = cells[12].textContent;
for(var i=0; i<select.options.length; i++) {
    if(select.options[i].text === valueToSelect) {
        select.selectedIndex = i;
        break;
    }
}  



//     // Hiển thị form
//     // document.getElementById("myForm").style.display = "block";
  });
});

