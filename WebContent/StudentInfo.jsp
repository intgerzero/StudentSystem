<%@ page language="java" import="java.util.*,java.sql.*,javax.sql.*,javax.naming.*,javax.servlet.http.HttpSession" pageEncoding="UTF-8"%>
<%
String username;
username=(String)session.getAttribute("userid");
%>
<%! 
String Photo;
%>
<html>
<head>
   <title>个人信息界面 </title>	
   	<style type="text/css">
   	#mainwrapper 
   	{
   	     width:100%;
   		 height:100%;
   	} 
   
    #content 
    {
    	 overflow:hidden;
    	 float:right;
    	 background:#FFF68F;
    	 width:80%;
    	 height:800px;
    }
    #sidebar
    { 
    	overflow:hidden;
    	float:left;
    	background:#C1C1C1;
    	width:20%;
    	height:800px;
    }
	</style>
</head>
 <body>
	   <div id="mainwrapper">
	   	  <div id="sidebar">
	   	  	<ul>
	   	  	<!--注意iframe里的id和name要相同，且嵌套的html的iframe的id必须不同 -->
	   	  		<li> <input type="button" id="getStudentInfo" onclick="getStudentInfo();" value="生成个人简历"></li>
	   	  		<li> <input type="button" id="changeStudentInfo" onclick="changeStudentInfo();" value="修改个人信息"></li>
	   	  	</ul>
	   	  </div>
	     <div id="content">
	     	       <h2>&nbsp;&nbsp;&nbsp;个人简历界面</h2> <br>
    <table border=1 >
      <tr>
       	<td>学号：</td>
       <td><input type="text" id="StudenNo" readonly="true"></td>
       	<td>姓名：</td>
       <td><input type="text" id="Name" readonly="true"></td>
      </tr>
      <tr>
       	<td>身份证号：</td>
        <td><input type="text" id="CarNo" readonly="true"></td>
       	<td>省份：</td>
       	<td><input type="text" id="Prince" readonly="true"></td>
      </tr>
      <tr>
       	<td>性别：</td>
       	 <td><input type="text" id="sex" readonly="true"></td>
       	<td>出生年月</td>
       	 <td><input type="text" id="birthday" readonly="true"></td>
      </tr>
      <tr>
       	<td>联系电话：</td>
       	 <td><input type="text" id="phone" readonly="true"></td>
       	<td>专业：</td>
       	<td><input type="text" id="subject" readonly="true"></td>
      </tr>
      <tr>
       	<td>班级：</td>
       	 <td><input type="text" id="classnumber" readonly="true"></td>
       	<td>电子邮箱：</td>
       	 <td><input type="text" id="Email" readonly="true"></td>
      </tr>
       <tr>
       	<td>学院：</td>
        <td><input type="text" id="Academy" readonly="true"></td>
      </tr>
      <tr>
        <td>照片</td>
        <td><img src=<%=Photo%>></td>
      </tr>
    </table>
	   	 </div>
	   </div>
	   
    <script language="javascript">
        var XMLHttpReq;
        function createXMLHttpRequest()
        {
            if(window.XMLHttpRequest)
            {
             XMLHttpReq=new XMLHttpRequest();
            }
            else if(window.SctiveXObject)
            {
                 try
                 {
                    XMLHttpReq=new ActiveXObject("Msxm12.XMLHTTP");     
                 }
                 catch(e)
                 {
                     try{
                       XMLHttpReq=new ActiveXObject("Microsoft.XMLHTTP");
                     }catch(e){}
                 }
            }
        }     
        function getStudentInfo()
        {
           createXMLHttpRequest();
           var url="autoComplete?username="+<%=username%>;
           XMLHttpReq.open("GET",url,true);
           XMLHttpReq.onreadystatechange=processSearchResponse;
           XMLHttpReq.send(null);
        }
        function processSearchResponse()
        {
          if(XMLHttpReq.readyState==4)
          {
             if(XMLHttpReq.status==200)
             {
                var StudentNo=XMLHttpReq.responseXML.getElementsByTagName("StudentNo");
                var Name=XMLHttpReq.responseXML.getElementsByTagName("Name");
                var CardNo=XMLHttpReq.responseXML.getElementsByTagName("CardNo");
                var Prince=XMLHttpReq.responseXML.getElementsByTagName("Prince");
                if(StudentNo.length>0&&Name.length>0&&CardNo.length>0&&Prince.length>0)
                {
                   document.getElementById("StudentNo").value=StudentNo[0].firstChild.data;
                   document.getElementById("Name").value=Name[0].firstChild.data;
                   document.getElementById("CardNo").value=CardNo[0].firstChild.data;
                   document.getElementById("Prince").value=Prince[0].firstChild.data;
                }
             }
          }
        }
   </script>
 </body>
</html>