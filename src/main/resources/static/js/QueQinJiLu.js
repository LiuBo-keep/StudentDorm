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
               /* //保存失败
                if (result.state==0){
                    alert(result.message);
                } else {
                    //保存成功
                    alert(result.message)
                }*/
            }
        });
    });
});