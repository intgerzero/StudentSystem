package com.studentSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
/**
 * 用来处理AJAX请求，并构建XML文件，用来传递信息
 * @version 1.0
 * 
 *
 */
public class searchCourse extends HttpServlet {

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//建立数据库连接
			String DBurl="jdbc:mysql://localhost/StudentSystem";
			String DBuser="root";
			String DBpassword="intger_zero087";
			//加载数据库驱动
			System.out.println("进入serrch");
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				System.out.println("加载数据库驱动异常");
				e.printStackTrace();
			}
			//建立连接
			Connection con=DriverManager.getConnection(DBurl, DBuser, DBpassword);
			
			request.setCharacterEncoding("UTF-8");
			String StudentNo=request.getParameter("StudentNo");
			String name=request.getParameter("name");
			
			System.out.println("用户名是"+StudentNo);
			System.out.println("课名:"+name);
			
			//设置response的格式
			response.setContentType("text/xml;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
            //获得输出对象，用来构建XML文件,供请求页面解析
			PrintWriter out = response.getWriter();
			out.println("<response>");//构建XML文件头，XML文件包含学生详细学籍信息
		
				
				PreparedStatement ps=null;
				ps=con.prepareStatement("SELECT CourseInfo.CourseNo,CourseInfo.CourseName,CourseInfo.Grade,SC.Result FROM SC,CourseInfo WHERE CourseInfo.CourseNo=SC.CourseNo AND CourseInfo.CourseName=? AND SC.Result!=0 AND SC.StudentNo=?");
				ps.setString(1,name);
				ps.setString(2,StudentNo);
				ResultSet rs=ps.executeQuery();
		//		rs=ps.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					
					out.println("<courseno>"+rs.getString(1)+"</courseno>");
					out.println("<coursename>"+rs.getString(2)+"</coursename>");
					out.println("<coursegrade>"+rs.getString(3)+"</coursegrade>");
					out.println("<result>"+rs.getString(4)+"</result>");
				}
				rs.close();
				con.close();
				
			out.println("</response>");
			out.close();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	public void init() throws ServletException {
		// Put your code here
	}

}