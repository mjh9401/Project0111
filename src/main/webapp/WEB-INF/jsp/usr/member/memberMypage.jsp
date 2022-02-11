<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
<div class="card flex-shrink-0 w-full max-w-2xl shadow-2xl bg-base-100" style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">
	<div class="card-body">
		<div class="form-control m-auto">
			<label class="label"> <span class="label-text">아이디</span>
			</label><span class="ml-2">${rq.getLoginedMember().getLoginId()}</span> 
		</div>
		<div class="mt-6 m-auto">
			<button class="btn btn-primary"><a href="../member/memberModify">회원수정</a></button> 			
			<button class="btn btn-primary"><a href="../member/memberDrop">회원탈퇴</a></button> 			
		</div>
	</div>
</div>
<%@ include file="../common/footer.jspf"%>