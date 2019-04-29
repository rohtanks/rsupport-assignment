<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		var bnoVal = $("input[name='bno']").val();
		var formAction = $("input[name='_method']");
		
		console.log(formObj);
		
		// 저장
		$(".btn-primary").on("click", function(){
			/* action 을 지정해주지 않으면 GET 방식으로 된 URL에 있는 파라미터가 남아서 값이 중복된다 */
			/* formObj.attr("action", "post"+bnoVal); */
			formObj.attr("action", bnoVal);
			formAction.val("put");
			formObj.submit();
		});
		
		// 취소
		$(".btn-warning").on("click", function(){
			/* self.location = "board/listAll"; */
			/* history.back(); */
			self.location = "list?page=${cri.page}&perPageNum=${cri.perPageNum}"
					+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";
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
					<h3 class="box-title">공지 수정</h3>
				</div>
				<form role="form" method="post">
				<!-- action 지정 없으면, 현재 경로를 action 대상으로 -->
					<div class="box-body">
						<input type="hidden" name="bno" value="${boardVo.bno }">
						<div class="form-group">
							<label for="exampleInputEmail1">제목</label> <input type="text"
								name="title" class="form-control" value="${boardVo.title }">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">등록일</label>
							<p><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVo.regdate }"/></p>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">작성자</label>
							<input type="text" name="writer" class="form-control" value="${boardVo.writer }">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">최종 수정일</label>
							<p><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVo.upddate }"/></p>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">조회수 : ${boardVo.viewcnt }</label>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">내용</label>
							<textarea class="form-control" name="content" rows="3">${boardVo.content }</textarea>
						</div>
					</div>
					<input type="hidden" name="_method" value="" />
				</form>
				
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">저장</button>
					<button type="submit" class="btn btn-warning">취소</button>
				</div>
			</div>

		</div>
		<!-- /.col (left) -->
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->



<%@ include file="../include/footer.jsp"%>