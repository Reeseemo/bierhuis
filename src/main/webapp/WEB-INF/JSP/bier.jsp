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
	<c:if test="${not empty model}">
		<h2>${model.bier.naam}</h2>
		<dl>
			<dt>Alcohol</dt>
			<dd>${model.bier.alcohol}%</dd>
			<dt>Prijs</dt>
			<dd>${model.bier.prijs}€</dd>
			<dt>Soort</dt>
			<dd>${model.soort.naam}</dd>
			<dt>Brouwer</dt>
			<dd>${model.brouwer.naam}</dd>
		</dl>
		<c:url value='/bier' var='url' />
			<form action='${url}' commandName='aantal' id='toevoegform'>
				<label path='aantal'>Aantal<errors path='aantal' />
				</label> <input path='aantal' autofocus='autofocus' required='required'
					type='number' min='1' maxlength='7' /> <input type='submit'
					value='Toevoegen' id='toevoegknop'>
			<script>
				document.getElementById('toevoegform').onsubmit = function() {
					document.getElementById('toevoegknop').disabled = true;
				};
			</script>
			</form>
	</c:if>

</body>
</html>