<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript">
	var result = '${result}';
	
	if (result == 'success') {
		alert("처리가 완료되었습니다.");
	}
</script>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">공지 목록</h3>
				</div>
			</div>
			<!-- insert point!! -->
			<div class="box">
				<div class="box-header">
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
							<th style="width: 70px">조회수</th>
						</tr>
					<c:forEach items="${list }" var="boardVo">
						<tr>
							<td>${boardVo.bno }</td>
							<td><a href="boards/${boardVo.bno }">${boardVo.title }</a></td>
							<td>${boardVo.writer }</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVo.regdate }"/></td>
							<td><span class="badge bg-red">${boardVo.viewcnt }</span></td>
						</tr>
					</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<!-- /.col (left) -->
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->



<%@ include file="../include/footer.jsp"%>