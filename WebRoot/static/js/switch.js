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
    $("#page-content").show();
    $("#borrow-info").show();
    showuserborrowbookinfo(1,"false");
});
$(".iconbook").on("click",function(){
    clearpage();
    removechangecolor();
    $(this).addClass("changecolor");
    $("#borrow-history-info").hide();
    $("#user-info").hide();
    $("#borrow-info").hide();
    $("#page-content").show();
    $("#book-info").show();
    showbookinfo(1);
});
$(".icontime").on("click",function(){
    clearpage();
    removechangecolor();
    $(this).addClass("changecolor");
    $("#page-content").show();
    $("#borrow-history-info").show();
    $("#user-info").hide();
    $("#borrow-info").hide();
    $("#book-info").hide();
    showuserborrowbookinfo(1,"true");
});
$(".iconuser").on("click",function(){
    clearpage();
    removechangecolor();
    $(this).addClass("changecolor");
    $("#page-content").hide();
    $("#user-info").show();
    $(".user-info-readonly").show();
    $(".user-update-password").hide();
    getuserinfo();
});
$(".iconpencil").on("click",function(){
    clearpage();
    removechangecolor();
    $(this).addClass("changecolor");
    $("#page-content").hide();
    $("#user-info").show();
    $(".user-info-readonly").hide();
    $(".user-update-password").show();
});
function clearpage(){
    $(".starttime").val("");
    $(".endtime").val("");
    $(".keyword").val("");
    $(".category-span").text("全部");
}
