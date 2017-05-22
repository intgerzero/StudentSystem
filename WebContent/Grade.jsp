 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%!
   String StudentNo;   
%>
<% 
StudentNo=(String)session.getAttribute("StudentNo");
%>
<html>
  <head>
   <link rel="stylesheet" type="text/css" href="style.css">
   <style type="text/css">
    #main{
      width: 100%;
      height:95%;
    }
    #complete_table{
      background-color:#FFFAFA;
      border:0px;
    }
    </style>
   
  </head>
  <body>
  <div id="main">
      <h1>查询成绩</h1> 
     <table>
     <tr>
           <td>输入课程名:</td>
           <td>
            <input type="text" id="names">
            <input type="button" id="search" onclick="searchResult();" value="确 定">
           </td>
     </tr>
     <tr>
         <td height="20">课程情况
         </td>
         <td height="80">
           <table border="1">
            <tr>
              <td>课程号</td>
              <td>课程名</td>
              <td>学分</td>
              <td>成绩</td>
            </tr>         
            <tr>
              <td><input type="text" id="content1" readonly="true"></td>
              <td><input type="text" id="content2" readonly="true"></td>
              <td><input type="text" id="content3" readonly="true"></td>
              <td><input type="text" id="content4" readonly="true"></td>
            </tr>
            </table>
         </td>   
     </tr>
     </table>
     </div>
     <div id="footer">
      <div id="copy">
       <div id="copyright">
       <p>CopyRight&copy;2016</p>
       <p>西安电子科技大学</p>
      </div>
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
        function searchResult()
        {
        	createXMLHttpRequest();
        	 var url="searchCourse?name="+document.getElementById("names").value+"&StudentNo="+<%=StudentNo%>;
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
                var courseno=XMLHttpReq.responseXML.getElementsByTagName("courseno");
                var coursename=XMLHttpReq.responseXML.getElementsByTagName("coursename");
                var coursegrade=XMLHttpReq.responseXML.getElementsByTagName("coursegrade");
                var result=XMLHttpReq.responseXML.getElementsByTagName("result");
                if(courseno.length>0&&courseno.length>0&&coursename.length>0&&coursegrade.length>0&&result.length>0)
                {
                   document.getElementById("content1").value=courseno[0].firstChild.data;
                   document.getElementById("content2").value=coursename[0].firstChild.data;
                   document.getElementById("content3").value=coursegrade[0].firstChild.data;
                   document.getElementById("content4").value=result[0].firstChild.data;
                }
             }
          }
        }
   </script>
  </body>
</html>
