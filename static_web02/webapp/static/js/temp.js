$(document).ready(function() {
    $(".list-group").eq(0).find(".list-group-item").on("click", sideMenuActive);
    $(".pagination").find(".page-item").on("click", pagingActive);
});

function sideMenuActive(event) {
    $(event.target).siblings(".active").removeClass("active");
    $(event.target).addClass("active");
    $("section h4").text($(event.target).text());
}

function pagingActive(event) {
    if(event.currentTarget == $(event.currentTarget).parent().children()[0]) {
        let active = $(event.currentTarget).siblings(".active");
        if(event.currentTarget != active.prev()[0]) {
            active.prev().addClass("active");
            active.removeClass("active");
        }
    } else if(event.currentTarget == $(event.currentTarget).parent().children().last()[0]) {
        let active = $(event.currentTarget).siblings(".active");
        if(event.currentTarget != active.next()[0]) {
            active.next().addClass("active");
            active.removeClass("active");
        }
    } else {
        $(event.currentTarget).siblings(".active").removeClass("active");
        $(event.currentTarget).addClass("active");
    }
}