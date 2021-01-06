<%--
  Created by IntelliJ IDEA.
  User: 蒙太奇
  Date: 2021/1/5
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>



<title>编辑班级</title>


<script>
    $(function(){

        $("#editForm").submit(function(){
            if(!checkEmpty("name","班级名称"))
                return false;
            return true;
        });
    });

</script>

<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="admin_class_list">所有班级</a></li>
        <li class="active">编辑班级</li>
    </ol>

    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑班级</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_class_update"  enctype="multipart/form-data">
                <table class="editTable">
                    <tr>
                        <td>专业</td>
                        <td><input  id="majorId" name="majorId" value="${c.majorId}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>班级</td>
                        <td><input  id="name" name="name" value="${c.name}" type="text" class="form-control"></td>
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
