function userNameValid(e) {
    var element = e.target;
    if(element.nextElementSibling !== null) {
        element.nextElementSibling.remove();
    }
    if(element.value.length >= 6 && element.value.length <= 12) {
        let div = document.createElement("div");
        div.innerText = "올바른 아이디 값 입니다.";
        div.style.color = "green";
        element.after(div);
        element.style.borderColor = "green";
        element.setAttribute("is-valid", true);
    } else {
        let div = document.createElement("div");
        div.innerText = "아이디는 6 ~ 12 자를 입력해야 합니다.";
        div.style.color = "red";
        element.after(div);
        element.style.borderColor = "red";
        element.setAttribute("is-valid", false);
    }
}

function passwordValid(e) {
    var element = e.target;
    if(element.nextElementSibling !== null) {
        element.nextElementSibling.remove();
    }
    if(element.value.length >= 4 && element.value.length <= 12) {
        let div = document.createElement("div");
        div.innerText = "올바른 패스워드 값 입니다.";
        div.style.color = "green";
        element.after(div);
        element.style.borderColor = "green";
        element.setAttribute("is-valid", true);
    } else {
        let div = document.createElement("div");
        div.innerText = "패스워드는 4 ~ 12 자를 입력해야 합니다.";
        div.style.color = "red";
        element.after(div);
        element.style.borderColor = "red";
        element.setAttribute("is-valid", false);
    }
}

function passwordCheckValid(e, other) {
    var element = e.target;
    if(element.nextElementSibling !== null) {
        element.nextElementSibling.remove();
    }
    if(element.value !== other.value) {
        let div = document.createElement("div");
        div.innerText = "패스워드가 일치하지 않습니다.";
        div.style.color = "red";
        element.after(div);
        element.style.borderColor = "red";
        element.setAttribute("is-valid", false);
    } else {
        let div = document.createElement("div");
        div.innerText = "패스워드가 일치합니다.";
        div.style.color = "green";
        element.after(div);
        element.style.borderColor = "green";
        element.setAttribute("is-valid", true);
    }
}

function validCheck(form) {
    var userNameValid = form.username.getAttribute("is-valid") === "true" ? true : false;
    var passwordValid = form.password.getAttribute("is-valid") === "true" ? true : false;
    var passwordCheckValid = form.passwordCheck.getAttribute("is-valid") === "true" ? true : false;

    if(userNameValid && passwordValid && passwordCheckValid) {
        return true;
    } else {
        return false;
    }
}

window.onload = function() {
    var form = document.forms[0];
    form.username.addEventListener("input", userNameValid);
    form.password.addEventListener("input", passwordValid);
    form.passwordCheck.addEventListener("input", function(e) { passwordCheckValid(e, form.password)});

    var div = document.getElementById("id_div");
    /* 표준 방식 */
    /* 여러개의 이벤트 함수만 등록하여 실행 가능하다. 등록된 순서대로 실행이 된다. */

    /*div.addEventListener("click", 메서드명);
    div.addEventListener("click", function(매개변수) {
        실행로직;
    });
    div.removeEventListener("click", 메서드명);*/

    /* 1개의 이벤트 함수만 등록하여 실행 가능하다 */
    var input = document.getElementById("id_input");
    /*input.onclick = function(매개변수) {
        실행로직;
    }*/

    var select = document.getElementById("id_select");
    
    /* 사용자가 입력창에 마우스 커서를 두고 클릭하면 이벤트가 활성화된다*/
    input.addEventListener("focus", function() {console.log("focus 이벤트 발생!");});
    //input.onfocus(function() {console.log("focus 이벤트 발생!!");});

    /* focus 사건이 발생된 이후에 사용자가 입력창에 마우스 커서를 빼고 클릭하면 이벤트가 활성화된다.*/
    input.addEventListener("blur", eventHandler);
    
    /* 사용자가 입력하고 있을때 이벤트가 발생된다 */
    input.addEventListener("input", eventHandler);
    
    div.addEventListener("mouseenter", eventHandler);
    input.addEventListener("mouseenter", eventHandler);

    div.addEventListener("mouseleave", eventHandler);
    input.addEventListener("mouseleave", eventHandler);
    
    input.addEventListener("click", function(x) {console.log(x.target);});
    div.addEventListener("click", function(e) {console.log(e.target);});

    input.addEventListener("dblclick", eventHandler);
    div.addEventListener("dblclick", eventHandler);

    /* 기존 값이 아닌 다른 값으로 변경되었을 때, 엔터를 누르면 발생되는 사건 */
    input.addEventListener("change", eventHandler);
    select.addEventListener("change",eventHandler);
}

function eventHandler(e) {
    switch(e.type) {
        case "click":
            console.log("클릭 이벤트 발생!!"); break;
        case "dblclick":
            console.log("더블 클릭 이벤트 발생!!"); break;
        case "focus":
            console.log("포커스 이벤트 발생!!"); break;
        case "blur":
            console.log("블러 이벤트 발생!!"); break;
        case "input":
            console.log("값 입력 이벤트 발생"); break;
        case "change":
            console.log("값 변경 이벤트 발생"); break;
        case "mouseenter":
            console.log("마우스엔터 이벤트 발생"); break;
        case "mouseleave":
            console.log("마우스리브 이벤트 발생"); break;
    }
    console.log(e.target);
}
