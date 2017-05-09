function removechangecolor(){
    $("li").removeClass("changecolor");
}
$(".iconthlist").on("click",function(){
    removechangecolor();
    $(this).addClass("changecolor");
    $("#book-info").hide();
    $("#borrow-history-info").hide();
    $("#user-info").hide();
    $("#borrow-info").show();
});