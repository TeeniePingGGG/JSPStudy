<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
include 지시어를 통해 파일을 포함시키면 컴파일 되지 않은
원본 상태의 코드가 그대로 포함된 후 컴파일을 진행한다.
따라서 아래에 사용한 변수들을 해당 문서에 포함된 상태이므로
문제없이 실행된다.
 -->
<%@ include file="IncludeFile.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 지시어</title>
</head>
<body>
<%
//out 내장 객체를 이용해서 웹브라우저에 변수의 값을 출력한다.
out.println("오늘 날짜:"+today);
out.println("</br>");
out.println("내일 날짜:"+tomorrow);
%>

</body>
</html>