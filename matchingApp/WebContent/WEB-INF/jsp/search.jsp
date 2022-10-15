<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<% List<Receive> list = (List<Receive>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教科書マッチング</title>
</head>
<body>
<h1>教科書一覧</h1>
<% if(list != null && list.size()>0){ %>
<table border="1">
  <thead>
    <tr>
      <th>教科名</th><th>教科書名</th><th>出品者名</th><th>交渉</th>
    </tr>
  </thead>
<%for(Receive r:list){ %>
<tr>
<td><%=r.getSubject() %></td>
<td><%=r.getTextbookName() %></td>
<td>---</td>
<td><button>交渉</button></td>
</tr>
<%} %>
</table>
<%} %>
<a href="/matchingApp/WelcomeServlet">トップへ</a>
</body>
</html>