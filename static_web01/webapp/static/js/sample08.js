var div = document.getElementById("id_div");
/* 표준 방식 */
/* 여러개의 이벤트 함수만 등록하여 실행 가능하다. 등록된 순서대로 실행이 된다. */
div.addEventListener("click", 메서드명);
div.addEventListener("click", function(매개변수) {
    실행로직;
});
div.removeEventListener("click", 메서드명);

/* 1개의 이벤트 함수만 등록하여 실행 가능하다 */
var input = document.getElementById("id_input");
input.onclick = function(매개변수) {
    실행로직;
}