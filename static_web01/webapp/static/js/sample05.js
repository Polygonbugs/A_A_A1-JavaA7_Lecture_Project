/*
    document.getElementsByTagName 등과 같은 메서드를 사용하여 특정 엘리먼트를 선택한 이후
    부모 관계, 형제 관계에 해당하는 엘리먼트에 접근하기 위한 방법
    
    자식에게 접근
        .getElementByTagName과 같은 메서드를 다시 사용하여 접근
        .firstElementChild / .lastElementChild 속성을 사용하여 접근
        
    부모에게 접근
        .parentElement 속성을 사용하여 접근
        
    형제에게 접근
        .previousElementSibling / .nextElementSibling 속성을 사용하여 접근
 */


function counting(element) {
    /* 조회수에 해당하는 값을 tr 태그 영역을 클릭할 때마다 +1 하도록 합니다.*/
    // console.log(element);
    var cnt = parseInt(element.lastElementChild.innerText);
    element.lastElementChild.innerText = cnt + 1;
}