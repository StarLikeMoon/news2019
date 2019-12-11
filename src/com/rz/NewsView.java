package com.rz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 本servlet作用是当用户点击index.jsp中的新闻列表中的某新闻时，servlet读取数据库中的新闻内容，跳转到newsview.jsp中展示给用户
 * Servlet implementation class NewsView
 */
@WebServlet("/NewsView")
public class NewsView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String strSql="select * from tbnews where id=? ";		
		DBHelper dal=new DBHelper(); 
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		//根据新闻的id到数据库查询对应的新闻内容，查出来是单条，不再是列表，所以用getSingleObject方法
		Map<String, Object> newbyid=dal.getSingleObject(strSql, params);
		request.setAttribute("newbyid", newbyid);
		//把结果返回给前端jsp页面
		request.getRequestDispatcher("newsview.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
