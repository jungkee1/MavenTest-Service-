<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<form action="update">
<h1>상세보기</h1>
<table>
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>주소</td>
		<td>메모</td>
		<td>가입날짜</td>
	</tr>
	<tr>
		<td><input type="text" value="${vo.id}" name="id"></td>
		<td><input type="text" value="${vo.pass}" name="pass"></td>
		<td><input type="text" value="${vo.name}" name="name"></td>
		<td><input type="text" value="${vo.addr}" name="addr"></td>
		<td><input type="text" value="${vo.memo}" name="memo"></td>
		<td><input type="text" value="${vo.reg_date}" name="reg_date"></td>
	</tr>
</table>
<input type=submit value="수정하기">
</form>
</div>


</body>
</html>