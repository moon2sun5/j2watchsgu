
const fixLoginBtns = document.querySelectorAll('.js-change-Login')
const modalLogin = document.querySelector('.js-modalLogin')
const modalcontainerLogin = document.querySelector('.js-containerLogin')
const modalcloseLogin = document.querySelector('.js-close-Login')

// Hàm hiển thị
function showformchangeLogin(){
    modalLogin.classList.add('open')
}

// Hàm ẩn
function closeformchangeLogin(){
    modalLogin.classList.remove('open')
}

// Lặp qua từng thẻ button và nghe hành vi click
for( const fixLoginBtn of fixLoginBtns) {
    fixLoginBtn.addEventListener('click', showformchangeLogin)
}

// Nghe hành vi click
modalcloseLogin.addEventListener('click', closeformchangeLogin)

modalLogin.addEventListener('click', closeformchangeLogin)

// Bấm vào bên trong không bị out
modalcontainerLogin.addEventListener('click', function (event) {
    event.stopPropagation()
})

const fixRegisterBtns = document.querySelectorAll('.js-change-Register')
const modalRegister = document.querySelector('.js-modalRegister')
const modalcontainerRegister = document.querySelector('.js-containerRegister')
const modalcloseRegister = document.querySelector('.js-close-Register')

// Hàm hiển thị
function showformchangeRegister(){
    modalRegister.classList.add('open')
    modalLogin.classList.remove('open')
}

// Hàm ẩn
function closeformchangeRegister(){
    modalRegister.classList.remove('open')
}

// Lặp qua từng thẻ button và nghe hành vi click
for( const fixRegisterBtn of fixRegisterBtns) {
    fixRegisterBtn.addEventListener('click', showformchangeRegister)
}

// Nghe hành vi click
modalcloseRegister.addEventListener('click', closeformchangeRegister)

modalRegister.addEventListener('click', closeformchangeRegister)

// Bấm vào bên trong không bị out
modalcontainerRegister.addEventListener('click', function (event) {
    event.stopPropagation()
})