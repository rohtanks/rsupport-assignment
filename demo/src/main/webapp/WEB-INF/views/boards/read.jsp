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
	
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		var formAction = formObj.find("[name='_method']");
		var bnoVal = $("input[name='bno']").val();
		
		console.log(formObj);
		console.log(formAction);
		console.log(bnoVal);
		
		// 수정
		$(".btn-warning").on("click", function(){
			formObj.attr("action", "/boards/post/" + bnoVal)
			.attr("method", "get");
			formAction.remove();
			formObj.submit();
		});
		
		// 삭제
		$(".btn-danger").on("click", function(){
			formObj.attr("action", "/boards/" + bnoVal);
			formAction.attr("value", "delete");
			formObj.submit();
		});
		
		// 목록보기
		$(".btn-primary").on("click", function(){
			//self.location = "/boards";
			
			formObj.attr("action", "/boards")
			.attr("method", "get");
			formAction.remove();
			formObj.submit();
		});
		
	});
</script>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">공지 조회</h3>
				</div>
				<!-- insert point!! -->
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">제목</label>
						<input type="text" name="title" class="form-control" value="${boardVo.title }"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">등록일</label>
						<p><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVo.regdate }"/></p>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">최종 수정일</label>
						<p><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVo.upddate }"/></p>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">조회수 : ${boardVo.viewcnt }</label>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">작성자</label>
						<input type="text" name="writer" class="form-control" value="${boardVo.writer }"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">내용</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly">${boardVo.content }</textarea>
					</div>
				</div>
				<!-- /.box-body -->
				
				<input type="hidden" name="bno" value="${boardVo.bno}">
				<div class="form-group">
					<form role="form" method="post">
						<!-- PUT, DELETE 메서드 사용하기 위한 방법 -->
						<input type="hidden" name="_method" value="" />
						<!-- 페이징 정보 유지 위해 필요한 파라미터 추가 -->
						<input type="hidden" name="page" value="${cri.page}">
						<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
					</form>
				</div>
				<div class="box-footer">
					<button type="submit" class="btn btn-warning">수정</button>
					<button type="submit" class="btn btn-danger">삭제</button>
					<button type="submit" class="btn btn-primary">목록보기</button>
				</div>
				
			</div>
		</div>
		<!-- /.col (left) -->
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->



<%@ include file="../include/footer.jsp"%>