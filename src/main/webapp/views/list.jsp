<%--
  Created by IntelliJ IDEA.
  User: Roy
  Date: 16/10/26
  Time: 下午8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>员工列表页面</title>
</head>
<body>


<c:if test="${page==null || page.totalElements==0}">
    没有员工信息
</c:if>
<c:if test="${page!=null || page.totalPages>0}">
    <table border="1" cellpadding="1" cellspacing="1">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>生日</th>
            <th>部门</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${page.content}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.birthDay}</td>
                <td>${emp.dept.name}</td>
                <td>${emp.createTime}</td>
                <td><a href="#">删除</a> &nbsp;<a href="#">修改</a></td>
            </tr>
        </c:forEach>
        <tr>
            总共${page.totalElements} 个员工
            共 ${page.totalPages}页&nbsp;
            当前第${page.number+1} 页&nbsp;
            <c:if test="${page.number+1!=1}">

                <a href='/emps?pageNo=${page.number+1-1}'>上一页</a>
            </c:if>
            <c:if test="${page.number+1!=page.totalPages}">

                <a href="/emps?pageNo=${page.number+1+1}">下一页</a>
            </c:if>
        </tr>
    </table>
</c:if>

<%--<c:choose>
    相当于 if esle
    <c:when test=""></c:when>
    <c:otherwise></c:otherwise>
</c:choose>--%>
</body>
</html>
