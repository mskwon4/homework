<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>이수 학점</th>
			<th>상세보기</th>
		</tr>
		<c:if test="${2017}">	<!-- 년도-학기별 이수학점 모으고 상세보기 해서 링크 누르면 교과목 리스트 출력 -->
			<div></div>
		</c:if>
		<c:forEach var="course" items="${courses}">
			<p>
				<c:out value="${course}"></c:out>
			</p>
		</c:forEach>
	</table>
</body>
</html>