<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>成都师范学院信息发布系统V1.0</title>
		<link rel="stylesheet" type="text/css" href="../css/comm.css" />
		<style type="text/css">
			.linear {
				width: 100%;
				height: 100px;
				background-color: #0044C0;
			}
			
			.nav {
				width: 100%;
				height: 34px;
				list-style: none;
				background-color: white;
				border-bottom: solid 1px #0044C0;
			}
			
			.nav li {
				float: left;
				height: 30px;
				position: relative;
				background-color: #0044C0;
				margin-right: 3px;
				margin-top: 2px;
				border-top-left-radius: 0px;
				border-top-right-radius: 15px;
				background-image: url(../img/aixin.png);
				background-repeat: no-repeat;
				background-position: 1px 6px;
			}
			
			.nav li a {
				text-decoration: none;
				padding: 0 20px;
				line-height: 30px;
				color: white;
				display: block;
			}
			
			.timeanduser {
				width:220px;
				text-align: right;
				height: 60px;
				position: absolute;
				right:5px;
				top: 20px;
				font-size: 12px;
				padding-right: 10px;
				padding-top: 10px;
				color: white;
				border-radius: 5px;
				background-color:#397FFF;
				border-bottom-right-radius: 0;
				border-top-right-radius: 0;
				box-shadow: 0 0 10px 1px #fff;
				line-height: 22px;
			}
			
			#currentuser{
				/*background-image: url(img/logout.png);*/
				background-repeat: no-repeat;
				background-size:18px auto;
				background-position:right 5px;
				padding-right: 30px;
                position:relative;
			}
		    #logout {
		    
            }
             #logout  img{
		        width:20px;
                height:20px;
                position:absolute;
                right:0px;
                top:1px;
            }
		</style>

	</head>

	<body>
		<form name="form1" method="post" action="top.aspx" id="form1">
			<div class="linear">
				<img src="../img/logo.jpg" style="height:100px;" />
			</div>
			<ul class="nav">
				
                        <li>
					        <a href="left.jsp?id=1" target="left">系统设置</a>
				        </li>
                    	<li>
					        <a href="left.jsp?id=2" target="left">关于我们</a>
				        </li>  
                        <li>
					        <a href="left.jsp?id=3" target="left">信息中心</a>
				        </li>                                           
				        <li>
					        <a href="../Index" target="_blank">预览首页</a>
				        </li>
                 <li> <a href="/news2019/LogOut" target="_top" >退出系统</a></li>
			</ul>
			<div class="timeanduser">
				<p id="timecontainer"></p>
				<p id="currentuser">当前用户: 【admin】<a href="/news2019/LogOut" target="_top" id="logout" title="退出系统"><img src="../img/logout5.png"></a> </p>
			</div>
		</form>

		<script type="text/javascript">
		    t();

		    function t() {
		        var obj = document.getElementById('timecontainer');
		        var now = new Date();
		        var yy = now.getFullYear();
		        var mm = now.getMonth() + 1;
		        var dd = now.getDate();
		        var hhh = now.getHours();
		        var mmm = now.getMinutes();
		        var sss = now.getSeconds();
		        if (mm < 10) mm = "0" + mm;
		        if (dd < 10) dd = "0" + dd;
		        if (hhh < 10) hhh = "0" + hhh;
		        if (mmm < 10) mmm = "0" + mmm;
		        if (sss < 10) sss = "0" + sss;
		        var week;
		        if (now.getDay() == 0) week = "星期日";
		        if (now.getDay() == 1) week = "星期一";
		        if (now.getDay() == 2) week = "星期二";
		        if (now.getDay() == 3) week = "星期三";
		        if (now.getDay() == 4) week = "星期四";
		        if (now.getDay() == 5) week = "星期五";
		        if (now.getDay() == 6) week = "星期六";
		        var time = yy + "年" + mm + "月" + dd + "日 " + hhh + ":" + mmm + ":" + sss + " " + week;
		        obj.innerHTML = time;
		        setTimeout('t()', 1000);
		    }
		</script>
	</body>

</html>