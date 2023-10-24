
const fixDHBtns = document.querySelectorAll('.js-change-donhang')
const modalDH = document.querySelector('.js-modalDH')
const modalcontainerDH = document.querySelector('.js-containerDH')
const modalcloseDH = document.querySelector('.js-close-DH')

// Hàm hiển thị
function showformchangeDH(){
    modalDH.classList.add('open')
}

// Hàm ẩn
function closeformchangeDH(){
    modalDH.classList.remove('open')
}

// Lặp qua từng thẻ button và nghe hành vi click
for( const fixDHBtn of fixDHBtns) {
    fixDHBtn.addEventListener('click', showformchangeDH)
}

// Nghe hành vi click
modalcloseDH.addEventListener('click', closeformchangeDH)

modalDH.addEventListener('click', closeformchangeDH)

// Bấm vào bên trong không bị out
modalcontainerDH.addEventListener('click', function (event) {
    event.stopPropagation()
})
    