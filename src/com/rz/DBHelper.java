package com.rz;

import java.sql.*;
import java.util.*;

/**
 *DBHelper.java是封装好的操作数据库指令代码
 *主要有连接数据库的方法，增删改数据库的方法和单条、多条查询数据库的方法
 *
 * @author CHM
 *
 */

public class DBHelper {  //与数据库有关的操作指令
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/cs2019?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static final String USER="root";
	private static final String PWD="root";
	
	public Connection con() {    //该方法用于连接数据库
		Connection conn = null;
		
		try {
			Class.forName(DRIVER);    //导入驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);  //与数据库建立连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//用于关闭对象
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			
		if(rs!=null) {
			rs.close();
		} 
		if (pstmt!=null) {
			pstmt.close();
		}
		if (conn!=null) {
			conn.close();
		}
	}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
		
	
	
	
	/**
	 * 增删改功能
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean executeSql(String sql, List<Object> params) { 
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = con();
			pstmt = conn.prepareStatement(sql);
			if (params!=null) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			res = pstmt.executeUpdate();//返回查询结果
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			closeAll(rs, pstmt, conn);
		}

		return res>0?true:false;
	}
	
	
	/**
	 * 查询多条记录
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
    public List<Map<String, Object>> executeQuery(String sql, List<Object> params) throws SQLException{
    	Connection conn=null;
    	PreparedStatement pstmt = null;
    	ResultSet rs=null;
    	conn=con();
        pstmt=conn.prepareStatement(sql);
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int index = 1;
		pstmt = conn.prepareStatement(sql);
		if(params != null && !params.isEmpty()){
			for(int i = 0; i<params.size(); i++){
				pstmt.setObject(index++, params.get(i));
			}
		}
		rs = pstmt.executeQuery();
		ResultSetMetaData metaData = rs.getMetaData();
		int cols_len = metaData.getColumnCount();
		while(rs.next()){
			Map<String, Object> map = new HashMap<String, Object>();
			for(int i=0; i<cols_len; i++){
				String cols_name = metaData.getColumnName(i+1);
				Object cols_value = rs.getObject(cols_name);
				if(cols_value == null){
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		return list;
	}
	
	
	/**
	 * 查询单条记录
	 * @param sql
	 * @param params
	 * @return
	 */

	
    public Map<String,Object> getSingleObject(String sql,List<Object> params){
        Map<String,Object> map = new HashMap<String,Object>();
        Connection conn=null;
    	PreparedStatement pstmt = null;
    	ResultSet rs=null;
    	conn=con();
        try {
        	pstmt=conn.prepareStatement(sql);
            
        	int index = 1;
        	if(params != null && !params.isEmpty()){
    			for(int i = 0; i<params.size(); i++){
    				pstmt.setObject(index++, params.get(i));
    			}
    		}
            rs = pstmt.executeQuery();
          
            ResultSetMetaData metaData = rs.getMetaData();
    		int cols_len = metaData.getColumnCount();
    		while(rs.next()){
    			for(int i=0; i<cols_len; i++){
    				String cols_name = metaData.getColumnName(i+1);
    				Object cols_value = rs.getObject(cols_name);
    				if(cols_value == null){
    					cols_value = "";
    				}
    				map.put(cols_name, cols_value);
    			}
    		}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
       
            closeAll(rs,pstmt,conn);
        }
        return map;
    }
	
	
}
