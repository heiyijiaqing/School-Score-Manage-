<%--
  Created by IntelliJ IDEA.
  User: 蒙太奇
  Date: 2021/1/5
  Time: 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>



<title>编辑课程</title>


<script>
    $(function(){

        $("#editForm").submit(function(){
            if(!checkEmpty("name","课程名"))
                return false;

            return true;
        });
    });

</script>

<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="admin_course_list">所有课程</a></li>
        <li class="active">编辑课程</li>
    </ol>

    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑课程</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_course_update"  enctype="multipart/form-data">
                <table class="editTable">

                    <tr>
                        <td>班级id</td>
                        <td><input  id="classId" name="classId" value="${c.classId}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>教师id</td>
                        <td><input  id="teacherId" name="teacherId" value="${c.teacherId}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>课程名称</td>
                        <td><input  id="name" name="name" value="${c.name}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>学年</td>
                        <td><input  id="year" name="year" value="${c.year}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>学期</td>
                        <td><input  id="term" name="term" value="${c.term}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>学时</td>
                        <td><input  id="hour" name="hour" value="${c.hour}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>考察类型</td>
                        <td><input  id="type" name="type" value="${c.type}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>学分</td>
                        <td><input  id="credit" name="credit" value="${c.credit}" type="text" class="form-control"></td>
                    </tr>

                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${c.id}">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
