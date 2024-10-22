<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성/수정</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
		<h1 class="mb-4">
			<c:choose>
				<c:when test="${board.notictId != null}">
                    게시글 수정
                </c:when>
				<c:otherwise>
                    새 게시글 작성
                </c:otherwise>
			</c:choose>
		</h1>

		<form
			action="<c:choose>
                        <c:when test="${board.notictId != null}">
                            /board/update/${board.notictId}
                        </c:when>
                        <c:otherwise>
                            /board/save
                        </c:otherwise>
                      </c:choose>"
			method="post">

			<div class="mb-3">
				<label for="title" class="form-label">제목</label> <input type="text"
					class="form-control" id="title" name="title" value="${board.title}"
					required>
			</div>

			<div class="mb-3">
				<label for="contents" class="form-label">내용</label>
				<textarea class="form-control" id="contents" name="contents"
					rows="4" required>${board.contents}</textarea>
			</div>

			<div class="mb-3">
				<label for="boardWriter" class="form-label">작성자</label> <input
					type="text" class="form-control" id="boardWriter"
					name="boardWriter" value="${board.boardWriter}" required>
			</div>

			<button type="submit" class="btn btn-primary">
				<c:choose>
					<c:when test="${board.notictId != null}">
                        수정
                    </c:when>
					<c:otherwise>
                        저장
                    </c:otherwise>
				</c:choose>
			</button>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
