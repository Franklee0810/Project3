<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="./../common/common.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%=contextPath %>/resources/css/login.css">

</head>
<body>
	<div class="wrap wd668">
      <div class="container">
        <div class="form_txtInput">
          <h2 class="sub_tit_txt">관리자 페이지</h2>
          <p class="exTxt">관리자는 로그인 후, 파일 업로드를 진행할 수 있습니다.</p>
          <div class="join_form">
            <form action="<%=contextPath%>/adminpage.admin" method="post">
            <table>
              <colgroup>
                <col width="30%"/>
                <col width="auto"/>
              </colgroup> 
              <tbody>
                <tr>
                  <th><span>아이디</span></th>
                  <td><input name="id" type="text" placeholder="ID 를 입력하세요."></td>
                </tr>
                <tr>
                  <th><span>비밀번호</span></th>
                  <td><input name="password" type="password" placeholder="비밀번호를 입력해주세요."></td>
                </tr>
              </tbody>
            </table>
            <button type="submit" class="btn btn-dark">로그인</button> 
             </form>
           </div><!-- join_form E  -->
           
        </div> <!-- form_txtInput E -->
      </div><!-- content E-->
    </div> <!-- container E -->
</body>
</html>