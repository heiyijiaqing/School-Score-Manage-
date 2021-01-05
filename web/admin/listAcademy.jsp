<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
$(function(){

	$("#addForm").submit(function(){
		if(!checkEmpty("name","学院名称"))
			return false;
//		if(!checkEmpty("academyPic","分类图片"))
//			return false;
		return true;
	});
});

</script>

<title>学院管理</title>


<div class="workingArea">
	<h1 class="label label-info" >学院管理</h1>
	<br>
	<br>

	<div class="listDataTableDiv">
		<table class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
				<tr class="success">
					<th>ID</th>
					<th>学院名称</th>
<!-- 					<th>属性管理</th> -->
<!-- 					<th>产品管理</th> -->
					<th>编辑</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${thecs}" var="c">

				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>

<%-- 					<td><a href="admin_property_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>					 --%>
<%-- 					<td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>					 --%>
					<td><a href="admin_academy_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
					<td><a deleteLink="true" href="admin_academy_delete?id=${c.id}"><span class=" 	glyphicon glyphicon-trash"></span></a></td>

				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="pageDiv">
		<%@include file="../include/admin/adminPage.jsp" %>
	</div>

	<div class="panel panel-warning addDiv">
	  <div class="panel-heading">新增学院</div>
	  <div class="panel-body">
	    	<form method="post" id="addForm" action="admin_academy_add" enctype="multipart/form-data">
	    		<table class="addTable">
	    			<tr>
	    				<td>学院名称</td>
	    				<td><input  id="name" name="name" type="text" class="form-control"></td>
	    			</tr>
	    			<%--<tr>--%>
	    				<%--<td>学院圖片</td>--%>
	    				<%--<td>--%>
	    					<%--<input id="academyPic" accept="image/*" type="file" name="filepath" />--%>
	    				<%--</td>--%>
	    			<%--</tr>--%>
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