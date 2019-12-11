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
 * admin/newsadd.jsp中添加文章时调用的servlet，用来将文章添加到数据库中
 * Servlet implementation class NewsAdd
 */
@WebServlet("/NewsAdd")
public class NewsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//拿到jsp页面用户输入的内容
		String add_tbtypename = request.getParameter("tbtypename");
		String add_tbtitle = request.getParameter("tbtitle");
		String add_tbauthor = request.getParameter("tbauthor");
		String add_tbcreatetime = request.getParameter("tbcreatetime");
		String add_tbsource = request.getParameter("tbsource");
		String add_tbdetails = request.getParameter("tbdetails");
		
		
		//将内容存储到params数组中
		List<Object> params = new ArrayList<Object>();
		params.add(add_tbtypename);
		params.add(add_tbtitle);
		params.add(add_tbauthor);
		params.add(add_tbsource);
		params.add(add_tbcreatetime);
		params.add(add_tbdetails);
		
		//新建DBHelper类，操作数据库
		DBHelper Dao = new DBHelper();
		
		//操作指令
		String strSql = "insert into tbnews (tbtypename, tbtitle, tbauthor, tbsource, tbcreatetime, tbdetails) values (?, ?, ?, ?, ?, ?)";
		Dao.executeSql(strSql, params);
		
		//操作完成后给前端一个反馈
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8 ");
		response.getWriter().write("<font color='green'>保存成功，5秒之后跳转到新增页面继续发布</font>");
		response.setHeader("Refresh", "5;URL="+request.getContextPath()+"/admin/newsadd.jsp");
	}

}
