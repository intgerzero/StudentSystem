package com.studentSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class searchStudentInfo
 */
//@WebServlet("/searchStudentInfo")
public class searchStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("访问servlet");
		try {
			String DBurl="jdbc:mysql://localhost/StudentSystem";
			String DBuser="root";
			String DBpassword="intger_zero087";
			//加载数据库驱动
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				System.out.println("加载数据库驱动异常");
				e.printStackTrace();
			}
			//建立连接
			Connection connection=DriverManager.getConnection(DBurl, DBuser, DBpassword);
			
			PreparedStatement ps=null;
			ResultSet rs=null;
			//HttpSession session=request.getSession();
			//request.setCharacterEncoding("UTF-8");
			//获取参数
			String StudentNo=request.getParameter("StudentNo");
			//设置response的格式
			//String username="14030110086";
			response.setContentType("text/xml;Charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			//获得输出对象
			PrintWriter out=response.getWriter();
			//构建XML头
			out.println("<response>");
			System.out.println(StudentNo);
			ps=connection.prepareStatement("SELECT * FROM StudentInfo WHERE StudentInfo.StudentNo=?");
			ps.setString(1,StudentNo);
			rs=ps.executeQuery();
			System.out.println("查询完成");
//			rs.next();
//			System.out.println("第一字段学号："+rs.getString(1));
//			System.out.println("第一字段学号："+rs.getString(2));
//			System.out.println("第一字段学号："+rs.getString(3));
//			System.out.println("第一字段学号："+rs.getString(4));
			if(rs.next()){
				
				out.println("<studentno>"+rs.getString(1)+"</studentno>");//学号
				out.println("<studentname>"+rs.getString(2)+"</studentname>");//学生姓名
				out.println("<studentcardnumber>"+rs.getString(3)+"</studentcardnumber>");//身份证号
			//	out.println("<studentphone>"+rs.getString(3)+"</studentphone>");//身份证号
				out.println("<studentprince>"+rs.getString(4)+"</studentprince>");//省份
				out.println("<studentsex>"+rs.getString(5)+"</studentsex>");//性别
				out.println("<studentbirthday>"+rs.getString(6)+"</studentbirthday>");//生日
				out.println("<studentphone>"+rs.getString(7)+"</studentphone>");//电话
				out.println("<studentsubject>"+rs.getString(8)+"</studentsubject>");//专业
				out.println("<studentemail>"+rs.getString(9)+"</studentemail>");//邮箱
				out.println("<studentclass>"+rs.getString(10)+"</studentclass>");//班级
				out.println("<studentacademy>"+rs.getString(11)+"</studentacademy>");//学院				
			//	out.println("<studentcardnumber>"+rs.getString(3)+"</studentcardnumber>");//专业
			//	out.println("<studentprince>"+rs.getString(4)+"</studentprince>");//邮箱
				//班级号
				//out.println("<studentemail>"+rs.getString(11)+"</studentemail>");//学院号
			}
			rs.close();
			connection.close();
			out.println("</response>");
			System.out.println("返回界面");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
