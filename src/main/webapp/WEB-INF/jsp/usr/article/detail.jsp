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
            <th style="height:50px;">제목</th>
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
            <th>내용</th>
            <td>
              <p>${article.body}</p>
            </td>
          </tr>
        </tbody>
      </table>
      <button class="btn btn-primary"><a href="../article/modify?id=${article.id}">글 수정</a></button>    
      <button class="btn btn-primary"><a href="../article/delete?id=${article.id}">글 삭제</a></button>    
  </div>
</section>               
<%@ include file = "../common/footer.jspf"%>