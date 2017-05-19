package com.studentSystem;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import java.sql.*;


// Servlet implementation class logincheck
//@WebServlet("/logincheck")
public class logincheck extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
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
			
			//从表单中提取登录者id,密码
			String username=request.getParameter("UserID");
			String password=request.getParameter("UserPWD");
			//建立session用来持久化
			HttpSession session=request.getSession();
			session.setAttribute("userid",username);
			session.setAttribute("userpwd", password);
			
			//查询数据库中userinfo表查看是否有该用户
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM UserInfo WHERE StudentNo=? AND Password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			boolean flag=rs.next();
			if (flag) {
				request.setAttribute("success",username+password);
            	request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else 
            {
            	session.setAttribute("message","用户名不存在或密码错误");
            //	request.getRequestDispatcher("/login.jsp");
            	request.getRequestDispatcher("/login.jsp").forward(request, response);	
            }
			rs.close();
			ps.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
