$(function () {
    $("#quedin").click(function () {
        var data=$("#qianchu-main-form").serialize();
        // alert(data);
        $.ajax({
            type: "get",
            url: "/emigration/me",
            data: data,
            dataType: "json", //返回数据类型
            success: function(result){
                //保存失败
                if (result.state==0){
                    alert("操作失败！");
                } else {
                    //保存成功
                    // alert(result.message)
                    var qiana=document.getElementById("qiana");
                    qiana.className="qianchu hide";
                    var qianb=document.getElementById("qianb");
                    qianb.className="qianchu show"
                }
            }
        });
    });
});

$(function () {
    $("#quedingqianchu").click(function () {
        var dat=$("#qianchu-nei-form").serialize();
        alert(dat);
        $.ajax({
            type: "post",
            url: "/emigration/tu",
            data: dat,
            dataType: "json", //返回数据类型
            success: function(result){
                //保存失败
                if (result.state==0){
                    alert("操作失败！");
                } else {
                    //保存成功
                    alert(result.message);
                    var qiana=document.getElementById("qiana");
                    qiana.className="qianchu show";
                    var qianb=document.getElementById("qianb");
                    qianb.className="qianchu hide"
                }
            }
        });
    });
});