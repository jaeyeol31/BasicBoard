<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 삭제</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-5">
        <h1 class="mb-4">게시글 삭제</h1>

        <p>게시글 <strong>"${board.title}"</strong>을 정말로 삭제하시겠습니까?</p>

        <form action="/board/delete/${board.boardId}" method="post">
            <button type="submit" class="btn btn-danger">삭제</button>
            <a href="/boards" class="btn btn-secondary">취소</a>
        </form>
    </div>

</body>
</html>
