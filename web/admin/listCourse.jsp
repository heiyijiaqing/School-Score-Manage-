<%--
  Created by IntelliJ IDEA.
  User: 蒙太奇
  Date: 2021/1/5
  Time: 7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
    $(function(){

        $("#addForm").submit(function(){
            if(!checkEmpty("name","课程名称"))
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
                <th>班级id</th>
                <th>教师id</th>
                <th>课程名</th>
                <th>学年</th>
                <th>学期</th>
                <th>学时</th>
                <th>考察类型</th>
                <th>学分</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${thecs}" var="c">

                <tr>
                    <td>${c.id}</td>
                    <td>${c.classId}</td>
                    <td>${c.teacherId}</td>
                    <td>${c.name}</td>
                    <td>${c.year}</td>
                    <td>${c.term}</td>
                    <td>${c.hour}</td>
                    <td>
                        <c:choose>
                            <c:when test="${c.type == 0}">考试</c:when>
                            <c:when test="${c.type == 1}">考查</c:when>
                        </c:choose>
                    </td>
                    <td>${c.credit}</td>

                        <%-- 					<td><a href="admin_property_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>					 --%>
                        <%-- 					<td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>					 --%>
                    <td><a href="admin_course_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_course_delete?id=${c.id}"><span class=" 	glyphicon glyphicon-trash"></span></a></td>

                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增课程</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_course_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>班级id</td>
                        <td><input  id="classId" name="classId" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>教师id</td>
                        <td><input  id="teacherId" name="teacherId" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>课程名称</td>
                        <td><input  id="name" name="name" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>学年</td>
                        <td><input  id="year" name="year" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>学期</td>
                        <td><input  id="term" name="term" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>学时</td>
                        <td><input  id="hour" name="hour" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>考察类型</td>
                        <td><input  id="type" name="type" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>学分</td>
                        <td><input  id="credit" name="credit" type="text" class="form-control"></td>
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

<%@include file="../include/admin/adminFooter.jsp"%>
