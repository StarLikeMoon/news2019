package com.rz;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于登录验证的servlet
 * @author CHM
 *
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		DBHelper Dal = new DBHelper();    //创建DBHelper类
		String strSql = "select * from tbusers where username=? and password=?";
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		params.add(password);
		List<Map<String, Object>> userlist = null;
		try {
			userlist = Dal.executeQuery(strSql, params);   //调用DBHelper中的executeQuery方法， 该方法是用于数据库多条信息查询
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (userlist.size()>0) {      //看返回值是不是有该用户，有该用户会有返回值，如果没有返回值说明数据库没有该用户
			response.sendRedirect("admin/default.jsp");  //登陆成功，跳转index页面
		}else {
			response.sendRedirect("login.jsp");  //登录失败，刷新当前登录页
		}
		
	}

}
