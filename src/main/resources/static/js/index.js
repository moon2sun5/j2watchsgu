const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);


// //Slider
// imgChange = () => {
//     let index = 0;
//     let imgs = ["./assets/img/anhnen3.jpg", "./assets/img/slide2.jpg", "./assets/img/slide3.jpg"];
//     $('.d-block').src = imgs[index];
//     // $('.d-block').attr('src', imgs[index]);
//     index++;
//     if (index === 3) {
//         index = 0;
//     }
// }
// setInterval(imgChange, 2500);

//Modal
const $modal = $('.js-modal');
const loginBtn = $('.header__item-login');
const modalClose = $('.js-modal-close');
const modalContainer = $('.js-modal-container');
const modalCloseSub = $('.js-modal-login-close');
const loginMain = $('.modal-login-main');


function openModal() {
    $modal.style.display = 'block';
    loginMain.style.display = 'block';
    registerContainer.style.display = 'none';
}

function closeModal() {
    $modal.style.display = 'none';
}

loginBtn.onclick = function() { openModal() };

modalClose.onclick = function() { closeModal() };

/* $modal.addEventListener('click', closeModal); */

modalCloseSub.addEventListener('click', closeModal);

modalContainer.addEventListener('click', function(e) {
    e.stopPropagation();
    /*  e.preventDefault(); */
});

/* Handle modal */

const registerLink = $('.modal-register-link');
const registerContainer = $('.modal-register');
const loginLink = $('.login-link')
const parentForm = $('.modal-login');
registerLink.onclick = () => {
    registerContainer.style.display = 'block';
    /* loginMain.style.display = 'none'; */
    parentForm.removeChild(loginMain);
}

loginLink.onclick = () => {
    registerContainer.style.display = 'none';
    parentForm.appendChild(loginMain);
    /* loginMain.style.display = 'block'; */
}

/* Handle radio buttons */
const radioButtons = $$('.checked');
let selectedValue = null;

radioButtons.forEach((radio) => {
    radio.addEventListener('click', (e) => {
        if (selectedValue === e.target.value) {
            e.target.checked = false;
            selectedValue = null;
        } else {
            selectedValue = e.target.value;
            radioButtons.forEach((radio) => {
                radio.checked = (radio.value === selectedValue);
            });
        }
    });
});
/* Handle Check Input */
const fullName = $('.fullname');
const address = $('.address');
const phone = $('.phone-number');
const email = $('.email');
const username = $('.username');
const password = $('.pass');
const rePassword = $('.re-password');

const register = $('.register');
const textHide = $('.text-hide');
const oulineRed = $('.modal-format-inp');

function checkWhiteSpace(input, textHide, outline) {
    if (input.value === '' || input.value === null) {
        input.focus();
        textHide.style.display = 'block';
        outline.style.border = '1px solid red';
        input.addEventListener('blur', () => {
            textHide.style.display = 'none';
            outline.style.border = '1px solid rgb(174, 172, 172)'
        })
        return false;
    } else {
        textHide.style.display = 'none';
        outline.style.border = '1px solid rgb(174, 172, 172)'
        return true;
    }
}

function validateEmail(email) {
    const check = /^\S+@\S+\.\S+$/;
    return check.test(String(email).toLowerCase());
}

function validatePhoneNumber(phoneNumber) {
    var phoneNumberRegex = /^\d{10}$/;
    return phoneNumberRegex.test(phoneNumber);
}

function validateUsername(username) {
    const check = /^[a-zA-Z0-9_]{4,16}$/;
    return check.test(String(username).toLowerCase());
}

function validatePassword(password) {
    var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
    return passwordRegex.test(password);
}

function checkValid(input, textSubHide, outline, callback) {
    const handle = callback(input.value);
    if (!handle) {
        input.focus();
        textSubHide.style.display = 'block';
        outline.style.border = '1px solid red';
        input.addEventListener('blur', () => {
            textSubHide.style.display = 'none';
            outline.style.border = '1px solid rgb(174, 172, 172)'
        })
        return false;
    } else {
        textSubHide.style.display = 'none';
        outline.style.border = '1px solid rgb(174, 172, 172)'
        return true;
    }
}

function mappingPassword(pass, repass, textSubHide, outline) {
    if (repass.value !== pass.value) {
        repass.focus();
        textSubHide.style.display = 'block';
        outline.style.border = '1px solid red';
        repass.addEventListener('blur', () => {
            textSubHide.style.display = 'none';
            outline.style.border = '1px solid rgb(174, 172, 172)'
        })
        return false;
    } else {
        textSubHide.style.display = 'none';
        outline.style.border = '1px solid rgb(174, 172, 172)'
        return true;
    }
}

/* Submit Register */
function validInput() {
    const rePasswordHide = $('.re-password-hide');
    const rePasswordSubHide = $('.re-password-sub-hide');
    var valid = true;

    function checkMappingPassword() {
        if (checkWhiteSpace(rePassword, rePasswordHide, rePassword)) {
            if (!mappingPassword(password, rePassword, rePasswordSubHide, rePassword)) {
                valid = false;
            }
        }
    }
    checkMappingPassword();

    const passwordHide = $('.pass-hide');
    const passwordSubHide = $('.pass-sub-hide');

    function checkcharPassword() {
        if (checkWhiteSpace(password, passwordHide, password)) {
            if (!checkValid(password, passwordSubHide, password, validatePassword)) {
                valid = false;
            }
        }
    }
    checkcharPassword();

    const usernameHide = $('.username-hide');
    const usernameSubHide = $('.username-sub-hide');

    function checkcharUserName() {
        if (checkWhiteSpace(username, usernameHide, username)) {
            if (!checkValid(username, usernameSubHide, username, validateUsername)) {
                valid = false;
            }
        }
    }
    checkcharUserName();

    const emailHide = $('.email-hide');
    const emailSubHide = $('.email-sub-hide');

    function checkCharEmail() {
        if (checkWhiteSpace(email, emailHide, email)) {
            if (!checkValid(email, emailSubHide, email, validateEmail)) {
                valid = false;
            }
        }
    }
    checkCharEmail();

    const phoneHide = $('.phone-number-hide');
    const textPhoneSubHide = $('.phone-number-sub-hide');

    function checkPhone() {
        if (checkWhiteSpace(phone, phoneHide, phone)) {
            if (!checkValid(phone, textPhoneSubHide, phone, validatePhoneNumber)) {
                valid = false;
            }
        }
    }
    checkPhone();

    const addressHide = $('.address-hide');
    if (!checkWhiteSpace(address, addressHide, address)) {
        valid = false;
    }

    const date = $('.date');
    const dateHide = $('.date-hide');
    if (!checkWhiteSpace(date, dateHide, date)) {
        valid = false;
    }

    const fullnameHide = $('.fullname-hide');
    if (!checkWhiteSpace(fullName, fullnameHide, fullName)) {
        valid = false;
    }

    return valid;
}





/* Handle cart */

var cartItemCount = 0; // khởi tạo giá trị ban đầu cho biến lưu trữ số lượng sản phẩm trong giỏ hàng

var addToCartButton = document.getElementById('add-to-cart-button'); // lấy tham chiếu đến nút thêm sản phẩm vào giỏ hàng
addToCartButton.addEventListener('click', function() {
    cartItemCount++; // tăng số lượng sản phẩm lên 1
    updateCartItemCount(); // cập nhật số lượng sản phẩm trên biểu tượng giỏ hàng
});

function updateCartItemCount() {
    var cartItemBadge = document.querySelector('.header__icon-item-cart'); // lấy tham chiếu đến biểu tượng giỏ hàng
    cartItemBadge.innerHTML = cartItemCount; // cập nhật số lượng sản phẩm trên biểu tượng giỏ hàng
}

/*  */
var priceRange = $('#category__price-range');

function showPriceRange(value) {
    $('#category__range-value').innerHTML = value + " đ";
}