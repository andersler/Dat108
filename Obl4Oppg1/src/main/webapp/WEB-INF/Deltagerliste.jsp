<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>

	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Fornavn</th>
			<th align="left">Etternavn</th>
			<th align="left">Mobil</th>
		</tr>


		<c:forEach items="${deltaker}" var="d">


			<tr bgcolor=${d.mobil == currentDeltaker ? '#aaffaa' : '#ffffff'}>

				<c:choose>

					<c:when test="${d.kjonn =='mann'}">
						<td>&#9792;</td>
					</c:when>
					<c:otherwise>
						<td>&#9794;</td>
					</c:otherwise>

				</c:choose>

				<td align="center">${d.fornavn}</td>
				<td>${d.etternavn}</td>
				<td>${d.mobil}</td>

			</tr>
		</c:forEach>

	</table>

	<p>
		<a href="loggut">Ferdig</a>
	</p>

</body>
</html>