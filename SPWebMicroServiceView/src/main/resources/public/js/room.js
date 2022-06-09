// room.html
function getListRoom()
{
    fetch("http://localhost:3084/room/roomList/" + userId)
        .then(reponse => reponse.json())
        .then((data) => {
            console.log(data)
            $("#tableRoom").bootstrapTable({
                data : data
            })

            if( data == undefined || data.length < 1)
            {
                let errorMessage = document.createElement("p")
                errorMessage.innerText = "Malheuresement aucune Room n'est disponible pour le moment. Revenez plus tard ou profitez en pour crée la votre !!! "
                errorMessage.style.color = "red"
                document.getElementById("Infos").appendChild( errorMessage)
            }
        })
}


function actionFormatter(value, row){
    //  preview facture
    return `<button  id = ${row.id}  type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" onclick = "joinRoom(${row.id})">Go</button>`;
}


function joinRoom(roomId)
{
    
    fetch("http://localhost:3084/room/join/" + roomId + "?idPlayer=" + userId, 
    {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }
    })
    .then(response => response.json())
    .then((response) => {
        console.log(response)
        sessionStorage.setItem("roomId", response.id)
        window.location = "playRoom.html"
    })
}



function createRoomFrom()
{
    window.location = "./createRoom.html"
}



// var rooms = 
// [
//     {
//         "name" :"room1" ,
//         "bet" : 500
//     },
//     {
//         "name" :"room2" ,
//         "bet" : 400
//     },
//     {
//         "name" :"room3" ,
//         "bet" : 50
//     }
// ]