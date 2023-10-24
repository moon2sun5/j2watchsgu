
const fixVCBtns = document.querySelectorAll('.js-change-voucher')
const modalVC = document.querySelector('.js-modalVC')
const modalcontainerVC = document.querySelector('.js-containerVC')
const modalcloseVC = document.querySelector('.js-close-VC')

// Hàm hiển thị
function showformchangeVC(){
    modalVC.classList.add('open')
}

// Hàm ẩn
function closeformchangeVC(){
    modalVC.classList.remove('open')
}

// Lặp qua từng thẻ button và nghe hành vi click
for( const fixVCBtn of fixVCBtns) {
    fixVCBtn.addEventListener('click', showformchangeVC)
}

// Nghe hành vi click
modalcloseVC.addEventListener('click', closeformchangeVC)

modalVC.addEventListener('click', closeformchangeVC)

// Bấm vào bên trong không bị out
modalcontainerVC.addEventListener('click', function (event) {
    event.stopPropagation()
})
    