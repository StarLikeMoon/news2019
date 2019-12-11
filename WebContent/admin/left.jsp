<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>成都师范学院信息发布系统</title>
		
		<style type="text/css">
			*{
				margin:0;
				padding:0;
			}
			html {
				width: 100%;
				height: 100%;
			}
			
			body {
				width: calc(100% - 1px);
				height: 100%;
				border-right: solid 1px #eee;
				font-size: 12px;
			}
			
			.leftitem {
				width: 100%;
				list-style: none;
				padding-top: 2px;
			}
			
			.leftitem li {
				height: 35px;
				line-height: 35px;
				border-bottom: solid 1px #eee;
			}
			
			.leftitem li a {
				display: block;
				height: 35px;
				line-height: 35px;
				text-decoration: none;
				text-align: left;
				background-image: url(../img/arrow-right.png);
				background-repeat: no-repeat;
				background-size: 15px 15px;
				background-position: 10px 10px;
				padding-left: 30px;
			}
			
			.leftitem li a:hover {
				background-color: #b8c4cb;
				color: white;
			}
		</style>
	</head>

	<body>

		<form name="form1" method="post" action="left.aspx" id="form1">
			<ul class="leftitem" id="leftitem">
                        <li>
					        <a href="logout.jsp"  target="main">退出系统</a>
				        </li>
			</ul>
		</form>
		<script src="../js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			//此函数用来接收参数
		    function getQueryString(name) {
		        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		        var r = window.location.search.substr(1).match(reg);
		        if (r != null) {
		            return unescape(r[2]);
		        }
		    }
		    
		    var id=getQueryString("id");
		    var navstr="<li><a href=\"../LogOut\"  target=\"_top\">退出系统</a></li>";
		    switch(id)
		    {
		    	case "1":navstr="<li><a href=\"useradd.jsp\"  target=\"main\">新增用户</a></li><li><a href=\"userlist.jsp\"  target=\"main\">用户列表</a></li><li><a href=\"../LogOut\"  target=\"_top\">退出系统</a></li>";break;
		    	case "2":navstr="<li><a href=\"aboutus.jsp\"  target=\"main\">学院简介</a></li><li><a href=\"../LogOut\"  target=\"_top\">退出系统</a></li>";break;	
		    	case "3":navstr="<li><a href=\"newsadd.jsp\"  target=\"main\">发布信息</a></li><li><a href=\"../NewsListAtAdmin\"  target=\"main\">信息列表</a></li><li><a href=\"../LogOut\"  target=\"_top\">退出系统</a></li>";break;
		    	
		    }
		    $("#leftitem").html(navstr);
		    window.parent.frames["main"].location.href = "blank.jsp";

		</script>
	</body>

</html>