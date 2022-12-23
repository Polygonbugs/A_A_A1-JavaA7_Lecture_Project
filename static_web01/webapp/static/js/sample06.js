/**
 * document.createElement("tagName") : 엘리먼트 객체 생성
 * 
 * 부모 엘리먼트를 기준으로 자식 엘리먼트로 추가
 *      부모.prepend(추가할 엘리먼트) : 첫번째 자식으로 추가
 *      부모.append(추가할 엘리먼트) : 마지막 자식으로 추가
 *      
 * 형제 엘리먼트를 기준으로 같은 형제 엘리먼트로 추가
 *      형제.before(추가할 엘리먼트) : 앞 형제로 추가
 *      형제.after(추가할 엘리먼트) : 뒤 형제로 추가
 */

function addItem(form) {
    /* 목록을 추가하는 함수*/
    var item = form.item.value;

    var li = document.createElement("li");
    li.innerText = item;

    var list = document.getElementById("list")
    list.append(li);

    form.item.value = "";

    if(form.loc.value === 'first') {
        list.prepend(li);
    } else if(form.loc.value === 'last') {
        list.append(li);
    }

    form.item.value = "";
    /* var item = element.previousElementSibling.value;

    var li = document.createElement("li");
    li.innerText = item;

    var list = document.getElementById("list");
    list.append(li);

    element.previousElementSibling.value = "";*/
}
function addRow() {
    /* 
        테이블에 행을 추가하는 함수로 한 행에는 5열이 들어간다.
        사용자 입력으로 제목과 작성자는 받을 수 있으며
        번호는 (전체 행수 + 1)이 설정되게 하고(tbody의 행수만.)
        작성일은 new Date() 객체를 사용하여 현재 날짜를 구하여 쓰며
        조회수는 기본 0으로 세팅한다.
    */

    var title = form.title.value;
    var writer = form.writer.value;
    var table = document.getElementById("table");
    var tbody = table.lastElementChild;
    var totalRow = tbody.children.length;
    var now = new Date();

    var tr = createTableRow(5);
    tr.children[0].innerText = totalRow + 1;
    tr.children[1].innerText = title;
    tr.children[2].innerText = writer;
    tr.children[3].innerText = [now.getFullYear(), (now.getMonth() + 1), now.getDate()].join("-");
    tr.children[4].innerText = 0;
    tbody.append(tr);

    var td = tr.firstElementChild;
}

function createTableRow(columnCount) {
    var row = document.createElement("tr");

    for(let idx = 0; idx < columnCount; idx++) {
        let column = document.createElement("td");
        row.append(column);
    }
    return row;
}
