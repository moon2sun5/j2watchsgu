
const fixHDBtns = document.querySelectorAll('.js-change-hoadon')
const modalHD = document.querySelector('.js-modalHD')
const modalcontainerHD = document.querySelector('.js-containerHD')
const modalcloseHD = document.querySelector('.js-close-HD')

// Hàm hiển thị
function showformchangeHD(){
    modalHD.classList.add('open')
}

// Hàm ẩn
function closeformchangeHD(){
    modalHD.classList.remove('open')
}

// Lặp qua từng thẻ button và nghe hành vi click
for( const fixHDBtn of fixHDBtns) {
    fixHDBtn.addEventListener('click', showformchangeHD)
}

// Nghe hành vi click
modalcloseHD.addEventListener('click', closeformchangeHD)

modalHD.addEventListener('click', closeformchangeHD)

// Bấm vào bên trong không bị out
modalcontainerHD.addEventListener('click', function (event) {
    event.stopPropagation()
})

var editButtons = document.querySelectorAll(".js-change-hoadon");

// // Đăng ký sự kiện click cho từng nút sửa
editButtons.forEach(function(button) {
button.addEventListener("click", function() {
    var row = this.parentNode.parentNode;
var cells = row.getElementsByTagName("td");

    var select = document.getElementById("name_product");
    var valueToSelect = cells[6].textContent;
    for(var i=0; i<select.options.length; i++) {
        if(select.options[i].text === valueToSelect) {
            select.selectedIndex = i;
            break;
        }
    }   
});
});