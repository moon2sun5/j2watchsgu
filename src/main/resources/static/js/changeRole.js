
const fixQuyenBtns = document.querySelectorAll('.js-change-role')
const modalQuyen = document.querySelector('.js-modalQuyen')
const modalcontainerQuyen = document.querySelector('.js-containerQuyen')
const modalcloseQuyen = document.querySelector('.js-close-Quyen')

// Hàm hiển thị
function showformchangeQuyen(){
    modalQuyen.classList.add('open')
}

// Hàm ẩn
function closeformchangeQuyen(){
    modalQuyen.classList.remove('open')
}

// Lặp qua từng thẻ button và nghe hành vi click
for( const fixQuyenBtn of fixQuyenBtns) {
    fixQuyenBtn.addEventListener('click', showformchangeQuyen)
}

// Nghe hành vi click
modalcloseQuyen.addEventListener('click', closeformchangeQuyen)

modalQuyen.addEventListener('click', closeformchangeQuyen)

// Bấm vào bên trong không bị out
modalcontainerQuyen.addEventListener('click', function (event) {
    event.stopPropagation()
})
    