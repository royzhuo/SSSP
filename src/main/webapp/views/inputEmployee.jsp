<%--
  Created by IntelliJ IDEA.
  User: Roy
  Date: 16/10/27
  Time: 下午8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<c:set value="/emp" var="url"></c:set>

<c:if test="${employee.id !=null}">
    <c:set value="${pageContext.request.contextPath}/emp/${employee.id}" var="url"></c:set>
</c:if>
<form:form action="${url}" method="post" modelAttribute="employee">
    <c:if test="${employee.id !=null}">
        <input type="hidden" id="_oldName" value="${employee.name}">
        <form:hidden path="id"/>
        <input type="hidden" name="_method" value="PUT"/>
    </c:if>
    姓名 <form:input path="name" title="name" id="ename"/><br><br>

    生日 <form:input path="birthDay" title="birtdhDay"/>
    <br><br>
    部门 <form:select path="dept.id">
    <option>请选择</option>
    <form:options itemValue="id" itemLabel="name" items="${dept}"/>
</form:select>
    <br><br>
    <input type="submit" value="提交">
</form:form>
</body>
</html>
