package com.rz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * admin/newsadd.jsp中删除文章时调用的servlet，用来将文章从数据库中删除
 * Servlet implementation class NewsDelete
 */
@WebServlet("/NewsDelete")
public class NewsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		
		 String id=request.getParameter("id");
		 DBHelper Dao=new DBHelper();
		 String strSql="delete from tbnews where id=?"; 
		 List<Object> params = new ArrayList<Object>();
		 params.add(id);
		 Dao.executeSql(strSql, params);
		 response.sendRedirect("NewsListAtAdmin");//重定向到列表页面 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
