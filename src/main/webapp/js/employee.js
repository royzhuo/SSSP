var employee = {};

employee.validateName = function () {
    $("#ename").change(function () {
        var name = $(this).val();
        name = $.trim(name);
        var params = {"name": name};
        var urlval = "valiateEmployeeName?name=" + name;
        //var urlval = "valiateEmployeeName";
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