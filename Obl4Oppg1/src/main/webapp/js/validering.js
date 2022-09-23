"use strict"

function sjekkPassordrepetert() {
	if (document.getElementById("passord").value ==
		document.getElementById("passordrepetert").value &&
		!erBlank(document.getElementById("passordrepetert").value)) {

		document.getElementById("passordrepetert").style.borderColor = "green";

	} else {

		document.getElementById("passordrepetert").style.borderColor = "red";

	}
};


function sjekkPassordStyrke() {


	if (document.getElementById("passord").value.length >= 12 &&
		!erBlank(document.getElementById("passord").value)) {
		document.getElementById("passord").style.borderColor = "green";


	} else if (document.getElementById("passord").value.length >= 4
		&& !erBlank(document.getElementById("passord").value)) {
		document.getElementById("passord").style.borderColor = "yellow";



	} else {

		document.getElementById('passord').style.borderColor = 'red';

	}
};

function erBlank(str) {
	return (!str || /^\s*$/.test(str));
}
