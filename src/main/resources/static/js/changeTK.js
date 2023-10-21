
const fixTKBtns = document.querySelectorAll('.js-change-taikhoan')
const modalTK = document.querySelector('.js-modalTK')
const modalcontainerTK = document.querySelector('.js-containerTK')
const modalcloseTK = document.querySelector('.js-close-TK')

// Hàm hiển thị
function showformchangeTK(){
    modalTK.classList.add('open')
}

// Hàm ẩn
function closeformchangeTK(){
    modalTK.classList.remove('open')
}

// Lặp qua từng thẻ button và nghe hành vi click
for( const fixTKBtn of fixTKBtns) {
    fixTKBtn.addEventListener('click', showformchangeTK)
}

// Nghe hành vi click
modalcloseTK.addEventListener('click', closeformchangeTK)

modalTK.addEventListener('click', closeformchangeTK)

// Bấm vào bên trong không bị out
modalcontainerTK.addEventListener('click', function (event) {
    event.stopPropagation()
})
    