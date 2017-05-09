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
    showbookinfo($(".active").attr("id"));
});