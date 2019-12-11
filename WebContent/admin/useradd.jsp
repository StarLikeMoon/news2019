<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>添加用户功能</title>
	<style type="text/css">
		.continer{
			height:300px;
			width:1000px;
		}
		
		.continer div{
			display:none;
		}
		
		.continer:hover div{
			display:initial;
		}
		
	</style>
</head>
<body>
	<div class = "continer">
		<div>
			作业1：实现增加用户功能<br/>
			提示：实际上是向数据库中写入用户信息，利用DBHelper中的增删改方法实现，可以参照新闻发布页面的实现方法。<br/>
			<br/>
			页面路径：WebContent/admin/useradd.jsp
		</div>
	</div>
	
</body>
</html>