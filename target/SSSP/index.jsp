<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="script/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            //alert("jin");
            $("#testJson").click(function () {
                alert("click");
                // var url = this.href.valueOf();
                var params = {};

                $.ajax({
                    url: "/testJson",
                    type: "post",
                    dataType: 'json',
                    
                    success: function (data) {
                        if (data != null) {
                            console.log("name:" + data.name);
                        }

                    },
                    error: function () {
                        alert("fail");
                    }
                })
            });
            $("#testEmp").click(function () {
                var params = {"id": 10};
                $.ajax({
                    url: "/testEmp?id=10",

                    type: "get",
                    dataType: 'json',
                    success: function (data) {
                        if (data == null) return;
                        console.log(data);
                    },
                    error: function (data) {
                        alert("fail");
                    }

                })
            })
        });
    </script>
</head>
<body>
<h2><a href="emps">查看所有员工</a></h2>

<h2><a href="inputEmployee">添加员工</a></h2><br><br>

<h2><a href="#" id="testJson">测试json</a></h2>

<h2><a href="#" id="testEmp">测试Emp</a></h2>

</body>
</html>
