<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%-- 引入jstl--%>
<%@include file="common/tag.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>登录页面</title>
<%@include file="common/head.jsp"%>
</head>
<body>
	<%-- 页面显示部分 --%>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>登录界面</h2>
			</div>
			<div class="panel-body">
				<form>
					<div class="form-group">
						<label for="exampleInputEmail1">Username</label> 
						<input type="text" class="form-control" id="getName" placeholder="Username">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> 
						<input type="password" class="form-control" id="getPassword" placeholder="Password">
					</div>
					<button type="button" class="btn btn-default" href="/list" id="login">Submit</button>
				</form>

			</div>
		</div>
	</div>

</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--jQuery Cookie操作插件--%>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="https://cdn.staticfile.org/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$('#login').click(function (){
			var userId = $('#getName').val();
			$.ajax({
				type: "post",
				url: "login_check",
				data: {
					"userName": $("#getName").val(),
					"userPassword": $("#getPassword").val(),
				},
				dataType: "JSON",
				async: true,
				success: function (data) {
					if(data == 1) {
						$.cookie('UserId', userId, {expires:7,path : '/seckill'});
						alert("登录成功");
						window.location.href = "list";
					} else {
						alert("用户名或密码错误！");
					}
				},
				error: function() {
					alert("提交失败！");
				}
			})
		})
	});
</script>