<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教科書マッチング</title>
</head>
<body>
<h1>ログイン画面</h1>
<form action="/matchingApp/LoginServlet" method="post">
ユーザーID：<input type="text" name="userId"><br>
パスワード：<input type="password" name="password"><br>
<input type="submit" value="ログイン">
</form>
</body>
</html>