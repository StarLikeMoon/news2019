package com.rz;

/**
 * 封装Pager类，方法是用来获取分页状态，返回给servlet，计算分页状态
 * @author CHM
 *
 */
public class Pager {
	public int allrecordcount;
	public int allpagecount;
	public int currentpage;
	public int pagesize;
	public String urlname;
	public String w;//额外的跟随参数
	
	public String GetPageInfo()
	{
		String s="总共 "+allrecordcount+" 条记录 每页 "+pagesize+" 条 ";
		if(allrecordcount%pagesize==0)
		{
			allpagecount=allrecordcount/pagesize;
		}
		else
		{
			allpagecount=(allrecordcount/pagesize)+1;
		}
		
		//三元运算，如果currentpage>1，就返回(currentpage - 1)，否则返回1
		int prepage=(currentpage>1)?(currentpage-1):1;
		
		//三元运算，如果currentpage==allpagecount，就返回allpagecount，否则返回(currentpage + 1)
		int nextpage=(currentpage==allpagecount)?allpagecount:(currentpage+1);
		s+="共 "+allpagecount+" 页 当前第 "+currentpage+" 页  ";
		
		if(w==null||"".equals(w))//判断w中有没有信息，是否为空
		{	
			s+="<a href=\""+urlname+"?p=1\">首页</a> <a href=\""+urlname+"?p="+prepage+"\">上一页</a> <a href=\""+urlname+"?p="+nextpage+"\">下一页</a> <a href=\""+urlname+"?p="+allpagecount+"\">末页</a>";
		}
		else
		{
			s+="<a href=\""+urlname+"?p=1&"+w+"\">首页</a> <a href=\""+urlname+"?p="+prepage+"&"+w+"\">上一页</a> <a href=\""+urlname+"?p="+nextpage+"&"+w+"\">下一页</a> <a href=\""+urlname+"?p="+allpagecount+"&"+w+"\">末页</a>";
		}
		
		return s;
	}
	
}
