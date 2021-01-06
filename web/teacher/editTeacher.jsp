<%--
  Created by IntelliJ IDEA.
  User: 蒙太奇
  Date: 2021/1/5
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/teacher/teacherHeader.jsp"%>
<%@include file="../include/teacher/teacherNavigator.jsp"%>



<title>编辑教师</title>


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
    <%--<li><a href="teacher_teacher_list">所有教师</a></li>--%>
    <%--<li class="active">编辑教师</li>--%>
    <%--</ol>--%>

    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑教师</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="teacher_teacher_updateTeacher"  enctype="multipart/form-data">
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
                        <td>学院id</td>
                        <td><input  id="academyId" name="academyId" value="${c.academyId}" type="text" class="form-control"></td>
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
                    <tr>
                        <td>职称</td>
                        <td><input  id="title" name="title" value="${c.title}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>电话</td>
                        <td><input  id="phone" name="phone" value="${c.phone}" type="text" class="form-control"></td>
                    </tr>

                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <%--<input type="hidden" name="id" value="${c.id}">--%>
                            <button updateLink="true" type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

