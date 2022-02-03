<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>
<div class="overflow-x-auto">
        <table class="table w-full">
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
		<a href="../article/write">
			<button class="btn btn-primary" style="position: absolute; bottom: 18%; right: 0;">
				글 작성
			</button> 
		</a>
        <div class="form-control w-80" style="position: absolute; bottom: 12%; left: 50%; transform:translate(-50%,-50%);"> 
  			<div class="relative">
    			<input type="text" placeholder="Search" class="w-full pr-16 input input-primary input-bordered"> 
    			<button class="absolute top-0 right-0 rounded-l-none btn btn-primary">검색</button>
  			</div>
		</div> 
        <div class="flex justify-center mt-2 mb-2" style="position: absolute; bottom: 5%; left: 50%; transform:translate(-50%,-50%);">
            <div class="btn-group">
                <button class="btn">Previous</button> 
                <button class="btn">1</button> 
                <button class="btn btn-active">2</button> 
                <button class="btn">3</button> 
                <button class="btn">4</button> 
                <button class="btn">Next</button>
            </div>
        </div>
    </div>                
<%@ include file = "../common/footer.jspf"%>