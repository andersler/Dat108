<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	type="text/css">

<style type="text/css">
#input:valid, #passord:valid, #passordrepetert:valid {
	border-color: green;
}

#input:invalid, #passord:invalid, #passordrepetert:invalid {
	border-color: red;
}
</style>


<title>Påmelding</title>

<script src="js/validering.js"></script>
</head>

<body>
	<h2>Påmelding</h2>
	<font color="red">${melding}</font>

	<form id="form" action="skjema" method="post"
		class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name="fornavn" id="input" value="${bean.fornavn}"
					title="Fornavn må starte med stor bokstav, så små" required
					pattern="^[A-Z][a-z]{2,}?[\s\-\(A-Za-z)]*$" /> <font
					color="red">${bean.fornavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn: </label> <input type="text"
					name="etternavn" id="input" value="${bean.etternavn}" required
					pattern="^[A-Z][a-zA-Z]{3,}$"
					title="Fornavn må starte med stor bokstav, så små" /> <font
					color="red">${bean.etternavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
					name="mobil" id="input" value="${bean.mobil}" required
					pattern="^\d{8}$" title="Mobil må ha 8 siffer" />
				<font color="red">${bean.mobilFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					name="passord" value="${bean.passord}" id="passord" required
					pattern="^[A-Za-zÆØÅæøå\d]{4,}$" title="Passord må minst ha 3 tegn"
					onkeyup='sjekkPassordStyrke(); sjekkPassordrepetert()();' />
				<font color="red">${bean.passordFeilmelding}</font>

			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" name="passordrepetert" id="passordrepetert"
					value="${bean.passordrepetert}" title="Må være lik som passordet"
					onkeyup='sjekkPassordrepetert();' required
					pattern="^[A-Za-zÆØÅæøå\d]{4,}$" /> <font color="red">${bean.passordrepetertFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann" />mann <input type="radio" name="kjonn"
					value="kvinne" />kvinne <font color="red">${bean.kjonnFeilmelding}</font>

			</div>
			<div class="pure-controls">

				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>

			</div>
		</fieldset>
	</form>
</body>

</html>