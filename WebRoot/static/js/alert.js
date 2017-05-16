function overlay_hide(){
    $(".overlay ").hide();
};
function overlay_show(){
    $(".overlay ").show();
}
function is_hide(){
    $(".alert").animate({"top":"-40%"}, 300); 
};
function is_show(){
    $(".alert").show().animate({"top":"45%"}, 300); 
};
function borrow_show(){
    $(".alert").show().animate({"top":"30%"}, 300); 
};
$(".btnalert").on("click",function(){
    overlay_hide();
    is_hide();
});
$(".btnborrowalert").on("click",function(){
    overlay_hide();
    is_hide();
    if(!$("#book-info").is(":hidden")){
        showbookinfo($(".active").attr("id"));
    }
    if(!$("#borrow-info").is(":hidden")){
        showuserborrowbookinfo($(".active").attr("id"),"false");
    }
    if(!$("#borrow-history-info").is(":hidden")){
        showuserborrowbookinfo($(".active").attr("id"),"true");
    }
});
function errormsg(msg){
    borrow_show();
    $(".alert h2").css("background-color","#c9302c");
    $("#ts").html(msg)
}