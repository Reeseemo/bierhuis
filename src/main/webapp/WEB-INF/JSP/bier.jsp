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
		<c:url value='/mandje' var='url' />
		<form:form action='${url}' 
		modelAttribute="bestelbonlijn" 
		id='aantal'>
			<form:label path='aantal'>Aantal:
			<form:errors path='aantal' delimiter=', ' />
			</form:label>
			<form:input path='aantal' autofocus='autofocus' required='required'
				type='number' min='1' maxlength='7' />

			<form:hidden path='prijs' value ='${model.bier.prijs}'/>
			<form:hidden path='bestelbonlijnId.bierid' value='${model.bier.id}'/>
			<input type='submit' value='Toevoegen' id='submitknop'>
			<script>
				document.getElementById('aantal').onsubmit = function() {
					document.getElementById('submitknop').disabled = true;
				};
			</script>
		</form:form>
	</c:if>

</body>
</html>