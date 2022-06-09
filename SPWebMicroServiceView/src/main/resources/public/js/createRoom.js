// createRoom.html
function createRoom()
{
    json_obj=JSON.stringify({
        name: document.getElementById("roomName").value,
        bet: document.getElementById("roomBet").value,
   
    });
    

    fetch("http://localhost:3084/room/newRoom/" + userId , {
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
        if (response.full == false)
        {
            waitingMenu(response)
        }
    } )
            
    
    .catch(error => alert(error));
}


function waitingMenu(room)
{
    document.getElementById("form").style.display = "none"
    document.getElementById("waitingRoom").style.display = "block"
    waiting(room)
}

async function waiting(room)
{
    setInterval(() => {
        fetch("http://localhost:3084/room/" + room.id)
        .then(response => response.json())
        .then((response => {
            console.log(response)
            if (response.player2Id == 0)
            {
                waiting(response)
            }
            else
            {
                sessionStorage.setItem("roomId", response.id)
                window.location = "playRoom.html"
            }
        }))
    }, 5000);
    
   
}
