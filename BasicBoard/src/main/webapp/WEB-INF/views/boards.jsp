<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 전체 조회</title>
</head>
<body>

    <h1>게시글 목록</h1>

    <table border="1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        <c:forEach var="board" items="${boards}">
            <tr>
                <td>${board.notictId}</td>
                <td>${board.title}</td>
                <td>${board.contents}</td>
                <td>${board.boardWriter}</td>
                <td>${board.createAt}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
