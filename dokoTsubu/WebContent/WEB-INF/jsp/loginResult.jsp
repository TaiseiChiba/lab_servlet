<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
// セッションスコープからユーザー取得
User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン結果画面</title>
</head>
<body>
<h1>どこつぶログイン</h1>
<% if(user != null) {%>
<p>ログインに成功しました</p>
<p>ようこそ<%= user.getName() %>さん</p>
<a href="/dokoTsubu/Main">つぶやきの投稿閲覧へ</a>
<% } else { %>
<p>ログインに失敗しました</p>
<a href="/dokoTsubu/">トップへ</a><br>
<% } %>
</body>
</html>