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
 * admin/newsadd.jsp中编辑已发布的文章时调用的servlet，用来将文章修改后的数据写入数据库中
 * Servlet implementation class NewsEdit
 */
@WebServlet("/NewsEdit")
public class NewsEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 管理平台admin/newslistAtadmin.jsp中的编辑操作，需要调用本servlet对数据库进行操作
     * @see HttpServlet#HttpServlet()
     */
    public NewsEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//拿到前端用户点击编辑的文章的id，从数据库中搜索到该文章的具体内容，跳转到newsedit.jsp页面供用户编辑修改
		String id=request.getParameter("id");
		DBHelper Dao = new DBHelper();
		String strSql = "select * from tbnews where id = ?";
		Map<String, Object> objbyid = null;
		
		List<Object> params = new ArrayList<>();
		params.add(id);
		
		objbyid = Dao.getSingleObject(strSql, params);
		request.setAttribute("objbyid", objbyid);
		request.getRequestDispatcher("/admin/newsedit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String tbtypename = request.getParameter("tbtypename");
		String tbtitle = request.getParameter("tbtitle");
		String tbauthor = request.getParameter("tbauthor");
		String tbsource = request.getParameter("tbsource");
		String tbcreatetime = request.getParameter("tbcreatetime");
		String tbdetails = request.getParameter("tbdetails");
		String strSql = " update tbnews set tbtypename=?,tbtitle=?,tbauthor=?,tbsource=?,tbcreatetime=?,tbdetails=? where id=? ";
		
		List<Object> params = new ArrayList<>();
		params.add(tbtypename);
		params.add(tbtitle);
		params.add(tbauthor);
		params.add(tbsource);
		params.add(tbcreatetime);
		params.add(tbdetails);
		params.add(id);
		
		DBHelper Dao = new DBHelper();
		Dao.executeSql(strSql, params);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write("<font color='green'>保存成功,3秒之后发生跳转!</font>");
		response.setHeader("Refresh", "3;URL="+request.getContextPath()+"/NewsListAtAdmin");
	}

}
