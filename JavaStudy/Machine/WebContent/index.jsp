<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.MachineBean"%>
<%
    // 問① getAttributeに適切な引数をセットして、EmployeeControllerから渡されたBeanを取得する。
    // ここでリクエストスコープを受け取る

    // ここ!!!
/*     EmployeeBean employeeBean = (EmployeeBean) request.getAttribute("MachineBean");// getAttribute:取得したい属性の名前
 */    MachineBean machineBean = (MachineBean) request.getAttribute("MachineBean");// getAttribute:取得したい属性の名前
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索結果</title>

</head>
<body>
    <div align="center">
        <!-- 検索が成功した場合の表示 -->
        <%
            if (machineBean != null) {
        %>
        <table border="1">
            <tr>
                <th>飲み物</th>
                <td><%=machineBean.getName()%></td>
            </tr>
            <tr>
                <th>金額</th>
                <td><%=machineBean.getPrice()%></td>
            </tr>
        </table>
        <!-- 問②  それ以外の表示（エラーの場合）-->
        <% } else { %>
		お金が足りません。
        <% } %>
    </div>
</body>
</html>