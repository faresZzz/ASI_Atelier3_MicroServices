
var userId = localStorage.getItem("userId")
userId = 2
if (userId)
{
   $("document").ready(function (userId){
       fetch("http://localhost:3081/user/getUserbyId" + userId)
       .then(reponse => reponse.json())
       .then(reponse => getUser(reponse))
   })
}
else{
    window.location.replace("index.html")
}

function getUser(data)
{
    document.getElementById("userSurname").innerHTML = data.name;
    document.getElementById("userBank").innerHTML = data.bank;
}