<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {
	width: 80%;
	margin: 3% auto;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-10">
				<div class="card shadow-lg border-0 rounded-lg mt-5">
					<div class="card-header">
						<h3 class="text-center font-weight-light my-4">게시물 수정</h3>
					</div>
					<div class="card-body">
						<form action="boardUpdate" method="post">
							<input type="hidden" name="bno" value="${board.bno}" />
							<div class="row mb-3">
								<div class="col-md-6">
									<div class="form-floating mb-3 mb-md-0">
										<input class="form-control" id="title" name="title"
											type="text" value="${board.title}" /><label for="title">Title:
										</label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-floating">
										<input class="form-control" id="writer" name="writer"
											type="text" value="${board.writer}" readonly /><label
											for="writer">Writer: </label>
									</div>
								</div>
							</div>
							<div class="form-floating mb-3">
								<textarea rows="5" cols="50" class="form-control" id="content" name="content">
								${board.content}
								</textarea>
								<label for="content">Content: </label>
							</div>
							<div class="mt-4 mb-0">
								<div class="d-grid gap-2">
									<button class="btn btn-secondary">게시물 등록</button>
									<button class="btn btn-secondary" type="button"
										onclick="location.href='boardDelete?bno=${board.bno}'">게시물
										삭제</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>