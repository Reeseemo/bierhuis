<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Bierhuis' />
</head>
<body>
	<v:menu />
	<h2>Welkom in het huis van de Belgische bieren</h2>
	<%-- 	<img alt='bieren' src='<c:url value="/images/bierhuis.jpg"/>' class='fullwidth'> --%>
	<p>We hebben momenteel ${aantalBieren} bieren</p>
</body>
</html>