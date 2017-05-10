function removechangecolor(){
    $("li").removeClass("changecolor");
}
$(".iconthlist").on("click",function(){
    clearpage();
    removechangecolor();
    $(this).addClass("changecolor");
    $("#book-info").hide();
    $("#borrow-history-info").hide();
    $("#user-info").hide();
    $("#borrow-info").show();
    showuserborrowbookinfo(1);
});
$(".iconbook").on("click",function(){
    clearpage();
    removechangecolor();
    $(this).addClass("changecolor");
    $("#borrow-history-info").hide();
    $("#user-info").hide();
    $("#borrow-info").hide();
    $("#book-info").show();
    showbookinfo(1);
});
function clearpage(){
    $(".starttime").val("");
    $(".endtime").val("");
    $(".keyword").val("");
    $(".category-span").text("全部");
    
}
