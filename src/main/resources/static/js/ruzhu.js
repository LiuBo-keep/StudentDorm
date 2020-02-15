$(function () {
    $("#ruzhu_btn").click(function () {
        var data=$("#ruzhu_form").serialize();
        alert(data);
        $.ajax({
            type: "post",
            url: "/ruzhu/shangbao",
            data: data,
            dataType: "json", //返回数据类型
            success: function(result){
                if (result.state=0){
                    alert(result.message);
                } else {
                    //修改成功
                    alert(result.message);
                    $("input[name='sn']").val("");//清空验证码输入框
                    $("input[name='clazzId']").val("");//清空验证码输入框
                    $("input[name='sex']").val("");//清空验证码输入框
                }
            }
        });
    });
});