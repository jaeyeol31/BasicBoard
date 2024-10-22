<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
		<h1 class="mb-4">게시글 상세보기</h1>

		<table class="table table-bordered">
			<thead class="table-light">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">내용</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${board.notictId}</td>
					<td>${board.title}</td>
					<td>${board.contents}</td>
					<td>${board.boardWriter}</td>
					<td>${board.createAt}</td>
				</tr>
			</tbody>
		</table>

		<a href="/boards" class="btn btn-secondary mt-3">목록으로 돌아가기</a>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
