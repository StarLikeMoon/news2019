<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>信息系统/信息中心/发布信息</title>
	<link rel="stylesheet" type="text/css" href="css/comm.css"/>
</head>
<body>
	<form action = "../NewsAdd" method = "post">
		<p class="path">信息中心/发布信息</p>
		<table border="0" cellspcaing="0" cellpadding="0" class="tb"> 
		<!-- cellspcaing="0"  cellpadding="0" 是为了让单元格之间没有空隙和填充-->
			<tr>
				<td class="lable">类别</td>
				<td>
					<select name="tbtypename">
						<option value="学校公告">学校公告</option>
						<option value="菁菁校园">菁菁校园</option>
						<option value="学校趣闻">学校趣闻</option>
						<option value="班级通知">班级通知</option>
						<option value="数学建模">数学建模</option>
						<option value="生活攻略">生活攻略</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="lable">标题</td>
				<td><input type="text" name="tbtitle"></td>
			</tr>
			<tr>
				<td class="lable">作者</td>
				<td><input type="text" name="tbauthor"></td>
			</tr>
			<tr>
				<td class="lable">来源</td>
				<td><input type="text" name="tbsource"></td>
			</tr>
			<tr>
				<td class="lable">时间</td>
				<td><input type="date" name="tbcreatetime"></td>
			</tr>
			<tr>
				<td class="lable">内容</td>
				<td><textarea name="tbdetails"></textarea></td>
			</tr>
			<tr>
				<td class="lable">&nbsp;</td>
				<td><input type="submit" name="btnsave" value="保存" id="btnsave"></td>
			</tr>
		</table>
	</form>
</body>
</html>