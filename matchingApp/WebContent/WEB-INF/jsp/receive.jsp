<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教科書マッチング</title>
</head>
<body>
<h1>出品物入力</h1>
<form action="/matchingApp/ReceiveServlet" method="post">
教科：<select name="subject">
<option value="Java">Java</option>
<option value="C">C</option>
<option value="Python">Python</option>
</select><br>
教科書名：<input type="text" name="textbookName"><br>
<input type="submit" value="出品">
</form>
</body>
</html>