<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶメイン</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<form action="/dokoTsubu/Main">
<p><%= user.getName() %>さん、ログイン中
<a>ログアウト</a>
</p>
<a>更新</a>
<input type="text" name="mutter">
<button id="btn-tweet">つぶやく</button>
</form>
</body>
</html>