<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>
<div class="overflow-x-auto">
        <table class="table table-fixed w-full">
          <colgroup>
          	<col width="20">
          	<col width="120">          	
          	<col width="20">          	         	
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
            <tr>
              <th>1</th> 
              <td>Cy Ganderton</td> 
              <td>Quality Control Specialist</td> 
              <td>Blue</td>
            </tr>
            <tr>
              <th>2</th> 
              <td>Hart Hagerty</td> 
              <td>Desktop Support Technician</td> 
              <td>Purple</td>
            </tr>
            <tr>
              <th>3</th> 
              <td>Brice Swyre</td> 
              <td>Tax Accountant</td> 
              <td>Red</td>
            </tr>
            <tr>
              <th>4</th> 
              <td>Marjy Ferencz</td> 
              <td>Office Assistant I</td> 
              <td>Crimson</td>
            </tr>
            <tr>
                <th>5</th> 
                <td>Marjy Ferencz</td> 
                <td>Office Assistant I</td> 
                <td>Crimson</td>
            </tr>
              <tr>
                <th>6</th> 
                <td>Marjy Ferencz</td> 
                <td>Office Assistant I</td> 
                <td>Crimson</td>
            </tr>
            <tr>
                <th>7</th> 
                <td>Marjy Ferencz</td> 
                <td>Office Assistant I</td> 
                <td>Crimson</td>
            </tr>
            <tr>
                <th>8</th> 
                <td>Marjy Ferencz</td> 
                <td>Office Assistant I</td> 
                <td>Crimson</td>
            </tr>
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