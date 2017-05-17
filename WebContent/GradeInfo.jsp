<%@ page language="java" import="java.util.*,java.sql.*,javax.sql.*,javax.naming.*,com.studentSystem.*" pageEncoding="UTF-8"%>
<html>
<head>
   	
   <link rel="stylesheet" type="text/css" href="style.css">
   	<style type="text/css">
   	#mainwrapper 
   	{
   	     width:100%;
   		 height:95%;
   	} 
   
    #content 
    {
    	 overflow:hidden;
    	 float:right;
    	 background:#EE7621;
    	 width:80%;
    	 height:95%;
    }
    #content iframe{
    	 width:100%;
    	 height:100%;
    	 border: 0px;
    }
    #sidebar
    { 
    	overflow:hidden;
    	float:left;
    	background:#2268c8;
    	width:20%;
    	height:95%;
    }
	</style>
</head>
 <body>
	   <div id="mainwrapper">
	   	  <div id="sidebar">
	   	  	<ul>
	   	  	<!--注意iframe里的id和name要相同，且嵌套的html的iframe的id必须不同 -->
	   	  		<li><a href="Grade.jsp" target="show_grade" ><span>查询成绩 </span> </a>
	   	  		<li><a href="All_Grade.jsp" target="show_grade">显示所有已修课程成绩</a></li>
	   	  	</ul>
	   	  </div>
	     <div id="content">
	        <iframe id="show_grade" name="show_grade" ></iframe>
	   	 </div>
	   </div>
	   <div id="footer">
    	<div id="copy">
		   <div id="copyright">
			 <p>CopyRight&copy;2016</p>
			 <p>西安电子科技大学</p>
			</div>
		</div>
	</div>
 </body>
</html>