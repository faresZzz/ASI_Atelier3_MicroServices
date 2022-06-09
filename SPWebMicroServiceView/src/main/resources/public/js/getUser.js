
var userId = sessionStorage.getItem("userId")
if (userId)
{
   fetch("http://localhost:3081/user/getUserById/" + userId)
    .then(reponse => reponse.json())
    .then(reponse => getUser(reponse))
}

else{
    window.location.replace("../index.html")
}

function getUser(data)
{
    document.getElementById("userSurname").innerHTML = "Bienvenu : " + data.name;
    document.getElementById("userBank").innerHTML = "Bank : " + data.bank + "$";
}

function logout()
{
    sessionStorage.clear()
    window.location.replace("../index.html")
}


