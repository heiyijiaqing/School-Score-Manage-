<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<script>
$(function(){
	
	<c:if test="${!empty msg}">
	$("span.errorMessage").html("${msg}");
	$("div.loginErrorMessageDiv").show();		
	</c:if>
	
	$("form.loginForm").submit(function(){
		if(0==$("#name").val().length||0==$("#password").val().length){
			$("span.errorMessage").html("请输入账号密码");
			$("div.loginErrorMessageDiv").show();			
			return false;
		}
		return true;
	});
	
	$("form.loginForm input").keyup(function(){
		$("div.loginErrorMessageDiv").hide();	
	});
	
	
	
	var left = window.innerWidth/2+162;
	$("div.loginSmallDiv").css("left",left);
})
</script>


<div id="loginDiv" style="position: relative">

	<div class="simpleLogo">
		<a href="${contextPath}"><img src="img/site/simple.png"></a>
	</div>

	
	<img id="loginBackgroundImg" class="loginBackgroundImg" src="img/site/loginGround.png">
	
	<form class="loginForm" action="/forelogin" method="post">
		<div id="loginSmallDiv" class="loginSmallDiv">
			<div class="loginErrorMessageDiv">
				<div class="alert alert-danger" >
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
				  	<span class="errorMessage"></span>
				</div>
			</div>
				
			<div class="login_acount_text">账户登录</div>
			<div class="loginInput " >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-user"></span>
				</span>
				<input id="id" name="id" placeholder="工号/学号" type="text">
			</div>
			
			<div class="loginInput " >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-lock"></span>
				</span>
				<input id="password" name="password" type="password" placeholder="密码" type="text">
			</div>
			<%--<span class="text-danger">不要输入真实的天猫账号密码</span><br><br>--%>
			<td class="s2">
				<label style=" color:black;">
					登录身份:
				</label>

			</td>
			<td>
				<select id="type" name="type">
					<option value="0">
						学生
					</option>
					<option value="1">
						教师
					</option>
					<option value="2">
						管理员
					</option>
				</select>
			</td>
			
			<div>
				<%--<a class="notImplementLink" href="#nowhere">忘记登录密码</a> --%>
				<%--<a href="register.jsp" class="pull-right">免费注册</a> --%>
			</div>
			<div style="margin-top:20px">
				<button class="btn btn-block btn-primary" type="submit">登录</button>
			</div>
		</div>	
	</form>


</div>	