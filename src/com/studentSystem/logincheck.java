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

/**
 * Servlet implementation class logincheck
 */
@WebServlet("/logincheck")
public class logincheck extends HttpServlet {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String DBurl="";
			String DBuser="";
			String DBpassword="";
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
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
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM UserInfo WHERE Name=? AND Password=?");
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
            	session.setAttribute("message","用户名不存在或您选择的身份错误");
            	request.getRequestDispatcher("/Login.jsp").forward(request, response);	
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
