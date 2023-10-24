
const fixNVBtns = document.querySelectorAll('.js-change-nhanvien')
const modal = document.querySelector('.js-modal')
const modalcontainer = document.querySelector('.js-container')
const modalclose = document.querySelector('.js-close')

// Hàm hiển thị
function showformchange(){
    modal.classList.add('open')
}

// Hàm ẩn
function closeformchange(){
    modal.classList.remove('open')
}

// Lặp qua từng thẻ button và nghe hành vi click
for( const fixNVBtn of fixNVBtns) {
    fixNVBtn.addEventListener('click', showformchange)
}

// Nghe hành vi click
modalclose.addEventListener('click', closeformchange)

modal.addEventListener('click', closeformchange)

// Bấm vào bên trong không bị out
modalcontainer.addEventListener('click', function (event) {
    event.stopPropagation()
})
    