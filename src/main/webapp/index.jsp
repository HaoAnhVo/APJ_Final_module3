<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Sách</title>
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
            margin-top: 30px;
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

        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            border: none;
            background-color: #007bff;
            color: #ffffff;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .btn:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }

    </style>
</head>
<body>
<h1>Danh sách Sách</h1>
<c:if test="${not empty message}">
    <div class="alert">${message}</div>
</c:if>
<a href="bookLoanServlet?status=onLoan" class="btn">Xem danh sách sách đang cho mượn</a>
<a href="bookLoanServlet?status=returned" class="btn">Xem danh sách sách đã trả</a>
<table>
    <thead>
    <tr>
        <th>Mã Sách</th>
        <th>Tên Sách</th>
        <th>Tác Giả</th>
        <th>Số Lượng</th>
        <th>Mô Tả</th>
        <th>Hành Động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.maSach}</td>
            <td>${book.tenSach}</td>
            <td>${book.tacGia}</td>
            <td>${book.soLuong}</td>
            <td>${book.moTa}</td>
            <td>
                <c:choose>
                    <c:when test="${book.soLuong > 0}">
                        <a class="btn" href="?action=borrow&maSach=${book.maSach}">Mượn</a>
                    </c:when>
                    <c:otherwise>
                        <span>Sách này đã hết</span>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>