<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
<div class="card flex-shrink-0 w-full max-w-2xl shadow-2xl bg-base-100" style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">
	<form action="../member/doFindId" method="post">
		<div class="card-body">
			<div class="form-control">
				<label class="label"> 
					<span class="label-text">이름</span>
				</label> 
				<input name="name" type="text" placeholder="이름" class="input input-bordered">
			</div>
			<div class="form-control">
				<label class="label">
				 	<span class="label-text">이메일</span>
				</label> 
				<input name="email" type="email" placeholder="이메일" class="input input-bordered">
			</div>
			<div class="form-control mt-6">
				<input type="submit" value="아이디찾기" class="btn btn-primary">
			</div>
		</div>
	</form>
</div>
<%@ include file="../common/footer.jspf"%>