<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/header.jspf"%>
<div class="navbar mb-2 shadow-lg bg-neutral text-neutral-content rounded-box">
	<div class="px-2 mx-2 navbar-start">
		<span class="text-lg font-bold"> Test </span>
	</div>
	<div class="hidden px-2 mx-2 navbar-center lg:flex">
		<div class="flex items-stretch">
			<a class="btn btn-ghost btn-sm rounded-btn"> Home </a> <a class="btn btn-ghost btn-sm rounded-btn"> 공지사항 </a> <a class="btn btn-ghost btn-sm rounded-btn"> 자유게시판 </a>
		</div>
	</div>
	<div class="navbar-end">
		<div class="flex-1 lg:flex-none">
			<div class="form-control">
				<input type="text" placeholder="Search" class="input input-ghost">
			</div>
		</div>
		<div class="flex-none">
			<button class="btn btn-square btn-ghost">
				<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" class="inline-block w-6 h-6 stroke-current">             
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path>             
                  </svg>
			</button>
		</div>
		<div class="flex-none">
			<div class="avatar">
				<c:choose>
					<c:when test="${rq.isLogined()==false}">
						<div class="rounded-full w-10 h-10 m-1">
							<a href="/member/login"> <img src="https://www.kindpng.com/picc/m/130-1300217_user-icon-member-icon-png-transparent-png.png">
							</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="rounded-full w-10 h-10 m-1">
							<a href="/member/logout"> <img src="https://www.kindpng.com/picc/m/130-1300217_user-icon-member-icon-png-transparent-png.png">
							</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>

<%@ include file="../common/footer.jspf"%>