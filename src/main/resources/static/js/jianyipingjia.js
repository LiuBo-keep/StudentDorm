$(function () {
    $("#tijiao").click(function () {
        var data=$("#jianyi_form").serialize();
        $.ajax({
            type: "post",
            url: "/jianyi",
            data: data,
            dataType: "json", //返回数据类型
            success: function(result){
                //保存失败
                if (result.state==0){
                    alert("操作失败！");
                } else {
                    //保存成功
                    alert(result.message);
                    $("input[name='lianxi']").val("");
                    $("textarea[name='message']").val("");
                    $("input[name='username']").val("");
                }
            }
        });
    });
});