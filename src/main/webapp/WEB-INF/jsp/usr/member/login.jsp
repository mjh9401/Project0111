<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
<div class="hero min-h-screen bg-base-200">
	<div class="flex-col justify-center hero-content lg:flex-row">
		<div class="text-center lg:text-left">
			<h1 class="mb-5 text-5xl font-bold">Hello there</h1>
			<p class="mb-5">Provident cupiditate voluptatem et in. Quaerat fugiat ut assumenda excepturi exercitationem quasi. In deleniti eaque aut repudiandae et a id nisi.</p>
		</div>
		<div class="card flex-shrink-0 w-full max-w-sm shadow-2xl bg-base-100">
			<form action="../member/doLogin" method="post">
				<div class="card-body">
					<div class="form-control">
						<label class="label"> <span class="label-text">ID</span></label> 
						<input name = "loginId" type="text" placeholder="text" class="input input-bordered">
					</div>
					<div class="form-control">
						<label class="label"> <span class="label-text">Password</span></label>
						<input name="loginPw" type="password" placeholder="password" class="input input-bordered">
						<label class="label"> 
							<a href="../member/findId" class="label-text-alt">Forgot ID?</a> 
							<a href="../member/findPw" class="label-text-alt">Forgot password?</a> 
							<a href="/member/join" class="label-text-alt">Member Join?</a>
						</label>
					</div>
					<div class="form-control mt-6">
						<input type="submit" value="Login" class="btn btn-primary">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="../common/footer.jspf"%>