<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<%  
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
String today = sdf.format(date);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>静的インクルード例</title>
</head>
<body>
<h1>静的インクルード例</h1>
<p><%= name %>さんの<%= today %>の運勢は・・・</p>
</body>
</html>