$(document).ready(function() {
    console.log($);
    //$("form > button").on("이벤트명", 메서드)
    // 이벤트 등록
    // $("form > button").on("click", function(e) { addBookmark(e);});
    // 이벤트 삭제
    // $("form > button").off("click", function(e) { addBookmark(e);});
    // 한번만 동작하는 이벤트로 등록
    // $("form > button").one("click", addBookmark);
    // $("form > button").hover(mouseenter시 작동할 함수, mouseleave시 작동할 함수);
    /*
    $("ul a").hover(
        function(e) {
            var href = $(e.target).attr("href");
            var name = $(e.target).text();
            $("form [name=url]").val(href);
            $("form [name=name]").val(name);
        },
        function(e) {
            $("form [name=url]").val("");
            $("form [name=name]").val("");
        }
    );
    */
    $("form > button").on("click",
        function(e) {
            if($(e.target).attr("on") === "false") {
                $(e.target).css("border-color", "red");
                $(e.target).attr("on", "true");
            } else {
                $(e.target).removeAttr("style");
                $(e.target).attr("on", "false");
            }
        });
});


function addBookmark(event) {
    //var url = $("form").children().eq(0).val();
    //var name = $("form").children().eq(1).val();
    var url = $(event.target.form.url).val();
    var name = $(event.target.form.name).val();
    
    var aTag = $("<a></a>").attr("href", url).text(name);
    var liTag = $("<li></li>");
    liTag.append(aTag);
    $(".bookmark-list").append(liTag);
    $(event.target.form).children("input").val("");
}