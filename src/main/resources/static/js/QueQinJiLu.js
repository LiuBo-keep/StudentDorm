$(document).ready(function () {
    var data=$("#mequeqinform").serialize();
    $.ajax({
        type: "post",
        url: "/kaoqin/queqinjilu",
        data: data,
        dataType: "json", //返回数据类型
        success: function(result){
            formatJsonToSeries(result);//对数据进行处理
        }
    });
});

$(function () {
    $("#mequeqin").click(function () {
        var data=$("#mequeqinform").serialize();
        // alert(data);
        $.ajax({
            type: "post",
            url: "/kaoqin/queqinjilu",
            data: data,
            dataType: "json", //返回数据类型
            success: function(result){
                formatJsonToSeries(result);
            }
        });
    });
});

//动态表格
function formatJsonToSeries(result){
    // console.log(result.data);
    var jsodata=result.data.items;
    // console.log(jsodata.length);
    var queqintable=document.getElementById("queqintable");
    // console.log(queqintable);
    var ta="<tr>" +
        "<th>日期</th>" +
        "<th>学号</th>" +
        "<th>姓名</th>" +
        "<th>寝室</th>" +
        "<th>备注</th>" +
        "</tr>";

    for (var i=0;i<jsodata.length;i++){
        ta+="<tr>" +
            "<td>"+new Date(jsodata[i].data).format("yyyy-MM-dd")+"</td>"+
            // "<td>"+jsodata[i].data+"</td>"+
            "<td>"+jsodata[i].sn+"</td>"+
            "<td>"+jsodata[i].username+"</td>"+
            "<td>"+jsodata[i].sushe+"</td>"+
            "<td>"+jsodata[i].remake+"</td>"+
            "</tr>"
    }
    queqintable.innerHTML=ta;

    //记录总页数
    var total_count=document.getElementById("total_count");
    // console.log(result.data.total);
    total_count.innerText=result.data.total;

    //分页按钮
    console.log(result.data)
    var pageCount=result.data.pageCount;//总页数
    console.log("总页数"+pageCount);
    var pageCurrent=result.data.pageCurrent;//当前页码
    console.log("当前页码"+pageCurrent);
    if (null==pageCurrent){//如果第一次访问时,设置当前页为1
        pageCurrent=1;
        console.log("如果第一次访问时,设置当前页为"+pageCurrent);
    }
    var page_ul=document.getElementById("page_ul");
    console.log(page_ul);
    var lis="<li id=''><</li>";
    for (var j=1;j<=pageCount;j++){
        lis+="<li id=''>"+j+"</li>";
        if (j==pageCount){
            lis+="<li id=''>></li>"
        }
    }

    page_ul.innerHTML=lis;
}

function page(){

}

//转换时间格式方法
Date.prototype.format = function(fmt) {
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt)) {
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    for(var k in o) {
        if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
    return fmt;
}