<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>
<div class="container mx-auto px-3">
	<table>
		<colgroup>
			<col width="120">	
			<col width="120">	
			<col width="120">	
			<col width="120">	
		</colgroup>
		<tbody>
			<tr>
				<th>작성자</th>
				<td></td>
			</tr>
			<tr>
				<th>게시판</th>
				<td></td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
               		<input required="required" name="title" class="w-96" type="text" placeholder="제목" />					
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea required="required" name ="body" class="w-full" rows="10" placeholder="내용을 적어주세요"></textarea>
				</td>
			</tr>
			<tr>
				<th>제출</th>
				<td>
					<input type="submit" value="제출" />
					<button type="button" onclick="history.back();">뒤로가기</button>
				</td>
			</tr>
		</tbody>
	</table>
</div>                
<%@ include file = "../common/footer.jspf"%>