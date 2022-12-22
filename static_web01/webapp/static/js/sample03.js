/*
    "DOM(Document Object Model)"
        id 속성의 값을 사용하여 엘리먼트 선택      --> document.getElementById (1개 element)
        name 속성의 값을 사용하여 엘리먼트 선택    --> document.getElementsByName (0개 이상)
        태그명을 사용하여 엘리먼트 선택            --> document.getElementsByTagName (0개 이상)
        class 속성의 값을 사용하여 엘리먼트 선택   --> document.getElementsByClassName (0개 이상)
        
        CSS의 선택자를 활용하여 1개의 엘리먼트 선택   -> document.querySelector
        CSS의 선택자를 활용하여 여러개의 엘리먼트 선택 -> document.querySelectorAll
 */

function changeUpper() {
    // var listItems = document.getElementsByClassName("menu-item");
    var listItems = document.querySelectorAll(".menu-item");
    
    for(let item of listItems) {
        item.innerText = item.innerText.toUpperCase();
    }
}