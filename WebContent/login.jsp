<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>欢迎登陆成都师范学院信息发布系统</title>
		<style type="text/css">
			body,p,div,ul,li,h1,h2,h3,h4,h5,h6{
				margin:0;
				padding: 0;
			}
			body{
				background: #E9E9E9; 
			}
			#login{
				width: 400px;
				height: 250px;
				background: #FFF;
				margin:200px auto;
				position: relative;
			}
			#login h1{
				text-align:center;
				position:absolute;
				left:10px;
				top:-40px;
				font-size:21px;
			}
			#login p{
				text-align: center;
			}
			#username{
				background:url(img/user.png) rgba(0,0,0,.1) no-repeat;
				width: 230px;
				height: 30px;
				border:solid #ccc 1px;
				border-radius: 3px;
				padding-left: 32px;
				margin-top: 50px;
				margin-bottom: 30px;
			}
			#password{
				background: url(img/pwd.png) rgba(0,0,0,.1) no-repeat;
				width: 230px;
				height: 30px;
				border:solid #ccc 1px;
				border-radius: 3px;
				padding-left: 32px;
				margin-bottom: 30px;
			}
			#btnlogin{
				width: 232px;
				height: 30px;
				background: rgba(0,0,0,.1);
				border:solid #ccc 1px;
				border-radius: 3px;
			}
			#submit:hover{
				cursor: pointer;
				background:#D8D8D8;
			}
		</style>
</head>
<body>
	<form action = "Login" method = "post">
		<div id = "login">
			<h1>成都师范学院信息发布和管理系统V1.0</h1>
				<p><input type = "text" name = "username" id = "username" placeholder="请输入用户名" /></p>
				<p><input type = "password" name = "password" id = "password" placeholder="请输入密码"  /></p>
				<p><input type = "submit" value = "登录" id = "btnlogin"></p>
		</div>
	</form>
</body>
</html>