$(".user-img").on('click',function(){
    $(".book-ul").empty();
    $(".book-ul").css("background-image",null); 
    $("category-ul").empty();
    var url = '/BMS/book/bookinfo';
    var dataMessage = {current : "1",startTime : "2011-4-29",endTime: "2017-5-10",keyWord:""};
    $.post(url,dataMessage,function(data){
        if ($.isEmptyObject(data.listBookCustom)) {
            $(".book-ul").css("background-image","url(/BMS/static//img/jocker.png)"); 
        } else {
            $.each(data.listBookCustom,function(i,n){
                $(".book-ul").append(
                    "<li id= "+n.bookid+"> " +
                    "<span class='book-order'>"+[i+1]+"</span>" +
                    "<img src='/BMS/pic/"+n.bookpicpath+"' class='img-rounded'>"+
                    "<span class='book-name'>"+n.bookname +"</span>"+
                    "<span class='book-autor'>"+n.bookauthor+"</span>"+
                    "<span class='book-publish'>"+n.bookauthor+"</span>"+
                    "<span class='book-number'>"+n.booknumber+"</span>"+
                    "<button type='button' class='btn btn-info book-info-ul' data-toggle='modal' data-target='.book-more-info'>Info</button>"+
                    "<button type='button' class='btn btn-danger'>Borrow</button>" +
                    "</li>"
                );
            });
            $(".book-info-ul").on('click',function(){
                alert(1);
                alert(1);
                alert(1);
            });
        }
        $.each(data.listCategoryCustom,function(i,n){
            $(".category-ul").append(
                "<li>"+n.categoryname+"</li>"
            );
        });
    });
});
function aa(){
    alert(1);
}


function pageSet(){
    $("pageset-ul").append();
}