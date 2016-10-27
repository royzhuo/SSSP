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
</head>
<body>
<form:form action="#" method="post" modelAttribute="emp">
    姓名 <form:input path="name" title="name"/><br><br>

    生日 <form:input path="birthDay" title="birtdhDay"/>
    <br><br>
    部门 <form:select path="dept">
    <option>请选择</option>
    <form:options itemValue="id" itemLabel="name" items="${dept}"/>
    </form:select>
    <br><br>
    创建时间<form:input path="createTime" title="createTime"/>
    <br><br>
    <input type="submit" value="提交">
</form:form>
</body>
</html>
