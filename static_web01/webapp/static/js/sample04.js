function validForm() {
    /*
        패스워드가 동일하면 서버에 전송을 허용하고
        동일하지 않으면 전송하지 못하게 한다.
        만약, 패스워드가 동일하지 않아서 서버에 전송을
        하지 못하는 경우에는 해당 이유를 폼 화면에 출력하도록 한다.
    */
    var form = document.forms[0];
    var pass1 = form.password.value;
    var pass2 = form.passwordCheck.value;

    if(pass1 !== pass2) {
        form.passwordCheck.value = "";
        document.getElementById("passwordCheckError").innerText = "패스워드가 일치하지 않습니다. 다시 확인하세요."
        return false; // 전송하지 않음
    }
}