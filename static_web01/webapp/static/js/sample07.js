/**
 * 아이디, 패스워드를 검사후 오류가 발생하는 경우
 * 사용자 입력 폼에 에러 메시지가 담긴 span 태그
 * 를 추가하고 입력 양식에는 테두리를 붉게 설정하여
 * 사용자가 잘못된 입력이라는 것을 알 수 있게 하세요.
 *
 * 아이디는 6자리 미만인 경우 오류가 발생하게 합니다.
 * 패스워드는 패스워드와 패스워드 확인이 동일하지 않을 때
 * 오류가 발생하게 합니다.
 * 패스워드도 4자리 미만인 경우 오류가 발생하게 합니다.
 */
function validCheck(form) {
    var isValid = true;
    if(form.username.value.length < 6) {
        var error = createErrorMessage("아이디는 6자리 이상 이어야 합니다.");
        form.username.after(error);
        errorInput(form.username);
        isValid = false;
    }
    if(form.password.value.length < 4) {
        var error = createErrorMessage("패스워드는 4자리 이상 이어야 합니다.");
        form.password.after(error);
        errorInput(form.password);
        isValid = false;
    }
    if(form.password.value !== form.passwordCheck.value) {
        var error = createErrorMessage("패스워드를 다시 확인하세요.")
        form.passwordCheck.after(error);
        errorInput(form.passwordCheck);
        isValid = false;
    }
    return isValid;
}
function errorInput(element) {
    element.value = "";
    /* element.style.borderColor = "red"; */
    /* element.style.borderStyle = "solid"; */
    element.classList.add("is-invalid");
}
function createErrorMessage(message) {
    var div = document.createElement("div");
    div.className = "invalid-feedback";
    div.innerText = message;
    return div;
}