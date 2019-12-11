<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="java.util.regex.*" %>
<%
	List<Map<String, Object>> lists = (List<Map<String, Object>>)request.getAttribute("lists");
	String pagestr = (String)request.getAttribute("pagestr");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>信息中心/信息列表</title>
	<link rel="stylesheet" type="text/css" href="admin/css/comm.css"/>
</head>
<body>
	<p class="path">信息中心/信息列表</p>
	<table border="0" cellspacing="0" class="tb tblist">
		<tr>
			<td style="width:50px;">ID</td>
			<td>标题</td>
			<td style="width:80px;">类别</td>
			<td style="width:80px;">作者</td>
			<td style="width:80px;">来源</td>
			<td style="width:120px;">时间</td>
			<td style="width:80px;">操作</td>
		</tr>
		<% for (Map<String, Object> m : lists) {%>
		<tr>
			<td><%= m.get("id") %></td>
			<td><%= m.get("tbtitle") %></td>
			<td><%= m.get("tbtypename") %></td>
			<td><%= m.get("tbauthor") %></td>
			<td><%= m.get("tbsource") %></td>
			<td><%= m.get("tbcreatetime") %></td>
			<td><a href="NewsEdit?id=<%=m.get("id")%>">修改</a> <a href="NewsDelete?id=<%=m.get("id")%>">删除</a></td>
		</tr>
		<% } %>
	</table>
	
	<div class="pager">
       		<%=pagestr%>
    </div>
</body>
</html>