var operator = 0;
var eerdereGetal = 0;
var huidigeGetal = 0;
var trrue = 0;

function setHuidigeGetal () {
	eerdereGetal = huidigeGetal;
	huidigeGetal = document.getElementById("display").innerHTML;
	document.getElementById("display").innerHTML = null;
}

function setOperator (clicked_id) {
	operator = document.getElementById("clicked_id").innerHTML;
	eerdereGetal = huidigeGetal;
	huidigeGetal = document.getElementById("display").innerHTML;
	document.getElementById("display").innerHTML = null;
}

function appendGetal (clicked_id) {
	if (trrue == 1) {
	document.getElementById("display").innerHTML = document.getElementById("clicked_id").innerHTML;
	huidigeGetal = document.getElementById("display").innerHTML;
	trrue = 0;
	}
	else {
		console.log(document.getElementById("clicked_id"));
		document.getElementById("display").innerHTML = document.getElementById("display").innerHTML + document.getElementById("clicked_id").innerHTML;
		huidigeGetal = document.getElementById("display").innerHTML;
	}
}

function equals () {
	document.getElementById("display").innerHTML = ((eerdereGetal) (operator) (huidigeGetal));
	eerdereGetal = huidigeGetal;
	huidigeGetal = document.getElementById("display").innerHTML
	trrue = 1;
}
