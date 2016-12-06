var employee = {};

employee.validateName = function () {
    $("#ename").change(function () {

        var name = $(this).val();
        name = $.trim(name);
        var oldName = $("#_oldName").val();
        oldName = $.trim(oldName);
        if (oldName != null && oldName != "" && oldName == name) {
            alert("名字可用");
            return false;
        }
        var params = {"name": name};
        var urlval = "/valiateEmployeeName?name=" + name;


        $.ajax({
            url: urlval,
            type: "post",
            //  data: params,
            dataType: 'json',
            success: function (data) {
                console.log(data);
                if (data == "0")alert("该名字可用");
                if (data == "1")alert("该名字不可用");
                if (data == "3")alert("出现不可预知异常");
            },
            error: function (data) {
                alert("请求失败");
                console.log(data);
            }
        });
        /*$.post(urlval, params, function (data) {
         alert("aaa");
         console.log(data);
         })*/

    });
};

employee.deleteEmployee = function () {

    $(".delHrel").click(function () {
        var label = $(this).next(":hidden").val();
        var flag = confirm("确定要删除" + label);
        if (flag) {
            var url = $(this).attr("href");
            $("#deleteForm").attr("action", url);
            //$("#_method").val("DELETE");
            $("#deleteForm").submit();
        }
        return false;


    })
};