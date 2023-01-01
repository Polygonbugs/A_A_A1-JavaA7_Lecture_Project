$(document).ready(function() {
    $("span").each(function(index, element) {
        if($(element).text() === "up") {
            $(element).on("click", up);
        } else if($(element).text() === "down") {
            $(element).on("click", down);
        }
    })
});

function up(event) {
    $(event.target).parent().prev().before($(event.target).parent());
}

function down(event) {
    $(event.target).parent().next().after($(event.target).parent());
}