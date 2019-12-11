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
 * 本servlet用于index.jsp首页的分类新闻列表数据库获取操作和数据传输
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// 函数的功能：可以根据新闻的类别名称返回新闻裂变
	protected List<Map<String, Object>> GetNewsListByTypeName(String tbtypename) {
		List<Map<String, Object>>  allnewslist = null;
		List<Object> params = new ArrayList<Object>();
		params.add(tbtypename);   //根据新闻类别查询数据库
		DBHelper Dao = new DBHelper();
		String strSqlpage = "select * from tbnews where tbtypename=? order by id desc limit 0,7";  //查询符合新闻分类的新闻列表，并按降序规则取前7个新闻用于展示
		try {
			allnewslist = Dao.executeQuery(strSqlpage, params);   //将查询到的新闻存到allnewslist中
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return allnewslist;
		
	}
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用函数6次，每次传递不同的新闻分类，返回6个模块的新闻列表
		List<Map<String, Object>> list1 = GetNewsListByTypeName("学校公告");
		List<Map<String, Object>> list2 = GetNewsListByTypeName("菁菁校园");
		List<Map<String, Object>> list3 = GetNewsListByTypeName("学校趣闻");
		List<Map<String, Object>> list4 = GetNewsListByTypeName("班级通知");
		List<Map<String, Object>> list5 = GetNewsListByTypeName("数学建模");
		List<Map<String, Object>> list6 = GetNewsListByTypeName("生活攻略");
		
		//将6个模块的新闻列表分别加入到request对象中，用于jsp前端调用展示
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list4", list4);
		request.setAttribute("list5", list5);
		request.setAttribute("list6", list6);
		request.getRequestDispatcher("index.jsp").forward(request, response); //跳转返回到index.jsp
	}

}
