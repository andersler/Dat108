<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	
	<form action="betingelse" method="get">
	
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${deltaker.fornavn}<br/>
		&nbsp;&nbsp;&nbsp;${deltaker.etternavn} <br/>
		&nbsp;&nbsp;&nbsp;${deltaker.mobil} <br /> 
		&nbsp;&nbsp;&nbsp;${deltaker.kjonn} <br /> 
		
	</p>
	<a href="deltakerliste">Gå til deltagerlisten</a>
	
	</form>
</body>
</html>