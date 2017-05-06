$(function(){
    showbookinfo();
});
function showbookinfo(){
    $(".book-ul").empty();
    $(".category-ul").empty();
    $(".book-ul").css("background-image","url()"); 
    var url = '/BMS/book/bookinfo';
    var dataMessage = {current : $(".active-span").text(),startTime : $(".starttime").val(),endTime: $(".endtime").val(),keyWord: $(".keyword").val(),category:$(".category-span").text()};
    $.post(url,dataMessage,function(data){
        pageSet(data.pageSetVo.currentpage,data.pageSetVo.pagecount);
        if ($.isEmptyObject(data.listBookCustom)) {
            $(".book-ul").css("background-image","url(/BMS/static/img/jocker.png)"); 
        } else {
            $.each(data.listBookCustom,function(i,n){
                $(".book-ul").append(
                    "<li>" +
                    "<span class='book-order'>"+[i+1]+"</span>" +
                    "<img src='/BMS/pic/"+n.bookpicpath+"' class='img-rounded'>"+
                    "<span class='book-name'>"+n.bookname +"</span>"+
                    "<span class='book-autor'>"+n.bookauthor+"</span>"+
                    "<span class='book-publish'>"+n.bookauthor+"</span>"+
                    "<span class='book-number'>"+n.booknumber+"</span>"+
                    "<button type='button' class='btn btn-info book-info-ul' id="+n.bookid+" data-toggle='modal' data-target='.book-more-info'>Info</button>"+
                    "<button type='button' class='btn btn-danger'>Borrow</button>" +
                    "</li>"
                );
            });
            $(".book-info-ul").on('click',function(){
                $(".bookmodal-info-ul").empty();
                var url = "/BMS/book/detail";
                var dataMessage = {bookid : $(this).attr("id")}; 
                $.post(url,dataMessage,function(data){
                    $(".bookmodal-info-ul").append(
                           "<li><span>书名:</span><span>" + data.bookname + "</span></li>"+
                           "<li><span>作者:</span><span>" + data.bookauthor + "</span></li>"+
                           "<li><span>分类:</span><span>" + data.categoryname + "</span></li>"+
                           "<li><span>出版社:</span><span>" + data.bookpress + "</span></li>"+
                           "<li><span>发行时间:</span><span>" + formatedate(data.publisheddate) + "</span></li>"+
                           "<li><span>入馆时间:</span><span>" + formatedate(data.bookentertime) + "</span></li>"+
                           "<li><span>书籍位置:</span><span>" + data.bookaddress + "</span></li>"+
                           "<li><span>书籍介绍:</span><span>" + data.bookintroduction + "</span></li>"
                    );
                });
            });
        }
        $.each(data.listCategoryCustom,function(i,n){
            $(".category-ul").append(
                "<li>"+n.categoryname+"</li>"
            );
        });
    });
    
}

$(".icon-search").click(function(){
    showbookinfo();
});
$(".logout").click(function(){
    location.href = "/BMS/user/logout"
});

function pageSet(currentpage, pagecount){
    $(".pageset-ul").append("<li id='1'><span>首页</span></li>" +
    "<li><span>上一页</span></li>");
    if(pagecount < 5) {
        for(var i = 1; i <= pagecount; i++){
            if (currentpage == i){
                $(".pageset-ul").append("<li id='"+ i +"'  class='active'><span>"+ i +"</span></li>");
            } else {
                $(".pageset-ul").append("<li id='"+ i +"'><span>"+ i +"</span></li>");
            }
        }
    }
    $(".pageset-ul").append("<li><span>下一页</span></li>" +
    "<li id = '" + pagecount + "'><span>尾页</span></li>");
    
}
function formatedate(todate) {
    date = new Date(todate);
    var datetime = date.getFullYear()
            + "-"// "年"
            + ((date.getMonth() + 1) > 10 ? (date.getMonth() + 1) : "0"
                    + (date.getMonth() + 1))
            + "-"// "月"
            + (date.getDate() < 10 ? "0" + date.getDate() : date
                    .getDate());
    return datetime;
};