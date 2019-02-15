<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>전체보기</h2>
<table>
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>주소</td>
		<td>메모</td>
		<td>삭제</td>
	</tr>
<c:forEach items="${vo }" var="vo">
	<tr>
		<td><a href="findById?id=${vo.id }">${vo.id }</a></td>
		<td>${vo.name }</td>
		<td>${vo.addr }</td>
		<td>${vo.memo }</td>
		<td><a href="delete?id=${vo.id }">삭제</a></td>
	</tr>
</c:forEach>
</table>
${pageHtml }
<form action="member_list.do">
<table>
	<tr>
		<td>
			<select name="field">
				<option value="name">이름</option>
				<option value="memo">내용</option>
			</select>
			<input type="text" name="word">
			<input type="submit" value="확인">
		</td>
	</tr>
</table>
</form>
</div>

</body>
</html>