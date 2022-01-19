<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
<div class="card flex-shrink-0 w-full max-w-2xl shadow-2xl bg-base-100" style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">
	<form action="../member/doMemberDrop" method="post">
		<div class="card-body">
			<div class="form-control">
				<label class="label"> <span class="label-text">아이디</span>
				</label> <input name="loginId" type="text" placeholder="아이디" class="input input-bordered">
			</div>
			<div class="form-control">
				<label class="label"> <span class="label-text">비밀번호</span>
				</label> <input name="password" type="password" placeholder="비밀번호" class="input input-bordered">
			</div>
			<div class="form-control">
				<label class="label"> <span class="label-text">비밀번호확인</span>
				</label> <input name="passwordConfirm" type="password" placeholder="비밀번호확인" class="input input-bordered">
			</div>
			<div class="form-control mt-6">
				<input type="submit" value="회원탈퇴" class="btn btn-primary">
			</div>
		</div>
	</form>
</div>
<%@ include file="../common/footer.jspf"%>