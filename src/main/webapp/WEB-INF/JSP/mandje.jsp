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
	
		<table>
		<thead>
			<tr>
				<th>Bier</th>
				<th>Prijs</th>
				<th>Aantal</th>
				<th>Te betalen</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${mandje}' var='bestelbonlijn'>
				<tr>
					<td>${bestelbonlijn.bestelbonlijnId.bierid}</td>
					<td>${bestelbonlijn.prijs}</td>
					<td>${bestelbonlijn.aantal}</td>
					<td>${bestelbonlijn.prijs * bestelbonlijn.aantal}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
		<c:url value='/bestelbon' var='url' />
	<v:bestelbonform url='${url}' knopTekst='Als bestelbon bevestigen' />
		
	</c:if>
</body>
</html>