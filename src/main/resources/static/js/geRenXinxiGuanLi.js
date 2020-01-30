$(function () {
    $("#xiugai").click(function () {
        var data=$("#xiugaiform").serialize();
        // alert(data);
        $.ajax({
            type: "post",
            url: "/genren/xiugai",
            data: data,
            dataType: "json", //返回数据类型
            success: function(result){
                if (result.state=0){
                    alert(result.message);
                } else {
                    //修改成功
                    alert(result.message);
                    var dialog=document.getElementById("dialog");
                    dialog.className="dialog hide"
                    location.reload();
                }
            }
        })
    });
});