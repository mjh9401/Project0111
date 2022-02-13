<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>
<section class="mt-5">
  <div class="container mx-auto px-3"> 
      <table class="table w-full">
        <colgroup>
          <!-- <td>태그들의 width값 -->
          <col width="200"/>
        </colgroup>
        <tbody>
          <tr>
            <th style="height:50px;">번호</th>
            <td>
               <p>${article.id}</p>
            </td>
          </tr>
          <tr>
            <th>제목</th>
            <td>
               <p>${article.title}</p>
            </td>
          </tr>
          <tr>
            <th>조회수</th>
            <td>
               <p class="hitCount">${article.hitCount}</p>
            </td>
          </tr>
          <tr>
            <th>내용</th>
            <td>
              <p style="white-space: pre-line">${article.body}</p>
            </td>
          </tr>
        </tbody>
      </table>
      <div style="padding-left: 80%">
	      <button class="btn btn-primary"><a href="../article/modify?id=${article.id}">글 수정</a></button>    
	      <button class="btn btn-primary"><a href="../article/delete?id=${article.id}">글 삭제</a></button>    
      </div>
  </div>
</section>

<!-- 댓글 -->
<section class="mt-5">
  <div class="container mx-auto px-3">
	  <table class="table w-full">
	  		<colgroup>
	          <!-- <td>태그들의 width값 -->
	          <col width="20"/>
	          <col width="20"/>
	        </colgroup>
	  		<tbody>
	  		<tr>
		  		<form action="../reply/doWrite" method="get">
		  			<input type="hidden" name = "articleId" value="${article.id}">
		  			<input type="hidden" name ="memberId" value="${rq.loginedMemberId}" />
		  			
					<th>테스트1</th>
		  			<td>
		  				<textarea name="body" cols="100" rows="1" placeholder="댓글을 입력해주세요"></textarea>
		  			</td>
		  			<td>
		  				<input class="btn btn-primary" type="submit" />
		  			</td>
		  		</form>
	  		</tr>
				
	  		<c:forEach var="reply" items="${replies}">
	  			<c:choose>
	  				<c:when test="${modifySignal != null}">
	  					<tr>
	  						<form action="../reply/doModify">
				  				<td>이름</td>
				  				<td><textarea name="body" cols="100" rows="1" placeholder="댓글을 입력해주세요">${reply.body}</textarea></td>
				  				<c:if test="${reply.memberId == rq.loginedMemberId}">
					  				<td>
					  					<button class="btn btn-xs" type="button" onclick="history.back();">취소</button>
					  					<input class="btn btn-xs" type="submit" >
					  						<a href="../reply/modifySignal?replyId=${reply.id}" >수정</a>
					  					</input>
					  				</td>
				  				</c:if>	
			  				</form>  					
			  			</tr>
	  				</c:when>
	  				<c:otherwise>
			  			<tr>
			  				<td>이름</td>
			  				<td>${reply.body}</td>
			  				<c:if test="${reply.memberId == rq.loginedMemberId}">
				  				<td>
				  					<button class="btn btn-xs" type="button" >
				  						<a href="../reply/doDelete?replyId=${reply.id}">삭제</a>
				  					</button>
				  					<button class="btn btn-xs" type="button" >
				  						<a href="../reply/modifySignal?articleId=${article.id}" >수정</a>
				  					</button>
				  				</td>
			  				</c:if>	  					
			  			</tr>
		  			</c:otherwise>
	  			</c:choose>
	  		</c:forEach>
	  		</tbody>
	  </table>
  </div>
</section>

<script>
	function ArticleDetail_increaseHitCount(){
		$.get('../article/doIncreaseHitCount',{
			id:${article.id},
			ajaxMode: 'Y'
		},function(data){
			$('.hitCount').html(data);
			if (data != null) {
				console.log('성공했습니다.');
			} else {
				console.log('실패했습니다.');
			}
		},'html');
	}
	
	ArticleDetail_increaseHitCount();
	
</script>
               
<%@ include file = "../common/footer.jspf"%>