$(function(){
    showbookinfo(1);
    $(".iconbook").addClass("changecolor");
});
function showbookinfo(currentpage){
    $(".book-ul").empty();
    $(".category-ul").empty();
    $(".pagination").empty();
    $(".book-ul").css("background-image","url()"); 
    var url = '/BMS/book/bookinfo';
    var dataMessage = {current : currentpage,startTime : $(".starttime").val(),endTime: $(".endtime").val(),keyWord: $(".keyword").val(),category:$(".category-span").text()};
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
                    "<button type='button' class='btn btn-danger' id="+n.bookid+">Borrow</button>" +
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
        $(".btn-danger").on("click",function(){
            overlay_show()
            var url="/BMS/borrow/userBorrow";
            var dataMessage = {bookid : $(this).attr("id")};
            $.post(url,dataMessage,function(data){
                $("#ts").html(data.borrowinfo);
                borrow_show();
                if(data.borrowresult) {
                    $(".alert h2").css("background-color","#449d44")
                } else {
                    $(".alert h2").css("background-color","#c9302c")
                }
            });
        });
    });
    
}

$(".icon-search").click(function(){
    showbookinfo(1);
});
$(".logout").click(function(){
    location.href = "/BMS/user/logout"
});

function pageSet(currentpage, pagecount){
    $(".pageset-ul").append("<li id='1' class='firstpage oncurrentpage'><span>首页</span></li>" +
    "<li class='previous'><span>上一页</span></li>");
    if(pagecount <= 5) {
        for(var i = 1; i <= pagecount; i++){
            if (currentpage == i){
                $(".pageset-ul").append("<li id='"+ i +"' class='active'><span>"+ i +"</span></li>");
            } else {
                $(".pageset-ul").append("<li id='"+ i +"'><span>"+ i +"</span></li>");
            }
        }
    } else {
        if(currentpage <= 3){
            for(var i = 1; i <= 5; i++){
                if (currentpage == i){
                    $(".pageset-ul").append("<li id='"+ i +"'  class='active'><span>"+ i +"</span></li>");
                } else {
                    $(".pageset-ul").append("<li id='"+ i +"' class = 'oncurrentpage'><span>"+ i +"</span></li>");
                }
            }
        } else if(currentpage > (pagecount-2)) {
            for(var i = 4; i >= 0; i--){
                if (currentpage == (pagecount-i)){
                    $(".pageset-ul").append("<li id='"+ (pagecount-i) +"' class='active'><span>"+ (pagecount-i) +"</span></li>");
                } else {
                    $(".pageset-ul").append("<li id='"+ (pagecount-i) +"' class = 'oncurrentpage'><span>"+ (pagecount-i) +"</span></li>");
                }
            }
        } else {
            $(".pageset-ul").append("<li id='"+ (currentpage-2) +"' class = 'oncurrentpage'><span>"+ (currentpage-2) +"</span></li>" +
                    "<li id='"+ (currentpage-1) +"' class = 'oncurrentpage'><span>"+ (currentpage-1) +"</span></li>" + 
                    "<li id='"+ currentpage +"' class='active'><span>"+ currentpage +"</span></li>" +
                    "<li id='"+ (currentpage+1) +"' class = 'oncurrentpage'><span>"+ (currentpage+1) +"</span></li>" +
                    "<li id='"+ (currentpage+2) +"' class = 'oncurrentpage'><span>"+ (currentpage+2) +"</span></li>");
        }
    }
    $(".pageset-ul").append("<li class='nextpage'><span>下一页</span></li>" +
    "<li id = '" + pagecount + "' class='endpage oncurrentpage'><span>尾页</span></li>");
    if(currentpage != 1){
        $(".previous").on("click",function(){
            showbookinfo(parseInt($(".active").attr("id")) - 1);
        });
    }
    if(currentpage != pagecount){
        $(".nextpage").on("click",function(){
            showbookinfo(parseInt($(".active").attr("id")) + 1);
        });
    }
    if(currentpage == 1 || pagecount == 0) {
        $(".firstpage").addClass("disabled");
        $(".previous").addClass("disabled");
    }
    if(currentpage == pagecount){
        $(".endpage").addClass("disabled");
        $(".nextpage").addClass("disabled");
    }
    $(".oncurrentpage").on("click",function(){
        showbookinfo($(this).attr("id"));
    });
    
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