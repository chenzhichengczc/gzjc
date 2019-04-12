$(function () {
    getCatalogy();
})

function getCatalogy() {
    $.ajax({
        type: "GET",
        url: "../information/getCatalogy",
        dataType: "json",
        success: function(json){
            for (var i = 0 ; i<json.data.length; i++){

                //$("[data-id = "+i+"]").addClass("text-primary").css("font-weight","bold")
                console.log(json.data[i].id);
                var $dataList = $("<div class='js_columnWrapper areaH--60 noWrap  noWhite' style='float:left'><a class='js_columnSlide inline style--categoryA align_center' data-id = "+(i+1)+" href='javacript:void(0)' id='c"+(i+1)+"' onclick=selectCatalogy("+json.data[i].id+")  style='width: 107.5px;'>"+json.data[i].typeName+"</a></div>");

                $("#mu-service").before($dataList);
            }
            var categoryId = 0;
            getDate(categoryId);
        }
    })
}



function selectCatalogy(categoryId){

    console.log("fasd");
    $('.block').remove();
    getDate(categoryId);
}

/*
$("#c7").click(function () {

});
*/

function getDate(categoryId) {
    var url = "../information/paging"
    var page = 1;

    $.ajax({
        type: "GET",
        data: {pageNum: 1,categoryId:categoryId},
        url: url,
        dataType: "json",
        success: function (json) {
            var pageInfo = json.data;
            page = pageInfo.pageNum;
            /* for(var j=0; j<json.data.list.length; j++){
                 var $dataList = $("<a class='js_columnSlide inline style--categoryA align_center' data-id = "+(j+1)+" href='javacript:void(0)' id='c"+(j+1)+"'  style='width: 107.5px;'>"+json.data.list[i].typeName+"</a>");
                 $("[data-id="+i+"]").after($dataList);
             }*/
            for (var i = 0; i < pageInfo.list.length; i++) {
                var info = pageInfo.list[i];
                var $a_data = $("<a class='P--30 h--150 borderB--f5f5f5 block' href='http://www.donews.com/news/detail/1/3040375.html' id='L" + (i + 1) + "'>" +
                    "<div class='MR--20 fl h--full style--imgArea  relative'>" +
                    "<img class='' h--full absolute pos--center' src='../assets/images/zixuntu.jpg' style='max-width: inherit;' alt='zixuntu'> </div>" +
                    "<div class=''><div class='MB--10 FS--16'><span class='inline BC--ffa200 MR--10 PLR--10 radius4 PTB--2 fl'>" + info.informationEntity.typeName + "</span>" +
                    "<p class='style--textOver color--333333 PTB--2'>" + info.brief + "</p></div><div class='MB--10 FS--12 color--999999'>" +
                    "<div class='inline MR--70 style--middleArea'><span>" + info.createTime + "</span></div><div class='inline style--middleArea'>" +
                    "点击量： <span class='style--textOver w--200'>" + info.click + "</span></div></div><p class='js_text style--twoLine color--999999 FS--14 MB--20 h--14--twoLine' id='thirtyfive'>" + info.text + "</p></div></a>");

                $('.M-box').before($a_data);
            }
            $('.M-box').pagination({
                pageCount: json.data.pages,   //总页码ajax中的pages总页
                coping: true,                 //是否开启首页和末页
                jump: true,                   //是否开启跳页
                homePage: '首页',
                endPage: '末页',
                prevContent: '上页',
                nextContent: '下页',
                current: page,                    //当前页码
                callback: function (api) {     //这是一个回调函数
                    for (var j = 1; j < 8; j++) {
                        $("#L" + j).remove();
                    }
                    console.log("api" + api.getCurrent());
                    $.ajax({
                        type: "GET",
                        url: url,
                        data: {pageNum: api.getCurrent(),categoryId:categoryId},

                        success: function (json) {
                            var pageInfo = json.data;
                            for (var i = 0; i < pageInfo.list.length; i++) {
                                var info = pageInfo.list[i];
                                var $a_data = $("<a class='P--30 h--150 borderB--f5f5f5 block' href='http://www.donews.com/news/detail/1/3040375.html' id='L" + (i + 1) + "'>" +
                                    "<div class='MR--20 fl h--full style--imgArea  relative'>" +
                                    "<img class='' h--full absolute pos--center' src='../assets/images/zixuntu.jpg' style='max-width: inherit;' alt='zixuntu'> </div>" +
                                    "<div class=''><div class='MB--10 FS--16'><span class='inline BC--ffa200 MR--10 PLR--10 radius4 PTB--2 fl'>" + info.informationEntity.typeName + "</span>" +
                                    "<p class='style--textOver color--333333 PTB--2'>" + info.brief + "</p></div><div class='MB--10 FS--12 color--999999'>" +
                                    "<div class='inline MR--70 style--middleArea'><span>" + info.createTime + "</span></div><div class='inline style--middleArea'>" +
                                    "点击量： <span class='style--textOver w--200'>" + info.click + "</span></div></div><p class='js_text style--twoLine color--999999 FS--14 MB--20 h--14--twoLine' id='thirtyfive'>" + info.text + "</p></div></a>");

                                $('.M-box').before($a_data);
                            }
                        }
                    })
                }
            });
        }
    })

}