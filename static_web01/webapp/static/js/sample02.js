function createList(id) {
    var resultDiv = document.getElementById(id);
    var items = getListItems();

    /* items 배열에 있는 데이터를 사용하여 ul, li 태그 문자열로 만드는 로직 작성 */
    var ulTag = "<ul>";
    for(let item of items) {
        ulTag += "<li>" + item + "</li>"
    }
    ulTag += "</ul>"

    resultDiv.innerHTML = ulTag;
}

/* 프롬프트로 입력 받은 문자열을 배열로 만들어서 반환하는 함수 */
function getListItems() {
    var items = prompt("쉼표를 구분자로 하는 목록을 작성하세요.");
    return items.split(",");
}

/* 1월 ~ 12월 까지 생성합니다. 현재월이 select 태그에 초기 선택되어 나와야 합니다. */
function createMonth(id) {
    var selectTag = document.getElementById(id);
    var date = new Date();
    var currentMonth = date.getMonth();

    var optionTags = "";
    for(let m = 1; m <= 12; m++) {
        optionTags += m === currentMonth + 1 ? "<option selected>" : "<option>";
        optionTags += m + "월</option>";
    }

    selectTag.innerHTML = optionTags;
}