<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="sampleGetStatusProxyid" scope="session" class="org.anjana.GetStatusProxy" />
   
<%
String status = null;
if (request.getParameter("news")==null)
{
	status="Results appear here";
}
else
{
	 String News_content=  request.getParameter("news");
     java.lang.String content = null;
 if(!News_content.equals("")){
  content  = News_content;
  content = content.trim().replaceAll(" +", " ").replace(" ", "/");
 }
 java.lang.String getNewsStatus = sampleGetStatusProxyid.getNewsStatus(content);
 
 if (getNewsStatus!=null) {
	 status = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getNewsStatus));
 }

}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ENTER NEWS HERE</title>
</head>
<body>
<img src="Rumors.jpg" height="200px" width="500px"/><br><br>
<h3>Want to know if something you heard is true or not? Find out here!</h3><br>
<form action="FindStatus.jsp">
<textarea name="news" rows="10" cols="50"></textarea><br><br>
<input type="submit" value="GO!"/>
</form>
<p>
<%=status %>
</p>
</body>
</html>