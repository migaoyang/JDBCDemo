<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/8
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<script type="text/javascript">
    function doDelete(sid) {
        var flag = confirm("是否删除?");
        if(flag){
            window.location.href = "DeleteServlet?sid=" + sid;
        }
    }
</script>

<head>
    <title>分页查询页面</title>



</head>
<body>
<form action="SearchStudentServlet" method="post">
    <table border="1" width="700">

        <tr>
            <td colspan="8">
                按姓名查询： <input type="text" name="sname">
                &nbsp;
                按性别查询： <select name = "sgender">
                <option value="">--请选择--
                <option value="男">男
                <option value="女">女
            </select>
                &nbsp;&nbsp;&nbsp;
                <input type="submit" value="查询">
                &nbsp;&nbsp;&nbsp;
                <a href="add.jsp">添加</a>
            </td>

        </tr>

        <tr align="center">
            <td>编号A</td>
            <td>姓名</td>
            <td>性别</td>
            <td>电话</td>
            <td>生日</td>
            <td>爱好</td>
            <td>简介</td>
            <td>操作</td>
        </tr>


        <c:forEach items="${studentPageBean.list }" var="stu">
            <tr align="center">
                <td>${stu.sid}</td>
                <td>${stu.sname}</td>
                <td>${stu.gender}</td>
                <td>${stu.phone}</td>
                <td>${stu.birthday}</td>
                <td>${stu.hobby}</td>
                <td>${stu.info}</td>
                <td><a href="EditServlet?sid=${stu.sid}">update</a> <a href="#" onclick="doDelete(${stu.sid})">delete</a> </td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="8">
                第 ${studentPageBean.currentPage } / ${studentPageBean.totalPage }
                &nbsp;&nbsp;
                每页显示${studentPageBean.pageSize }条  &nbsp;&nbsp;&nbsp;
                总的记录数${studentPageBean.totalSize } &nbsp;&nbsp;&nbsp;
                <c:if test="${studentPageBean.currentPage !=1 }">
                    <a href="StudentPageListServlet?currentPage=1">首页</a>
                    | <a href="StudentPageListServlet?currentPage=${studentPageBean.currentPage-1 }">上一页</a>
                </c:if>

                <c:forEach begin="1" end="${studentPageBean.totalPage }" var="i">
                    <c:if test="${studentPageBean.currentPage == i }">
                        ${i }
                    </c:if>
                    <c:if test="${studentPageBean.currentPage != i }">
                        <a href="StudentPageListServlet?currentPage=${i }">${i }</a>
                    </c:if>

                </c:forEach>


                <c:if test="${studentPageBean.currentPage !=studentPageBean.totalPage }">
                    <a href="StudentPageListServlet?currentPage=${studentPageBean.currentPage+1 }">下一页</a> |
                    <a href="StudentPageListServlet?currentPage=${studentPageBean.totalPage }">尾页</a>
                </c:if>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
