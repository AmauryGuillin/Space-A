const username = document.getElementById("registrationForm:register-username");
const pwdOne = document.getElementById("registrationForm:pwdOne");
const pwdTwo = document.getElementById("registrationForm:pwdTwo");
const button = document.getElementById("registrationForm:register-btn");
const email = document.getElementById("registrationForm:user-email");

button.disabled = true;

console.log(username);

username.addEventListener("input", (e) => {
	let txt = e.target.value;
	if(txt.isEmpty()){
		alert("Le nom d'utilisateur ne peut pas être vide");
	} else {
		button.disabled = false;
	}
});


pwdTwo.addEventListener("change", (e) => {
	let txtOne = pwdOne.value;
	let txt = e.target.value;
	
	if (txt !== txtOne){
		button.disabled = true;
		alert("Vos mots de passe doivent correspondre");
	} else {
		button.disabled = false;
	}
});

email.addEventListener("change", (e) => {
	let txt = e.target.value;
	
	if(txt.isEmpty()){
		button.disabled = true;
		alert("Vous devez renseigner votre email")
	} else {
		button.disabled = false;
	}
	
});

