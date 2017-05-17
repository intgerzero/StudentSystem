<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%!
   String username;
%>
<%
   username=(String)session.getAttribute("userid");
%>
<html>
<head>
   <title>学生信息界面 </title>
   	<style type="text/css">
		#main
		{
		 background-image:url(iframe.jpg);
		 background-repeat:no-repeat;
         text-align:center ;
	     overflow:hidden;
         width: 100%;
	     height:85%;
        }
        #main iframe{
        	width:100%;
        	height: 100%;
        	border:0px;
        }
		</style>
</head>


<body>

	<div id="head" >
	    <div id="status">
	      <form action="Studentservlet" method="post">
	      	当前用户：<%=username%>
	        <input type="submit" name="submit" value="注销">
	      </form>
        </div>
        <div id="menu">
	        <h2>Welcome to Student System!</h2>
	         <a href="index.jsp" >首页</a>
	         <a href="StudentInfo.jsp" target="show" ><span>个人信息</span></a>
	         <a href="CourseInfo.jsp" target="show"><span>选课查询 </span></a>
	         <a href="GradeInfo.jsp" target="show"><span>成绩查询 </span></a>
	    </div>
    </div>
    
    <div id="main" >
	  <iframe id="show" name="show" src=""></iframe>
	</div>
    
    <div id="footer">
    	<div id="copy">
		   <div id="copyright">
			 <p>CopyRight&copy;2017</p>
			 <p>西安电子科技大学</p>
			</div>
		</div>
	</div>
    </body>
</html>
