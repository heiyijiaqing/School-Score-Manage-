<%--
  Created by IntelliJ IDEA.
  User: 蒙太奇
  Date: 2021/1/5
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/student/studentHeader.jsp"%>
<%@include file="../include/student/studentNavigator.jsp"%>



<title>编辑学生</title>


<script>
    $(function(){

        $("#editForm").submit(function(){
            if(!checkEmpty("name","姓名"))
                return false;

            return true;
        });
    });

</script>

<div class="workingArea">

    <%--<ol class="breadcrumb">--%>
        <%--<li><a href="student_teacher_list">所有学生</a></li>--%>
        <%--<li class="active">编辑学生</li>--%>
    <%--</ol>--%>

    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑学生</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="student_student_update"  enctype="multipart/form-data">
                <table class="editTable">
                    <%--<tr>--%>
                    <%--<td>姓名</td>--%>
                    <%--<td><input  id="name" name="name" value="${c.name}" type="text" class="form-control"></td>--%>
                    <%--</tr>--%>

                    <tr>
                        <td>ID</td>
                        <td><input  id="id" name="id" value="${c.id}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>班级id</td>
                        <td><input  id="classId" name="classId" value="${c.classId}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                    <tr>
                        <td>密码</td>
                        <td><input  id="password" name="password" value="${c.password}"  type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>姓名</td>
                        <td><input  id="name" name="name" value="${c.name}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>性别</td>
                        <td><input  id="sex" name="sex" value="${c.sex}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>年龄</td>
                        <td><input  id="age" name="age" value="${c.age}" type="text" class="form-control"></td>
                    </tr>

                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <%--<input type="hidden" name="id" value="${c.id}">--%>
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
