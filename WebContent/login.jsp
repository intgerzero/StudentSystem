<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String message=(String)session.getAttribute("message");
if(message!=null){
%>
<script type="text/javascript">
	alert("<%=message%>");
</script>
<%
session.removeAttribute("message");
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学籍管理系统登录界面</title>
<style type="text/css">
	   	*{
      margin:0 auto;
      font-family: "Microsoft YaHei";
    }
   	#myForm {
	   width:400px;
	   height:200px;
	   position:absolute;
	   top:40%;
	   left:50%;
	   margin:-150px 0 0 -200px;
	   background:#FFF;
	   border:3px solid #999;
	   border-radius:10px;
      }
     #main
   	{
   	   height:90%;
   	}
   	#footer
   	{
   	   height:10%;
   	}
</style>
</head>
<body align="center">
	<div align="center" id="main">
		<marquee behavior="alternate" direction="left">---------欢迎使用学籍管理系统--------</marquee>
		<form action="logincheck" method="post" id="myForm">
			<h2>用户登录</h2>
			<table>
				<tr>&nbsp;</tr>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="UserID" size="20"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="UserPWD" size="20"></td>
				</tr>
				
				<tr>&nbsp;</tr>
				
				<tr>
					<td><input type="submit" value="提交" ></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
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