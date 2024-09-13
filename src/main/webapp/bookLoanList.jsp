<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sách đang mượn/đã trả</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }


        table {
            width: 100%;
            border-collapse: collapse;
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        table th {
            background-color: #f4f4f4;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Danh sách sách ${status == 'returned' ? 'đã trả' : 'đang mượn'}</h1>
    <table>
        <thead>
        <tr>
            <th>Mã Mượn</th>
            <th>Tên Sách</th>
            <th>Học Sinh</th>
            <th>Ngày Mượn</th>
            <th>Ngày Trả</th>
            <th>Trạng Thái</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookLoans}" var="loan">
            <tr>
                <td>${loan.maMuonSach}</td>
                <td>${loan.tenSach}</td>
                <td>${loan.hoTen}</td>
                <td><fmt:formatDate value="${loan.ngayMuon}" pattern="dd/MM/yyyy" /></td>
                <td><fmt:formatDate value="${loan.ngayTra}" pattern="dd/MM/yyyy" /></td>
                <td>${loan.trangThai}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
