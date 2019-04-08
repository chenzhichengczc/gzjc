$(function () {
    var pageNum=0
    if($("[data-selected]").length == 0){
        pageNum = 1
    }else{
        pageNum = $("[data-selected]").html()
    }
    getData(pageNum)
    getCatalogy()
})
function getData(pageNum,categoryId) {
    $("#p0").empty()//移除id为p0的元素内容使换页结束拼接
    $("#L0").empty()//移除id为L0的元素内容使换页结束拼接
    $("#pageInput").val("")//获取输入页码的值
    var page = pageNum
    if(categoryId == undefined || categoryId == null){
        window.categoryId = 0
    }else {
        window.categoryId = categoryId
    }
    $.ajax({
        type: "GET",
        data:{pageNum:page, pageSize: 7,categoryId : window.categoryId},
        url: "../information/paging",
        dataType: "json",
        success: function(json){
            var pageInfo = json.data;
            window.pages = pageInfo.pages
            $("#page_content").html(pageInfo);

            if(page < 4){
                if(pageInfo.pages>page){
                    for(i = 0; i<5 ;i++){
                        var pageNum = $("<a href='javacript:void(0)' class='style--pageLi page' id='p"+(i+1)+"' value="+(i+1)+" onclick='fn(this)'>"+(i+1)+"</a>");
                        //拼接
                        if(i == 0){
                            $("#p"+i).append(pageNum);
                        }else{
                            $("#p"+i).after(pageNum);
                        }
                    }
                }else {
                    for(i=0;i<Math.ceil(pageInfo.list.length / 7);i++){
                         pageNum = $("<a href='javacript:void(0)' class='style--pageLi page' id='p"+(i+1)+"' value="+(i+1)+" onclick='fn(this)'>"+(i+1)+"</a>");
                        //拼接
                        if(i == 0){
                            $("#p"+i).append(pageNum);
                        }else{
                            $("#p"+i).after(pageNum);
                        }
                    }
                }
            }else if(page <= pageInfo.pages){
                var boo = pageInfo.pages - page < 2
                for(boo ? i = pageInfo.pages - 4 : i = parseInt(page) - 2,y = 0; boo ? i <= pageInfo.pages : i< parseInt(page) + 3 ;i++,y++){
                    var pageNum = $("<a href='javacript:void(0)' class='style--pageLi page' id='p"+(y+1)+"' value="+(i)+" onclick='fn(this)'>"+(i)+"</a>");
                        //拼接
                        if(y == 0){
                        $("#p"+y).append(pageNum);
                    }else{
                        $("#p"+y).after(pageNum);
                    }
                }
            }
            $("#p"+page).attr("data-selected","select")

            for (var i = 0; i<pageInfo.list.length;i++){
                var info = pageInfo.list[i]
                var $a_data = $("<a class='P--30 h--150 borderB--f5f5f5 block' href='http://www.donews.com/news/detail/1/3040375.html' id='L"+(i+1)+"'>" +
                    "<div class='MR--20 fl h--full style--imgArea  relative'>" +
                    "<img class='' h--full absolute pos--center' src='../assets/images/zixuntu.jpg' style='max-width: inherit;' alt='zixuntu'> </div>" +
                    "<div class=''><div class='MB--10 FS--16'><span class='inline BC--ffa200 MR--10 PLR--10 radius4 PTB--2 fl'>"+info.informationEntity.typeName+"</span>" +
                    "<p class='style--textOver color--333333 PTB--2'>"+info.brief+"</p></div><div class='MB--10 FS--12 color--999999'>" +
                    "<div class='inline MR--70 style--middleArea'><span>"+info.createTime+"</span></div><div class='inline style--middleArea'>" +
                    "点击量： <span class='style--textOver w--200'>"+info.click+"</span></div></div><p class='js_text style--twoLine color--999999 FS--14 MB--20 h--14--twoLine' id='thirtyfive'>"+info.text+"</p></div></a>")

                if(i == 0){
                    $("#L"+i).append($a_data);
                }else{
                    $("#L"+i).after($a_data)
                }
            }
            //位置偏移
            window.scrollTo(0,0)

        }
    })
}

function fn(obj) {
    var data = parseInt(obj.getAttribute("value"))
    checkPageNum(data) ?  getData(data) : alert("页码信息有误,请确认或联系管理员")

}
//输入页数超出与未超出的动作
$("#go").click(function (event) {
    var data = $(event.target).prev().prev().val()
    checkPageNum(data) ? getData(data) : alert("页码信息有误,请确认或联系管理员")
    //转JQ
})
//判断页码
function checkPageNum(pageNum) {
    if(pageNum > window.pages || pageNum<1){
        return false
    }
    return true
}
function getCatalogy() {
    $.ajax({
        type: "GET",
        url: "../information/getCatalogy",
        dataType: "json",
        success: function(json){
            for (var i = 0 ; i<json.data.length ; i++){

                //$("[data-id = "+i+"]").addClass("text-primary").css("font-weight","bold")

                var $dataList = $("<a class='js_columnSlide inline style--categoryA align_center' data-id = "+(i+1)+" href='javacript:void(0)' id='c"+(i+1)+"' onclick='selectCatalogy(id)' style='width: 107.5px;'>"+json.data[i].typeName+"</a>")
                $("[data-id="+i+"]").after($dataList)
            }
            json.data.pages=1
        }
    })
}
function selectCatalogy(id) {
    id = id.split("c")
    getData($("[data-selected]").html(),window.categoryId = id[1])
}


