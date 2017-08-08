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
	<h2>Winkelwagen</h2>
	<c:if test="${not empty mandje}">
		<h1>Brouwers</h1>
		<table>
			<tbody>
				<c:forEach items='${mandje}' var='bestelbonlijn'>
					<tr>
						<td>${bestelbonlijn.aantal} </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</c:if>
</body>
</html>