<%--
  Created by IntelliJ IDEA.
  User: Roy
  Date: 16/10/27
  Time: 下午8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加员工</title>
    <script type="text/javascript" src="../script/jquery-1.7.2.min.js"></script>
    <script src="../js/employee.js" language="javascript" type="text/javascript"></script>
    <script language="JavaScript" type="text/javascript">
        $(function () {
            employee.validateName();
        })

    </script>
</head>
<body>
<form:form action="/emp" method="post" modelAttribute="employee">
    姓名 <form:input path="name" title="name" id="ename"/><br><br>

    生日 <form:input path="birthDay" title="birtdhDay"/>
    <br><br>
    部门 <form:select path="dept.id">
    <option>请选择</option>
    <form:options itemValue="id" itemLabel="name" items="${dept}"/>
</form:select>
    <br><br>

    <br><br>
    <input type="submit" value="提交">
</form:form>
</body>
</html>
