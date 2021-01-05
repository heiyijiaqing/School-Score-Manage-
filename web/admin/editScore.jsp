<%--
  Created by IntelliJ IDEA.
  User: 蒙太奇
  Date: 2021/1/5
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>



<title>编辑成绩</title>


<script>
    $(function(){

        $("#editForm").submit(function(){
            if(!checkEmpty("score","成绩"))
                return false;

            return true;
        });
    });

</script>

<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="admin_score_list">所有成绩</a></li>
        <li class="active">编辑成绩</li>
    </ol>

    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑成绩</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_score_update"  enctype="multipart/form-data">
                <table class="editTable">
                    <tr>
                        <td>课程id</td>
                        <td><input  id="courseId" name="courseId" value="${c.courseId}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>学生id</td>
                        <td><input  id="studentId" name="studentId" value="${c.studentId}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>成绩</td>
                        <td><input  id="score" name="score" value="${c.score}" type="text" class="form-control"></td>
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
