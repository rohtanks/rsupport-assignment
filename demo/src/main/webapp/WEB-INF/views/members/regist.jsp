<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript">
		
</script>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">계정 등록</h3>
				</div>
				<!-- insert point!! -->
				<div class="box-body">
					<div class="container">
					      <form class="form-signin" method="post" action="/members/regist">
					        <h2 class="form-signin-heading">계정을 등록하죠</h2>
					        <p>
					          <label for="userid" class="sr-only">Userid</label>
					          <input type="text" id="userid" name="userid" class="form-control" placeholder="Userid" required="" autofocus="">
					        </p>
					        <p>
					          <label for="password" class="sr-only">Password</label>
					          <input type="password" id="userpw" name="userpw" class="form-control" placeholder="Password" required="">
					        </p>
					        <p>
					          <label for="username" class="sr-only">Username</label>
					          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="">
					        </p>
					        <p>
					          <label for="email" class="sr-only">Email</label>
					          <input type="email" id="email" name="email" class="form-control" placeholder="Email" required="">
					        </p>
					        <button class="btn btn-lg btn-primary btn-block" type="submit">등록</button>
					      </form>
					</div>
				</div>				
			</div>								
		</div>
		<!-- /.col (left) -->
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->



<%@ include file="../include/footer.jsp"%>