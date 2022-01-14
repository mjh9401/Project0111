<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
<div class="container">
	<div class="cotain">
		<div class="UserId">
			<h3>아이디</h3>
			<div class="inputId">
				<input type="text">
			</div>
		</div>
		<div class="password">
			<h3>비밀번호</h3>
			<div class="inputId">
				<input type="password">
			</div>
		</div>
		<div class="passwordConfirm">
			<h3>비밀번호 재확인</h3>
			<div class="inputId">
				<input type="password">
			</div>
		</div>
		<div class="nickName">
			<h3>이름</h3>
			<div class="inputId">
				<input type="text">
			</div>
		</div>
		<div class="phoneNumeber">
			<h3>휴대전화</h3>
			<div class="inputId">
				<input type="tel">
			</div>
		</div>
		<div class="email">
			<h3>이메일</h3>
			<div class="inputId">
				<input type="email">
			</div>
		</div>
	</div>
	<div class="button-wrap">
		<button type="submit" class="joinBtn">회원가입</button>
	</div>
</div>

<style>
body {
	background-color: #f5f6f7;
}

.container {
	max-width: 760px;
	min-width: 460px;
	margin: 0 auto;
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
<%@ include file="../common/footer.jspf"%>