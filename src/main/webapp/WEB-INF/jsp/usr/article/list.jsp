<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
<div class="overflow-x-auto">
	<table class="table w-full mt-5">
		<colgroup>
			<col width="20">
			<col width="200">
			<col width="10">
			<col width="10">
		</colgroup>
		<thead>
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${articles}">
				<tr>
					<td>${article.id}</td>
					<td><a href="../article/detail?id=${article.id}">${article.title}</a></td>
					<td>${article.title}</td>
					<td>${article.regDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="../article/write?boardId=${boardId}"> <input type="hidden" name="boardId" value="${boardId}" />
		<button class="btn btn-primary" style="position: absolute; bottom: 18%; right: 0;">글 작성</button>
	</a>

	<!-- 게시물 검색  -->
	<form>
		<input type="hidden" name="boardId" value="${boardId}" />
		<div class="form-control w-80" style="position: absolute; bottom: 12%; left: 50%; transform: translate(-50%, -50%);">
			<div class="relative">
				<input name="searchKeyword" type="text" placeholder="Search" class="w-full pr-16 input input-primary input-bordered">
				<button type="submit" class="absolute top-0 right-0 rounded-l-none btn btn-primary">검색</button>
			</div>
		</div>
	</form>

	<div class="flex justify-center mt-2 mb-2" style="position: absolute; bottom: 5%; left: 50%; transform: translate(-50%, -50%);">
		<div class="btn-group">
			<c:set var="pageMenuArmLen" value="5" />
			<c:set var="startpage" value="${page - pageMenuArmLen >= 1 ? page- pageMenuArmLen : 1}" />
			<c:set var="endPage" value="${page + pageMenuArmLen <= pageCount ? page + pageMenuArmLen : pageCount}" />

			<c:set var="pageBaseUri" value="?boardId=${boardId}" />
			<c:set var="pageBaseUri" value="${pageBaseUri}&searchKeyword=${searchKeyword}" />

			<button class="btn">
				<a href="${pageBaseUri}&page=1">First</a>
			</button>

			<c:forEach begin="${startpage}" end="${endPage}" var="i">
				<a class="btn ${page == i ? 'btn-active' : ''}" href="${pageBaseUri}&page=${i}">${i}</a>
			</c:forEach>

			<button class="btn">
				<a href="${pageBaseUri}&page=${pageCount}">End</a>
			</button>
		</div>
	</div>

</div>
<%@ include file="../common/footer.jspf"%>