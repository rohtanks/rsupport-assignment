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
			<div class="container">
			      <form class="form-signin" method="post">
			        <h2 class="form-signin-heading">Please sign in</h2>
			        <p>
			          <label for="username" class="sr-only">Userid</label>
			          <input type="text" id="username" name="username" class="form-control" placeholder="Userid" required="" autofocus="">
			        </p>
			        <p>
			          <label for="password" class="sr-only">Password</label>
			          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
			        </p>
			        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			      </form>
			</div>			
		</div>
		<!-- /.col (left) -->
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->



<%@ include file="../include/footer.jsp"%>