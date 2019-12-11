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
 * 用于展示分类文章列表查询与跳转，用户点击index.jsp上方的导航栏，可以先进入此servlet查询后跳转进入对应的分类列表
 * 	分页展示
 * Servlet implementation class UiNewsList
 */
@WebServlet("/UiNewsList")
public class UiNewsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UiNewsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentpage = 1;
		request.setCharacterEncoding("utf-8");
		String typename = request.getParameter("typename");
		//typename = new String(typename.getBytes("iso8859-1"),"utf-8");
		try{
			String p = request.getParameter("p");
			currentpage = Integer.valueOf(p);
		}catch (Exception e) {
			// TODO: handle exception
			currentpage =1;
		}
		
		DBHelper Dao = new DBHelper();
		
		//查询全部
		String strSql = "select id from tbnews where tbtypename=? order by id desc ";
		List<Map<String , Object>> listall = null;
		List<Object> params = new ArrayList<Object>();
		params.add(typename);
		try {
			listall = Dao.executeQuery(strSql, params);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//获取分页信息
		Pager pageobj = new Pager();
		pageobj.allrecordcount = listall.size();
		pageobj.pagesize = 6; //每页显示条数
		pageobj.currentpage = currentpage;
		pageobj.urlname = "UiNewsList";
		pageobj.w = "typename=" + typename;
		
		//分页查询
		int startindex = pageobj.pagesize*(pageobj.currentpage-1);
		String strSqlpages = "select * from tbnews where tbtypename=? order by id desc limit "+startindex+", "+pageobj.pagesize+"";
		List<Map<String, Object>> listpage = null;
		
		try {
			listpage = Dao.executeQuery(strSqlpages, params);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String pagestr = pageobj.GetPageInfo();
		request.setAttribute("pagestr", pagestr);
		request.setAttribute("lists", listpage);
		request.getRequestDispatcher("newslist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
