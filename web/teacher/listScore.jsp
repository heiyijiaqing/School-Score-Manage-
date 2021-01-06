<%--
  Created by IntelliJ IDEA.
  User: 蒙太奇
  Date: 2021/1/5
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/teacher/teacherHeader.jsp"%>
<%@include file="../include/teacher/teacherNavigator.jsp"%>

<script>
    $(function(){

        $("#addForm").submit(function(){
            if(!checkEmpty("score","成绩"))
                return false;
            return true;
        });
    });

</script>

<title>课程管理</title>


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

                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${thecs}" var="c">

                <tr>
                    <td>${c.id}</td>
                    <td>${c.courseId}</td>
                    <td>${c.studentId}</td>
                    <td>${c.score}</td>

                        <%-- 					<td><a href="teacher_property_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>					 --%>
                        <%-- 					<td><a href="teacher_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>					 --%>
                    <td><a href="teacher_score_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="teacher_score_delete?id=${c.id}"><span class=" 	glyphicon glyphicon-trash"></span></a></td>

                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

    <div class="pageDiv">
        <%@include file="../include/teacher/teacherPage.jsp" %>
    </div>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增课程成绩</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="teacher_score_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>课程id</td>
                        <td><input  id="courseId" name="courseId" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>学生id</td>
                        <td><input  id="studentId" name="studentId" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>成绩</td>
                        <td><input  id="score" name="score" type="text" class="form-control"></td>
                    </tr>

                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>

<%@include file="../include/teacher/teacherFooter.jsp"%>
