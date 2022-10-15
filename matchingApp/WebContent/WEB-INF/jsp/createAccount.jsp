<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教科書マッチング</title>
</head>
<body>
<h1>アカウント新規登録</h1>
<form action="/matchingApp/AccountServlet" method="post">
ユーザーID：<input type="text" name="userId"><br>
パスワード：<input type="password" name="password"><br>
     名前：<input type="text" name="name"><br>
<input type="submit" value="登録">
</form>
</body>
</html>