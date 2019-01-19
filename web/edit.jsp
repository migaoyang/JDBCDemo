<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/8
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更新学生</title>
</head>
<body>
<h3 >更新学生</h3>
<form method="post" action="UpdateServlet?sid=${student.sid}">
    <table border="1" width="600">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${student.sname}"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男"
                    <c:if test="${student.gender == '男'}">checked</c:if>
                >男
                <input type="radio" name="gender" value="女"
                     <c:if test="${student.gender == '女'}">checked</c:if>
                >女
            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td> <input type="text" name="phone" value="${student.phone}"> </td>
        </tr>
        <tr>
            <td>生日</td>
            <td> <input type="text" name="birthday" value="${student.birthday}"></td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <input type="checkbox" name="hobby" value="跑步"
                       <c:if test="${student.hobby == '跑步'}">checked</c:if>
                >跑步
                <input type="checkbox" name="hobby" value="篮球"
                       <c:if test="${student.hobby == '篮球'}">checked</c:if>
                >篮球
                <input type="checkbox" name="hobby" value="足球"
                       <c:if test="${student.hobby == '足球'}">checked</c:if>
                >足球
                <input type="checkbox" name="hobby" value="乒乓球"
                       <c:if test="${student.hobby == '乒乓球'}">checked</c:if>
                >乒乓球
            </td>
        </tr>
        <tr>
            <td>简介</td>
            <td><textarea name="info" rows="3" cols="20" >${studnet.info}</textarea></td>
        </tr>
        <tr>
            <%--<input type="hidden" name="sid" value="${student.sid}">--%>
        </tr>
        <tr>

            <td colspan="2">  <input type="submit" value="添加"> </td>
        </tr>
    </table>
</form>
</body>
</html>
