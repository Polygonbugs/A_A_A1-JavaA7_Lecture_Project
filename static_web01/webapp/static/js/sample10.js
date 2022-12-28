$(document).ready(function() {
    console.log($);
})


function addBookmark(form) {
    //var url = $("form").children().eq(0).val();
    //var name = $("form").children().eq(1).val();
    var url = $(form.url).val();
    var name = $(form.name).val();
    
    var aTag = $("<a></a>").attr("href", url).text(name);
    var liTag = $("<li></li>");
    liTag.append(aTag);
    $(".bookmark-list").append(liTag);
    $(form).children("input").val("");
}