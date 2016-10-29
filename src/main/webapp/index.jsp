<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="script/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            //alert("jin");
            $("#testJson").click(function () {
                alert("click");
                var url = this.href.valueOf();
                var params = {};

                $.post(url, params, function (data) {
                    console.log(data);
                });
            })
        });
    </script>
</head>
<body>
<h2><a href="emps">查看所有员工</a></h2>

<h2><a href="inputEmployee">添加员工</a></h2><br><br>

<h2><a href="testJson" id="testJson">测试json</a></h2>

</body>
</html>
