<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-10">
				<div class="card shadow-lg border-0 rounded-lg mt-5">
					<div class="card-header">
						<h3 class="text-center font-weight-light my-4">게시물 등록</h3>
					</div>
					<div class="card-body">
						<form action="boardInsert" method="post">
							<div class="row mb-3">
								<div class="col-md-6">
									<div class="form-floating mb-3 mb-md-0">
										<input class="form-control" id="title" name="title"
											type="text" placeholder="게시글 제목을 입력하세요." /><label
											for="title">Title: </label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-floating">
										<input class="form-control" id="writer" name="writer"
											type="text" /><label for="writer">Writer: </label>
									</div>
								</div>
							</div>
							<div class="form-floating mb-3">
								<textarea class="form-control" id="content" name="content"></textarea>
								<label for="content">Content: </label>
							</div>
							<div class="mt-4 mb-0">
								<div class="d-grid">
									<button class="btn btn-secondary">게시물 등록</button>
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