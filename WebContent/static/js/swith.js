function removechangecolor(){
    $("li").removeClass("changecolor");
}
$(".iconthlist").on("click",function(){
    removechangecolor();
    $("#book-info").css("dispaly","none");
    $("#borrow-info").css("dispaly","block");
});