<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
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

.name {
	height: 140px;
}

.name h3 {
	font-size: 20px;
	font-weight: bold;
}

.name .inputId input {
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

<div class="container">
	<form action="../member/doJoin" method="post">
		<div class="cotain">
			<div class="UserId">
				<h3>아이디</h3>
				<div class="inputId">
					<input id="loginId" name="loginId" type="text" onkeyup="checkLoginIdDup()">
				</div>
				<p class="loginId-msg" style="color:red; font-weight: bold;"></p>
			</div>
			<div class="password">
				<h3>비밀번호</h3>
				<div class="inputId">
					<input id="loginPw" name="loginPw" type="password" onkeyup="checkEmptyPw()">
				</div>
				<p class="loginPw-msg" style="color:red; font-weight: bold;"></p>				
			</div>
			<div class="passwordConfirm">
				<h3>비밀번호 재확인</h3>
				<div class="inputId">
					<input id="loginPwConfirm" name="loginPwConfirm" type="password" onkeyup="checkEmptyPwConfirm()">
				</div>
				<p class="loginPwConfirm-msg" style="color:red; font-weight: bold;"></p>								
			</div>
			<div class="name">
				<h3>이름</h3>
				<div class="inputId">
					<input id="name" name="name" type="text" onkeyup="checkEmptyName()">
				</div>
				<p class="name-msg" style="color:red; font-weight: bold;"></p>							
			</div>
			<div class="nickName">
				<h3>닉네임</h3>
				<div class="inputId">
					<input id="nickName" name="nickName" type="text" onkeyup="checkEmptynickName()">
				</div>
				<p class="nickName-msg" style="color:red; font-weight: bold;"></p>											
			</div>
			<div class="phoneNumeber">
				<h3>휴대전화</h3>
				<div class="inputId">
					<input id="cellphoneNo" name="cellphoneNo" type="tel" onkeyup="checkEmptyTel()">
				</div>
				<p class="cellphoneNo-msg" style="color:red; font-weight: bold;"></p>																			
			</div>
			<div class="email">
				<h3>이메일</h3>
				<div class="inputId">
					<input id="email" name="email" type="email" onkeyup="checkEmptyEmail()">
				</div>
				<p class="email-msg" style="color:red; font-weight: bold;"></p>															
			</div>
		</div>
		<div class="button-wrap">
			<button type="submit" class="joinBtn">회원가입</button>
		</div>
	</form>
</div>

<script>
	function checkLoginIdDup(){
		const loginId = document.getElementById('loginId').value;

		$.get('../member/getLoginIdDup', {
			isAjax : 'Y',
			loginId : loginId
		}, function(data) {
			$('.loginId-msg').html(data);
			if (data != null) {
				console.log('성공했습니다.');
			} else {
				console.log('실패했습니다.');
			}
		},'html');
	}
	
	function checkEmptyPw(){
		const loginPw = document.getElementById('loginPw').value;
		
		$.get('../member/EmptyCheckLoginPw', {
			isAjax : 'Y',
			loginPw : loginPw
		}, function(data) {
			$('.loginPw-msg').html(data);
			if (data != null) {
				console.log('성공했습니다.');
			} else {
				console.log('실패했습니다.');
			}
		},'html');

	}
	
	function checkEmptyPwConfirm(){
		const loginPwConfirm = document.getElementById('loginPwConfirm').value;
		
		$.get('../member/EmptyCheckLoginPwConfirm', {
			isAjax : 'Y',
			loginPwConfirm : loginPwConfirm
		}, function(data) {
			$('.loginPwConfirm-msg').html(data);
			if (data != null) {
				console.log('성공했습니다.');
			} else {
				console.log('실패했습니다.');
			}
		},'html');
	}
	
	function checkEmptyName(){
		const name = document.getElementById('name').value;
		
		$.get('../member/EmptyCheckName', {
			isAjax : 'Y',
			name : name
		}, function(data) {
			$('.name-msg').html(data);
			if (data != null) {
				console.log('성공했습니다.');
			} else {
				console.log('실패했습니다.');
			}
		},'html');
	}
	
	function checkEmptynickName(){
		const nickName = document.getElementById('nickName').value;
		
		$.get('../member/EmptyCheckNickname', {
			isAjax : 'Y',
			nickName : nickName
		}, function(data) {
			$('.nickName-msg').html(data);
			if (data != null) {
				console.log('성공했습니다.');
			} else {
				console.log('실패했습니다.');
			}
		},'html');
	}
	
	function checkEmptyTel(){
		const cellphoneNo = document.getElementById('cellphoneNo').value;
		
		$.get('../member/EmptyChecktel', {
			isAjax : 'Y',
			cellphoneNo : cellphoneNo
		}, function(data) {
			$('.cellphoneNo-msg').html(data);
			if (data != null) {
				console.log('성공했습니다.');
			} else {
				console.log('실패했습니다.');
			}
		},'html');
	}
	
	function checkEmptyEmail(){
		const email = document.getElementById('email').value;
		
		$.get('../member/EmptyCheckEmail', {
			isAjax : 'Y',
			email : email
		}, function(data) {
			$('.email-msg').html(data);
			if (data != null) {
				console.log('성공했습니다.');
			} else {
				console.log('실패했습니다.');
			}
		},'html');
	}
</script>

<%@ include file="../common/footer.jspf"%>