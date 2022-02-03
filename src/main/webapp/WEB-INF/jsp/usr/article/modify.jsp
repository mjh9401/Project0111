<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>
<section class="mt-5">
  <div class="container mx-auto px-3">
   <form class="table-box-type-1" method="get" action="../article/doModify">
    <input type="text" name = "id" value= "${article.id}" />
      <table>
        <colgroup>
          <!-- <td>태그들의 width값 -->
          <col width="200"/>
        </colgroup>
        <tbody>
          <tr>
            <th style="height:50px;">제목</th>
            <td>
               ${article.title}
            </td>
          </tr>
          <tr>
            <th>작성일</th>
            <td>
               ${article.regDate}
            </td>
          </tr>
          <tr>
            <th>내용</th>
            <td>
            	<textarea required="required" name ="body" class="w-full" cols="200" rows="25">${article.body}</textarea> 
            </td>
          </tr>
          <tr>
            <th>제출</th>
            <td>
              <input type="submit" value="수정" />
            </td>
          </tr>
        </tbody>
      </table>
     </form>
  </div>
</section>               
<%@ include file = "../common/footer.jspf"%>