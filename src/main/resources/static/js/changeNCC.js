
const fixNCCBtns = document.querySelectorAll('.js-change-nhacungcap')
const modalNCC = document.querySelector('.js-modalNCC')
const modalcontainerNCC = document.querySelector('.js-containerNCC')
const modalcloseNCC = document.querySelector('.js-close-NCC')

// Hàm hiển thị
function showformchangeNCC(){
    modalNCC.classList.add('open')
}

// Hàm ẩn
function closeformchangeNCC(){
    modalNCC.classList.remove('open')
}

// Lặp qua từng thẻ button và nghe hành vi click
for( const fixNCCBtn of fixNCCBtns) {
    fixNCCBtn.addEventListener('click', showformchangeNCC)
}

// Nghe hành vi click
modalcloseNCC.addEventListener('click', closeformchangeNCC)

modalNCC.addEventListener('click', closeformchangeNCC)

// Bấm vào bên trong không bị out
modalcontainerNCC.addEventListener('click', function (event) {
    event.stopPropagation()
})
    