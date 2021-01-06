<%--
  Created by IntelliJ IDEA.
  User: 蒙太奇
  Date: 2021/1/5
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>



<title>编辑专业</title>


<script>
    $(function(){

        $("#editForm").submit(function(){
            if(!checkEmpty("name","专业名称"))
                return false;
            return true;
        });
    });

</script>

<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="admin_major_list">所有专业</a></li>
        <li class="active">编辑专业</li>
    </ol>

    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑专业</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_major_update"  enctype="multipart/form-data">
                <table class="editTable">
                    <tr>
                        <td>学院</td>
                        <td><input  id="academyId" name="academyId" value="${c.academyId}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>专业</td>
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
