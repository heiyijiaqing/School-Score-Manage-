<%--
  Created by IntelliJ IDEA.
  User: 蒙太奇
  Date: 2021/1/5
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/student/studentHeader.jsp"%>
<%@include file="../include/student/studentNavigator.jsp"%>

<script>
    $(function(){

        $("#addForm").submit(function(){
            if(!checkEmpty("score","成绩"))
                return false;
            return true;
        });
    });

</script>

<title>查询成绩</title>


<div class="workingArea">
    <h1 class="label label-info" >课程管理</h1>
    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>课程id</th>
                <th>学生id</th>
                <th>成绩</th>

                <%--<th>编辑</th>--%>
                <%--<th>删除</th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${thecs}" var="c">

                <tr>
                    <td>${c.id}</td>
                    <td>${c.courseId}</td>
                    <td>${c.studentId}</td>
                    <td>${c.score}</td>

                        <%-- 					<td><a href="student_property_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>					 --%>
                        <%-- 					<td><a href="student_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>					 --%>
                    <%--<td><a href="student_score_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>--%>
                    <%--<td><a deleteLink="true" href="student_score_delete?id=${c.id}"><span class=" 	glyphicon glyphicon-trash"></span></a></td>--%>

                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

    <div class="pageDiv">
        <%@include file="../include/student/studentPage.jsp" %>
    </div>

</div>

<%@include file="../include/student/studentFooter.jsp"%>
