<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>
<section class="mt-5">
  <div class="container mx-auto px-3">
   <form class="table-box-type-1" method="post" action="../article/doWrite">
    <input type="hidden" name = "loginedMemberId" value= "${loginedMemberId}" />
      <table>
        <colgroup>
          <!-- <td>태그들의 width값 -->
          <col width="200"/>
        </colgroup>
        <tbody>
          <tr>
            <th style="height:50px;">제목</th>
            <td>
               <input required="required" name="title" class="w-96" type="text" placeholder="제목" />
            </td>
          </tr>
          <tr>
            <th>닉네임</th>
            <td>
               <p>${rq.loginedMember.nickName}</p>
            </td>
          </tr>
          <tr>
            <th>내용</th>
            <td>
              <textarea required="required" name ="body" class="w-full" cols="200" rows="25"  placeholder="내용을 적어주세요" ></textarea> 
            </td>
          </tr>
          <tr>
            <th>제출</th>
            <td>
              <input class="btn btn-primary" type="submit" value="제출" />
              <button class="btn btn-primary" type="button" onclick="history.back();">뒤로가기</button>
            </td>
          </tr>
        </tbody>
      </table>
     </form>
  </div>
</section>               
<%@ include file = "../common/footer.jspf"%>