<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function zipSearch(){
	window.open("myZipSearch.my","","width=700 height=500");
}
</script>

</head>
<body>
<h2>회원가입</h2>
<hr>
<form name="form" method="post" action="insert">
<table align="center">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pass"></td>
	</tr>
	<tr>
		<td>성명</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" size="20" name="addr"> <input type="button" value="검색" onclick="zipSearch()"></td>
	</tr>
	<tr>
		<td>메모</td>
		<td><textarea rows="4" cols="50" name="memo"></textarea></td>
	</tr>
</table>
<hr>
<input type="submit" value="가입">
</form>



</body>
</html>