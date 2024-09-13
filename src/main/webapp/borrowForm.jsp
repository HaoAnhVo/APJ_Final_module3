<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Mượn sách</title>
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

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }

        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"],
        input[type="button"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 15px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 10px 2px;
            cursor: pointer;
            border-radius: 4px;
        }

        input[type="submit"]:hover,
        input[type="button"]:hover {
            background-color: #45a049;
        }


        .confirm-popup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            z-index: 1000;
        }

        .confirm-popup.active {
            display: block;
        }

        .confirm-popup p {
            margin-bottom: 20px;
        }

        .confirm-popup button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
            margin-right: 10px;
        }

        .confirm-popup button.cancel {
            background-color: #f44336;
        }
    </style>
    <script>
        function confirmBack() {
            const confirmPopup = document.getElementById('confirmPopup');
            confirmPopup.classList.add('active');
        }

        function closeConfirm() {
            const confirmPopup = document.getElementById('confirmPopup');
            confirmPopup.classList.remove('active');
        }
    </script>
</head>
<body>
<div class="container">
    <h1>Borrow Book</h1>
    <form action="?action=processBorrow" method="post">
        <input type="hidden" name="maSach" value="${book.maSach}">

        <label for="bookName">Tên sách:</label>
        <input type="text" id="bookName" name="bookName" value="${book.tenSach}" readonly>

        <label for="studentId">Tên học sinh:</label>
        <select id="studentId" name="studentId" required>
            <option value="">Chọn học sinh</option>
            <c:forEach items="${students}" var="student">
                <option value="${student.id}">${student.name}</option>
            </c:forEach>
        </select>

        <label for="borrowDate">Ngày mượn:</label>
        <input type="date" id="borrowDate" name="borrowDate" value="${nowDate}" required readonly>

        <label for="returnDate">Ngày trả:</label>
        <input type="date" id="returnDate" name="returnDate" required>

        <input type="submit" value="Mượn sách">
        <input type="button" value="Trở về danh sách" onclick="confirmBack()">
    </form>
</div>

<!-- Popup confirm -->
<div id="confirmPopup" class="confirm-popup">
    <p>Bạn có chắc chắn muốn trở về danh sách?</p>
    <button onclick="window.history.back();">Có</button>
    <button class="cancel" onclick="closeConfirm();">Không</button>
</div>
</body>
</html>

