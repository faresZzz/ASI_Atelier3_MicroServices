async function send_sign() 
{
	if (document.getElementById("userPassword_input").value == document.getElementById("userConfirm_password_input").value){
	    json_obj=JSON.stringify({
	        name: document.getElementById("userName_input").value,
	        surname: document.getElementById("userSurname_input").value,
	        password: document.getElementById("userPassword_input").value,
			
		});
	        
	
	    fetch("/addUser", {
	        method: 'POST',
	        headers: {
	            'Accept': 'application/json',
	            'Content-Type': 'application/json'
	          },
	        body: json_obj
	    })
		.then(function(reponse) {
			if (!reponse.ok) {
				throw new Error(`erreur HTTP! statut: ${reponse.status}`);
	  		}
			return reponse.json();
			})
		.then(function(reponse) {
				
				window.location.replace("/cards.html?"+reponse);
				
			} )
			.catch(error => console.log(error));
	  }
	else{
		console.log("les mdp ne correspondent pas")
	}
	
}

async function send_log() 
{
    json_obj=JSON.stringify({
        surname: document.getElementById("userSurname_input").value,
        password: document.getElementById("userPassword_input").value
	});
        

    fetch("/logIn", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        body: json_obj
    })
	.then(function(reponse) {
		if (!reponse.ok) {
			throw new Error(`erreur HTTP! statut: ${reponse.status}`);
  		}
		return reponse.json();
		})
	.then(function(reponse) {
			window.location.replace("/cards.html?"+reponse);
		} )
		.catch(error => console.log(error));
    
    

}