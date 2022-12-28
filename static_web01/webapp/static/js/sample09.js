window.onload = function() {
    form = document.forms[0];
    createMonthOption();
    form.username.addEventListener("blur", function(e) { requiredValid(e); });
    form.username.addEventListener("change", function(e) { lengthValid(e, 5, 20); });
    form.password[0].addEventListener("blur", function(e) { requiredValid(e); });
    form.password[0].addEventListener("change", function(e) { lengthValid(e, 8, 16); });
    form.password[1].addEventListener("blur", function(e) { requiredValid(e); });
    form.password[1].addEventListener("change", function(e) { lengthValid(e, 8, 16); });
};

function createAuthNumber() {
    var num = (Math.random() * 9000 + 1000).toFixed(0);
    alert(num);
    form.authNumber.disabled = false;
    form.authNumber.addEventListener("change", function (e) {
        if(e.target.value == num) {
            alert("인증 번호가 일치 합니다.");
            form.submitButton.disabled = false;
        } else {
            alert("인증 번호가 일치하지 않습니다.");
        }
    });
}

function createMonthOption() {
    for(let m = 1; m <= 12; m++) {
        let option = document.createElement("option");
        option.innerText = m + "월";
        option.value = m;
        form.month.append(option);
    }
}

function requiredValid(event) {
    var inputElement = event.target;
    if(inputElement.value === "") {
        errorMessage(inputElement, "필수 입력 입니다.");
    }
}

function lengthValid(event, min, max) {
    var inputElement = event.target;
    if(inputElement.value.length < min || inputElement.value.length > max) {
        errorMessage(inputElement, min + "~" + max + "자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
    } else {
        validMessage(inputElement, "정상입니다.");
    }
}

function errorMessage(element, message) {
    var divError = document.createElement("div");
    if(element.parentElement.lastElementChild.classList.contains("invalid-feedback") ||
        element.parentElement.lastElementChild.classList.contains("valid-feedback")) {
        divError = element.parentElement.lastElementChild;
    }
    divError.innerText = message;
    divError.className = "invalid-feedback";
    element.parentElement.append(divError);
    element.classList.remove("is-valid");
    element.classList.add("is-invalid");
}

function validMessage(element, message) {
    var divValid = document.createElement("div");
    if(element.parentElement.lastElementChild.classList.contains("invalid-feedback") ||
        element.parentElement.lastElementChild.classList.contains("valid-feedback")) {
        divValid = element.parentElement.lastElementChild;
    }
    divValid.innerText = message;
    divValid.className = "valid-feedback";
    element.parentElement.append(divValid);
    element.classList.remove("is-invalid");
    element.classList.add("is-valid");
}