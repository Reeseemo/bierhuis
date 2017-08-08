<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Brouwers' />
</head>
<body>
	<v:menu />
	<c:if test="${not empty page.content}">
		<h1>Brouwers</h1>
		<table>
			<tbody>
				<c:forEach items='${page.content}' var='brouwer'>
					<tr>
						<td><spring:url var='urlb' value='/brouwers/{id}'>
								<spring:param name='id' value='${brouwer.id}' />
							</spring:url> <a href='${urlb}'>${brouwer.naam} (${brouwer.gemeente})</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p class='pagineren'>
			<c:forEach var="pageNr" begin="1" end="${page.totalPages}">
				<c:choose>
					<c:when test="${pageNr-1 == page.number}">
${pageNr}
</c:when>
					<c:otherwise>
						<c:url value="" var="url">
							<c:param name="page" value="${pageNr-1}" />
						</c:url>
						<a href="${url}">${pageNr}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</p>
	</c:if>
	<c:if test="${not empty model}">
		<h2>${model.brouwer.naam} (${model.brouwer.gemeente})</h2>
				<table>
			<tbody>
				<c:forEach items='${model.bieren}' var='bier'>
					<tr>
						<td>
						<spring:url var='urlbi' value='/bieren/{bierid}'>
								<spring:param name='bierid' value='${bier.id}' />
							</spring:url> <a href='${urlbi}'>${bier.naam}</a>
						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</c:if>
</body>
</html>