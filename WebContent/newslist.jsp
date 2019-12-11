<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="java.util.regex.*" %>

<%	//拿到后端UiNewsList.java的servlet服务传递过来的lists和pagestr值
	List<Map<String, Object>> lists = (List<Map<String, Object>>)request.getAttribute("lists");
	String pagestr = (String)request.getAttribute("pagestr");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>成都师范学院欢迎您！</title>
	<link rel="stylesheet" type="text/css" href="css/comm.css"/>
	<link rel="stylesheet" type="text/css" href="css/newslist.css"/>
	<link rel="stylesheet" type="text/css" href="css/slide.css"/>
</head>
<body>
	<!-- 页面头部开始-->
	<div class="header">
		<!-- 页面最上方导航栏 -->
		<div class="nav">
			<a href="Index">首页</a>
			<a href="UiNewsList?typename=学校公告">学校公告</a>
			<a href="UiNewsList?typename=菁菁校园">菁菁校园</a>
			<a href="UiNewsList?typename=学校趣闻">学校趣闻</a>
			<a href="UiNewsList?typename=数学建模">数学建模</a>
			<a href="UiNewsList?typename=生活攻略">生活攻略</a>
		</div>
		<!-- 页面头部的图片轮播，在class为ppt的盒子中做一个包含三张图片的轮播效果 -->
		<div class="ppt">
			<div class="pptbox" id="ppt01">
				<ul class="innerwrapper">
					<li><a href="#"><img src="img/1.jpg"></a></li>
					<li><a href="#"><img src="img/2.jpg"></a></li>
					<li><a href="#"><img src="img/3.jpg"></a></li>
				</ul>
				<ul class="controls">
						<li class="current">1</li>
						<li>2</li>
						<li>3</li>
					</ul>			
					<span class="btnleft"></span>
					<span class="btnright"></span>
			</div>
		</div>
	</div>
	<!-- 页面头部结束 -->
	
	<!--主体开始-->
		<div class="main">
			<p class="path">当前位置:信息系统>信息列表 </p>
			<div class="leftnav">
				<!-- 页面左侧导航栏 -->
				<a href="UiNewsList?typename=学校公告" style="border-top: solid 1px #eee;">学校公告</a>
				<a href="UiNewsList?typename=菁菁校园">菁菁校园</a>
				<a href="UiNewsList?typename=学校趣闻">学校趣闻</a>
				<a href="UiNewsList?typename=班级通知">班级通知</a>
				<a href="UiNewsList?typename=数学建模">数学建模</a>
				<a href="UiNewsList?typename=生活攻略">生活攻略</a>
			</div>
			<div class="rightlist">
				<ul>
					 <%for (Map<String, Object> m : lists) { %>
					<li><a href="NewsView?id=<%=m.get("id")%>"><%=m.get("tbtitle")%></a><span><%=m.get("tbcreatetime")%></span></li>
					<%}%>
					
				</ul>
				<div style="margin:20px 0; "><%=pagestr%></div>
			</div>
		</div>
	<!--主体结束-->
	
	<!--底部开始-->
		<div class="footer">
			<p class="firstline">地址：中国四川成都市温江区海科路东段99号 邮编：611130</p>
			<p>蜀ICP备05003610号 川公网安备 51010702001372号</p>
			<p>成都师范学院版权所有</p>
		</div>
	<!--底部结束-->
	
	<!-- 调用JQuery库控制页面动态效果 -->
	<script src="js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/tyslide.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
			
			$("#ppt01").tyslide({
				boxh:250,//盒子的高度
				w:1200,//盒子的宽度
				h:250,//图片的高度
				isShow:true,//是否显示控制器
				isShowBtn:true,//是否显示左右按钮
				controltop:5,//控制按钮上下偏移的位置,要将按钮向下移动   首先保证boxh 高度>图片 h
				controlsW:60,//控制按钮宽度
				controlsH:10,//控制按钮高度
				radius:0,//控制按钮圆角度数
				controlsColor:"#eee",//普通控制按钮的颜色
				controlsCurrentColor:"#ff6600"//当前控制按钮的颜色
			});
	</script>
</body>
</html>