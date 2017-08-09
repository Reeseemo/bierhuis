<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
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
						<td>${bestelbonlijn.value.bestelbonlijnId.bierid}</td>
						<td>${bestelbonlijn.value.prijs}</td>
						<td>${bestelbonlijn.value.aantal}</td>
						<td>${bestelbonlijn.value.prijs * bestelbonlijn.value.aantal}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:url value='/mandje/bestelbon' var='url' />
		<form:form action='${url}' modelAttribute="bestelbon" id='bestelform'>
			<form:label path='naam'>Naam:<form:errors path='naam' />
			</form:label>
			<form:input path='naam' autofocus='autofocus' required='required'
				maxlength='50' />
			<form:label path='straat'>Straat:
<form:errors path='straat' delimiter=', ' />
			</form:label>
			<form:input path='straat' required='required' maxlength='50' />

			<form:label path='huisNr'>Huisnr.:
<form:errors path='huisNr' delimiter=', ' />
			</form:label>
			<form:input path='huisNr' required='required' maxlength='7' />
			<form:label path='postcode'>Postcode:
<form:errors path='postcode' delimiter=', ' />
			</form:label>
			<form:input path='postcode' required='required' type='number'
				min='1000' max='9999' />
			<form:label path='gemeente'>Gemeente:
<form:errors path='gemeente' delimiter=', ' />
			</form:label>
			<form:input path='gemeente' required='required' maxlength='50' />

			<input type='submit' value='Als bestelbon bevestigen' id='submitknop'>
			<script>
				document.getElementById('bestelform').onsubmit = function() {
					document.getElementById('submitknop').disabled = true;
				};
			</script>
		</form:form>

	</c:if>
	
	<c:if test="${empty mandje}">
	<h3>Uw winkelwagen is leeg</h3>
	</c:if>
</body>
</html>