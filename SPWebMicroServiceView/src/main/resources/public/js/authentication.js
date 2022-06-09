
function SendUser() 
{
	
	if (document.getElementById("userPassword_input").value == document.getElementById("userConfirm_password_input").value){
		

	    json_obj=JSON.stringify({
	        name: document.getElementById("userName_input").value,
	        surname: document.getElementById("userSurname_input").value,
	        passwd: document.getElementById("userPassword_input").value,
		
		});
	    
	
	    fetch("http://localhost:3082/signin", {
	        method: 'POST',
	        headers: {
	            'Accept': 'application/json',
	            'Content-Type': 'application/json',
	          },
	        body: json_obj
	    })
		.then( reponse => reponse.json())
		.then((response) =>{
			console.log(response)
			sessionStorage.setItem("userId", response) 
			window.location = "menu.html"
		} )
				
		
		.catch(error => alert(error));
	  }
	else{
		alert("les mdp ne correspondent pas")
	}
	
}

function send_log() 
{
    json_obj=JSON.stringify({
        surname: document.getElementById("userSurname_input").value,
        passwd: document.getElementById("userPassword_input").value
	});
        

    fetch("http://localhost:3082/login", {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json',
	 	},
		body: json_obj
	})
	.then( reponse => reponse.json())
	.then((response) =>{
		console.log(response)
		sessionStorage.setItem("userId", response) 
		window.location = "menu.html"
	} )


	.catch(error => console.log(error));
    
    

}