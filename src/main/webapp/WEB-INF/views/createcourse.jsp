<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<h4>2019학년 1학기 예상 교과목</h4>
<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="course">
	<table class="formtable">
		<tr><td>수강 년도: </td> <td> <sf:input class="control" type="text" path="year"/> <br/>
			<sf:errors path="year" class="error"/> </td> </tr>
		<tr><td>수강 학기: </td> <td> <sf:input class="control" type="text" path="semester"/> <br/>
			<sf:errors path="semester" class="error"/> </td> </tr>	
		<tr><td>교과코드: </td> <td> <sf:input class="control" type="text" path="courseCode"/> <br/>
			<sf:errors path="courseCode" class="error"/> </td> </tr>	
		<tr><td>교과목명: </td> <td> <sf:input class="control" type="text" path="courseName"/> <br/>
			<sf:errors path="courseName" class="error"/> </td> </tr>
		<tr><td>구분: </td> <td> <sf:input class="control" type="text" path="classify"/> <br/>
			<sf:errors path="classify" class="error"/> </td> </tr>	
		<tr><td>학점: </td> <td> <sf:input class="control" type="text" path="grade"/> <br/>
			<sf:errors path="grade" class="error"/> </td> </tr>		
		<tr><td class="label"> </td> <td> <input class="control" type="submit" value="신청하러 가기"> </td> </tr>
	</table>
</sf:form>
</body>
</html>