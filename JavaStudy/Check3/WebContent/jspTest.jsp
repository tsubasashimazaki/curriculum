<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3章 チェックテスト</title>
<link rel="stylesheet" href="./CSS/style.css">
</head>
<body>
<%@ include file="header.jsp" %>

<!-- name、idの入力エリアを作成しなさい -->
<table>
   <div>
      <tr>
         <th>name</th>
         <td>
            <input type="text" width="100px"><br>
         </td>
      </tr>
      <tr> 
         <th>id</th>
         <td>
            <input type="text" width="100px">
         </td>
      </tr>
   </div>
</table>
<%@ include file="footer.jsp" %>
</body>
</html>