<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html lang="en" class="h-100">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.101.0">
<title>Sticky Footer Navbar Template · Bootstrap v4.6</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.6/examples/sticky-footer-navbar/">



<!-- Bootstrap core CSS -->
<!-- https://getbootstrap.com/docs/4.6/getting-started/introduction/ 여기 사이트에서  css copy -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


<!-- Custom styles for this template -->
<link href="/resources/sticky-footer-navbar.css" rel="stylesheet">
</head>
<body class="d-flex flex-column h-100">

	<header>
		<!-- Fixed navbar -->
		<%@include file="/WEB-INF/views/comm/header.jsp"%>
	</header>

	<!-- Begin page content -->
	<main role="main" class="flex-shrink-0">
		<div class="container">
			<section>
				<div class="row">
					<div class="col-md-12">
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title mt-5">글수정</h3>
							</div>
							<form role="form" method="post" action="./modify">
								<div class="box-body">
									<div class="form-group">
										<label for="idx">Idx</label> 
										<input type="hidden" name="pageNum" id="pageNum" value="${cri.pageNum}" /> 
										<input type="hidden" name="amount"  id="amount"  value="${cri.amount}" />
										<input type="hidden" name="type"  	id="type" 	 value="${cri.type}" />
										<input type="hidden" name="keyword" id="keyword" value="${cri.keyword}" /> 
										<input type="text"  class="form-control" name="idx" id="idx" value="${board.idx}" readonly>
									</div>
									<div class="form-group">
										<label for="subject">Subject</label> <input type="text"
											class="form-control" name="subject" id="subject"
											value="${board.subject}">
									</div>
									<div class="form-group">
										<label for="author">Author</label> <input type="text"
											class="form-control" name="author" id="author"
											value="${board.author}" readonly>
									</div>
									<div class="form-group">
										<label>Content</label>
										<!-- input태그는 value가 있으나 textarea태그는 value 없음 -->
										<textarea class="form-control" name="content" rows="3">${board.content}</textarea>
									</div>
									<div class="form-group">
										<label for="createdate">createdate</label> <input type="text"
											class="form-control" name="createdate" id="createdate"
											value='<fmt:formatDate value="${board.createdate}"
											pattern="yyyy/MM/dd" />'
											readonly>
									</div>
									<div class="form-group">
										<label for="editdate">editdate</label> <input
											type="text" class="form-control" name="editdate"
											id="editdate"
											value='<fmt:formatDate value="${board.editdate}"
											pattern="yyyy/MM/dd" />'
											readonly>
									</div>
								</div>


								<div class="box-footer">
									<button type="submit" class="btn btn-primary">저장</button>
									<button type="reset" class="btn btn-primary">취소</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</section>
		</div>
	</main>

	<footer class="footer mt-auto py-3">
		<%@include file="/WEB-INF/views/comm/footer.jsp"%>
	</footer>
	<%@include file="/WEB-INF/views/comm/plug-in.jsp"%>



</body>
</html>
