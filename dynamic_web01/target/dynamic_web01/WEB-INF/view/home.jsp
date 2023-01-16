<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: <%=(String)request.getAttribute("color") %>">직접 생성한 JSP/Servlet 페이지</h1>
	<form action="./home" method="get">
		<input type="text" name="color">
		<button type="submit">전송</button>
	</form>
	<p>
		${"EL Test"}<br>
		${10 + 20}<br>
		${10 div 3}<br>	<!-- html 코드와 헷갈릴 수 있으므로 div와 같이 키워드를 쓰는 것이 좋다 -->
		${10 mod 3}<br>
		${10 eq 10}<br>
		${10 ne 20}<br>
		${10 le 20}<br>
		${10 lt 20}<br>
		${20 ge 10}<br>
		${20 gt 10}<br>
		${true and true}<br>
		${true or true}<br>
		${not true}<br>
		${empty param.color}<br> <!-- 빈 문자열인지 아닌지를 체크하는 명령어 -->
		${requestScope.color }<br>
		${param.color }<br>
		${"문자열"}${"문자열"}${10}<br> <!-- 문자열을 합치는 + 연산자가 작동되지 않는다 -->
	</p>
	<h3>JSTL - core</h3>

	<h4>변수 설정</h4>
	<c:set var="name" value="값" />

	<h4>변수 삭제</h4>
	<c:remove var="name" />
	${empty name ? "삭제됨" : name}
	<br>

	<h4>조건문</h4>
	<c:set var="val" value="10" />
	<c:if test="${val == 10}" var="result">
		조건식의 결과 -> ${result }
	</c:if>
	<!-- if-else 구문 사용-->
	<c:choose>
		<c:when test="조건식1"></c:when>
		<c:when test="조건식2"></c:when>
		<c:when test="조건식3"></c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	<br>

	<%--
	<c:forEach var="변수명" items="배열 또는 컬렉션" varStatus="loop">
		${loop.index }<br> <!-- 0번부터 시작 순서 -->
		${loop.count }<br> <!-- 1번부터 시작 순서 -->
		${loop.first }<br> <!-- 첫번째 반복 유무를 확인 -->
		${loop.last }<br> <!-- 마지막 반복 유무를 확인 -->
	</c:forEach>

	<c:forTokens var="변수명" items="문자열" delims="구분문자">
		특정 구분문자로 구성된 문자열을 분리하여 반복하기 위한 기능
		010-1234-5678
	</c:forTokens>
	--%>

	<h4>반복문</h4>
	<c:forEach var="i" begin="0" end="5" step="1">
		${i }/
	</c:forEach>

	<c:forEach var="v" items="${arr }">
		${v }/
	</c:forEach>
	<br>

	<c:forEach var="v" items="${arr }">
		${loop.index } - ${loop.count } - ${v } - first:${loop.last }<br>
	</c:forEach>
	<br>

	<c:forTokens var="v" items="010-1234-5678" delims="-">
		${v }<br>
	</c:forTokens>
	<br>
	<%--
	<h4>URL 주소 생성</h4>
	<c:url var="변수명" value="URL 주소">
		<c:param name="파라미터명1" value="파라미터값1" />
		<c:param name="파라미터명2" value="파라미터값2" />
	</c:url>
	--%>

	<h4>URL 주소 생성</h4>
	<c:url var="url" value="/home">
		<c:param name="param" value="1" />
		<c:param name="key" value="value" />
	</c:url>
	${url }
	<br>

	<h3>JSTL - function</h3>
	<h4>contains(전체문자열, 일부문자열)</h4>
	${fn:contains("Hello JSTL Tag Library", "JSTL") }

	<h4>containsIgnoreCase(전체문자열, 일부문자열)</h4>
	${fn:containsIgnoreCase("Hello JSTL Tag Library", "jstl")}

	<h4>replace(전체문자열, 변경전문자열, 변경후문자열)</h4>
	${fn:replace("Hello JSTL Tag Library", "Tag", "태그")}

	<h4>split(전체문자열, 분리구분문자)</h4>
	<c:forEach var="str" items="${fn:split('Hello JSTL Tag Library', ' ')}">
		${str }<br>
	</c:forEach>

	<h4>join(분리된문자열배열, 결합구분문자)</h4>
	<c:set var="strArr" value="${fn:split('Hello JSTL Tag Library', ' ')}" />
	${fn:join(strArr, "-")}

	<h4>toLowerCase(전체문자열)</h4>
	${fn:toLowerCase("Hello JSTL Tag Library")}

	<h4>toUpperCase(전체문자열)</h4>
	${fn:toUpperCase("Hello JSTL Tag Library")}

	<h4>trim("전체문자열")</h4>
	${fn:trim("   Hello JSTL Tag Library    ")}

	<h4>length("전체문자열")</h4>
	${fn:length("Hello JSTL Tag Library")}

	<h4>substring("전체문자열", 시각위치, 끝위치)</h4> <!-- 시작위치는 0번, 끝위치는 -1 -->
	${fn:substring("Hello JSTL Tag Library", 6, 10)}

	<h3>JSTL - formatting</h3>

	<h4>number formatting</h4>
	<c:set var="num" value="123456.789" />
	<c:set var="flt" value="0.12345" />
	<fmt:formatNumber value="${num }" type="number" /><br>
	<fmt:formatNumber value="${num }" type="number" groupingUsed="false" /><br>
	<fmt:formatNumber value="${num }" type="currency" /><br>
	<fmt:formatNumber value="${flt }" type="percent" maxFractionDigits="2"/><br>
	<fmt:formatNumber value="${num }" type="number" maxFractionDigits="2"/><br>

	<h4>date formatting</h4>
	<c:set var="now" value="<%=new Date()%>"/>
	<fmt:formatDate type="date" value="${now }" /><br>
	<fmt:formatDate type="date" dateStyle="short" value="${now }"/><br>
	<fmt:formatDate type="date" dateStyle="medium" value="${now }"/><br>
	<fmt:formatDate type="date" dateStyle="long" value="${now }"/><br>
	<br>
	<fmt:formatDate type="time" value="${now }" /><br>
	<fmt:formatDate type="time" timeStyle="short" value="${now }"/><br>
	<fmt:formatDate type="time" timeStyle="medium" value="${now }"/><br>
	<fmt:formatDate type="time" timeStyle="long" value="${now }"/><br>
	<br>
	<fmt:formatDate type="both" value="${now }" /><br>
	<fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now }"/><br>
	<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now }"/><br>
	<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now }"/><br>
	<br>
	<fmt:formatDate type="both" pattern="yyyy-MM-dd a hh:mm:ss" value="${now }" /><br>
	<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss" value="${now }" /><br>
	<br>
	<c:set var="date" value="2023-01-16"/>
	<!-- 사용자로 부터 값을 입력받고 페이지에 출력하고자 할 때 형변환 -->
	<fmt:parseDate var="date2" value="${date}" pattern="yyyy-MM-dd"/>
	<fmt:formatDate type="date" dateStyle="short" value="${date2 }"/><br>
	<fmt:formatDate type="date" dateStyle="medium" value="${date2 }"/><br>
	<fmt:formatDate type="date" dateStyle="long" value="${date2 }"/><br>
</body>
</html>