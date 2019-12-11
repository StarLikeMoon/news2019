<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="java.util.regex.*" %>

<%
  	Map<String, Object> objbyid = (Map<String, Object>)request.getAttribute("objbyid");
 %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>信息中心/信息列表/修改信息</title>
	<link rel="stylesheet" type="text/css" href="admin/css/comm.css">
</head>
<body>
	<form action="NewsEdit" method="post">
			<p class="path">信息中心/信息列表/修改信息</p>
			<input type="hidden" name="id" value="<%=objbyid.get("id")%>"/>
			<table border="0" cellspacing="0" cellpadding="0" class="tb">
				<tr>
					<td class="lable">类别</td><td>
					    <select name="tbtypename">
					    	<option <%=(objbyid.get("tbtypename").equals("学校公告"))?"selected=\"selected\"":""%> value="学校公告">学校公告</option>
					    	<option <%=(objbyid.get("tbtypename").equals("菁菁校园"))?"selected=\"selected\"":""%> value="菁菁校园">菁菁校园</option>
					    	<option <%=(objbyid.get("tbtypename").equals("学校趣闻"))?"selected=\"selected\"":""%> value="学校趣闻">学校趣闻</option>
					    	<option <%=(objbyid.get("tbtypename").equals("班级通知"))?"selected=\"selected\"":""%> value="班级通知">班级通知</option>
					    	<option <%=(objbyid.get("tbtypename").equals("数学建模"))?"selected=\"selected\"":""%> value="数学建模">数学建模</option>
					    	<option <%=(objbyid.get("tbtypename").equals("生活攻略"))?"selected=\"selected\"":""%> value="生活攻略">生活攻略</option>
					    </select>
				    </td>
				</tr>
				<tr>
					<td class="lable">标题</td>
					<td><input type="text" name="tbtitle" value="<%=objbyid.get("tbtitle") %>" /></td></tr>
				<tr>
					<td class="lable">作者</td>
					<td><input type="text" name="tbauthor" value="<%=objbyid.get("tbauthor") %>" /></td></tr>
				<tr>
					<td class="lable">来源</td>
					<td><input type="text" name="tbsource" value="<%=objbyid.get("tbsource") %>" /></td></tr>
				<tr>
					<td class="lable">时间</td>
					<td><input type="text" name="tbcreatetime" value="<%=objbyid.get("tbcreatetime") %>" /></td></tr>
				<tr>
					<td class="lable">内容</td>
					<td><textarea name="tbdetails"><%=objbyid.get("tbdetails")%></textarea></td></tr>
				<tr>
					<td class="lable">&nbsp;</td>
					<td><input type="submit" name="btnsave" value="保存" id="btnsave"/></td></tr>
			</table>
			
		</form>
</body>
</html>