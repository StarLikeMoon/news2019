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
 * 用于default.jsp管理页面中的信息中心/信息列表中的新闻列表展示
 * Servlet implementation class NewsListAtAdmin
 */
@WebServlet("/NewsListAtAdmin")
public class NewsListAtAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsListAtAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentpage=1;
		try{
			String p=request.getParameter("p"); 
			currentpage = Integer.valueOf(p);
		}
		catch(Exception e){
			currentpage=1;
		}
		
		//查询全部
		String strSql = "select * from tbnews order by id desc ";
		List<Map<String, Object>> listall = null;
		List<Object> params = new ArrayList<Object>();
		DBHelper Dao = new DBHelper();
		try {
			listall = Dao.executeQuery(strSql, params);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//获取分页信息
		Pager pageobj = new Pager();
		pageobj.allrecordcount = listall.size();
		pageobj.pagesize = 10; //每页显示条数
		pageobj.currentpage = currentpage;
		pageobj.urlname = "NewsListAtAdmin";
		
		//分页查询
		int startindex=pageobj.pagesize*(pageobj.currentpage-1);
		String strSqlpager=" select * from tbnews order by id desc limit "+startindex+","+pageobj.pagesize+""; 
		List<Map<String, Object>> listpage = null;
		try {
			listpage=Dao.executeQuery(strSqlpager, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String pagestr=pageobj.GetPageInfo();		
		request.setAttribute("pagestr", pagestr);
		request.setAttribute("lists", listpage);
		request.getRequestDispatcher("/admin/newslistAtadmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
