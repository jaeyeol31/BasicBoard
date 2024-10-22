<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 전체 조회</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
		<div class="d-flex justify-content-between">
			<h1 class="mb-4">게시글 목록</h1>

			<a href="/board/new" class="btn">글쓰기</a>
		</div>

		<table class="table table-striped table-bordered">
			<thead class="table-dark">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">내용</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">작업</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boards}">
					<tr>
						<td>${board.notictId}</td>
						<td><a href="/board/${board.notictId}"
							class="text-decoration-none">${board.title}</a></td>
						<td>${board.contents}</td>
						<td>${board.boardWriter}</td>
						<td>${board.createAt}</td>
						<td><a href="/board/update/${board.notictId}"
							class="btn btn-warning btn-sm">수정</a> <a
							href="/board/delete/${board.notictId}"
							class="btn btn-danger btn-sm">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
