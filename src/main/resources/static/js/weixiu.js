$(function () {
    $("#shangbao").click(function () {
        var data=$("#weixiu_form").serialize();
         // alert(data);
        $.ajax({
            type: "post",
            url: "/weixiu/shangbao",
            data: data,
            dataType: "json", //返回数据类型
            success: function(result){
                if (result.state=0){
                    alert(result.message);
                } else {
                    //修改成功
                    alert(result.message);
                    $("input[name='addre']").val("");//清空验证码输入框
                    $("input[name='obj']").val("");//清空验证码输入框
                    $("input[name='phone']").val("");//清空验证码输入框
                }
            }
        })
    });
});