<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
<div class="container">
	<form action="../member/doMemberModify" method="post">
		<div class="cotain">
			<!-- value값 로그인 된 회원 번호  -->
			<input name = "id" type="hidden" value="${rq.getLoginedMemberId()}"/>
			<div class="UserId">
				<h3 class="mb-2">아이디</h3>
				<span style="font-size: 26px;">${rq.getLoginedMember().getLoginId()}</span>
			</div>
			<div class="password">
				<h3>비밀번호</h3>
				<div class="inputId">
					<input name="password" type="password">
				</div>
			</div>
			<div class="passwordConfirm">
				<h3>비밀번호 재확인</h3>
				<div class="inputId">
					<input name="passwordConfirm" type="password">
				</div>
			</div>
			<div class="nickName">
				<h3>닉네임</h3>
				<div class="inputId">
					<input name="nickName" type="text"  value="${rq.getLoginedMember().getNickName()}">
				</div>										
			</div>
			<div class="phoneNumeber">
				<h3>휴대전화</h3>
				<div class="inputId">
					<input name = "cellphoneNo" type="tel" value="${rq.getLoginedMember().getCellphoneNo()}">
				</div>
			</div>
			<div class="email">
				<h3>이메일</h3>
				<div class="inputId">
					<input name="email" type="email" value="${rq.getLoginedMember().getEmail()}">
				</div>
			</div>
		</div>
		<div class="button-wrap">
			<button type="submit" class="joinBtn">회원정보수정</button>
		</div>
	</form>
</div>
<style>
body {
	background-color: #f5f6f7;
}

.container {
	max-width: 760px;
	min-width: 460px;
	margin: 0 auto;
	padding-top: 60px;
}

.cotain {
	width: 460px;
	margin: 0 auto;
}

.UserId {
	height: 140px;
}

.UserId h3 {
	font-size: 20px;
	font-weight: bold;
}

.UserId .inputId input {
	width: 500px;
	height: 60px;
	border: 1px solid #dadada;
}

.password {
	height: 140px;
}

.password h3 {
	font-size: 20px;
	font-weight: bold;
}

.password .inputId input {
	width: 500px;
	height: 60px;
	border: 1px solid #dadada;
}

.passwordConfirm {
	height: 140px;
}

.passwordConfirm h3 {
	font-size: 20px;
	font-weight: bold;
}

.passwordConfirm .inputId input {
	width: 500px;
	height: 60px;
	border: 1px solid #dadada;
}

.nickName {
	height: 140px;
}

.nickName h3 {
	font-size: 20px;
	font-weight: bold;
}

.nickName .inputId input {
	width: 500px;
	height: 60px;
	border: 1px solid #dadada;
}

.phoneNumeber {
	height: 140px;
}

.phoneNumeber h3 {
	font-size: 20px;
	font-weight: bold;
}

.phoneNumeber .inputId input {
	width: 500px;
	height: 60px;
	border: 1px solid #dadada;
}

.email {
	height: 140px;
}

.email h3 {
	font-size: 20px;
	font-weight: bold;
}

.email .inputId input {
	width: 500px;
	height: 60px;
	border: 1px solid #dadada;
}

.button-wrap {
	padding-top: 20px;
	width: 460px;
	margin: 0 auto;
	padding-bottom: 20px;
}

.button-wrap .joinBtn {
	width: 500px;
	height: 60px;
	background-color: rgb(233, 233, 98);
	color: white;
	font-size: 20px;
	font-weight: bold;
}
</style>
</body>
</html>