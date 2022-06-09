$(document).ready(function() {
    console.log("ready")

    userId = sessionStorage.getItem("userId")

    fetch("http://localhost:3080/card/getCardByOwner/" + userId)
    .then(reponse => reponse.json())
    .then((data) => {
        dataCard = data.listCard
        $("#cardList").bootstrapTable({
            data : dataCard
        })
        
    
    })
})  

function actionFormatter(value, row){
    //  preview facture
    return `<button  id = ${row.id}  type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" onclick = "getCard(${row.id})">Select</button>`;
}

function getCard(cardId) {

    for (card of dataCard)
    {
        if (card.id == cardId)
        {
            console.log(card)
            fetch("http://localhost:3084/room/start/" +  sessionStorage.getItem("roomId") + "?idPlayer=" + card.ownerId + "&cardId=" +card.id , 
            {
                method: 'PUT',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                }
            })
            .then(response => response.json())
            .then((room) => {
                console.log(room)
                if (room.cardPlayer2 != null && room.cardPlayer1 != null)
                {
                    startGame(room)
                }
                else{
                    waiting(room)
                }
            })
        }
    }
  }

function waitForOtherPlayer(room) 
{
    
    
}
async function waiting(room)
{
    document.getElementById("cardList").style.display = "none"
    document.getElementById("selectCard").style.display = "none"
    document.getElementById("waitingMessage").style.display = "block"
    setTimeout(() => {
        fetch("http://localhost:3084/room/" + room.id)
        .then(response => response.json())
        .then((room => {
            if (room.cardPlayer2 == null || room.cardPlayer1 == null)
            {
                waiting(room)
            }
            else
            {
                startGame(room)
            }
        }))
    }, 1000);
    
   
}
function startGame(room)
{
    document.getElementById("header").style.display = "none"
    document.getElementById("cardList").style.display = "none"
    document.getElementById("selectCard").style.display = "none"
    document.getElementById("waitingMessage").style.display = "none"

    displayCard(room.cardPlayer1)
    displayCard(room.cardPlayer2)
    play(room.cardPlayer1, room.cardPlayer2, room )
}

function displayCard(card)
{
    let cardList = document.getElementById("cardsPlayer")

    let newElementList = document.createElement("div")
    newElementList.setAttribute("id", "cardPlayer"+ card.ownerId)

    let newCard = document.createElement("div")
    newCard.setAttribute("id", "card"+ card.id)

    let cardName = document.createElement("h4")
    cardName.innerText  = card.name
    newCard.appendChild(cardName)
    
    let cardDescription = document.createElement("textarea")
    cardDescription.innerText  = card.description
    cardDescription.setAttribute("cols", 50)
    newCard.appendChild(cardDescription)

    let cardImage = document.createElement("img")
    cardImage.setAttribute("src", card.imgUrl)
    cardImage.setAttribute("alt", "Image de la carte")
    cardImage.setAttribute("height", 200) 
    newCard.appendChild(cardImage)

    let cardFamily = document.createElement("p")
    cardFamily.innerHTML = "Family : " + card.family
    newCard.appendChild(cardFamily)

    let cardAffinity = document.createElement("p")
    cardAffinity.innerHTML = "Affinity : " + card.affinity
    newCard.appendChild(cardAffinity)

    let cardHp = document.createElement("p")
    cardHp.innerHTML = "HP : " + card.hp
    cardHp.setAttribute("id", "hp")
    newCard.appendChild(cardHp)
    
    let cardEnergy = document.createElement("p")
    cardEnergy.innerHTML = "Energy : " + card.energy
    newCard.appendChild(cardEnergy)

    let cardAttack = document.createElement("p")
    cardAttack.innerHTML = "Attack : " + card.attack
    newCard.appendChild(cardAttack)

    let cardDefence = document.createElement("p")
    cardDefence.innerHTML = "Defence : " + card.defence
    newCard.appendChild(cardDefence)

    let cardPrice = document.createElement("p")
    cardPrice.innerHTML = "Price : " + card.attack
    newCard.appendChild(cardPrice)

    newElementList.appendChild(newCard)

    cardList.appendChild(newElementList)
}

function play(card1, card2, room) 
{
    
    let i=1
    let continuGame = true
    let hpInit1 = card1.hp
    let hpInit2 = card2.hp
    let winner = -1
    tour(card1, card2, hpInit1, hpInit2, i, continuGame, winner, room)
    
}

function tour(card1, card2, hpInit1, hpInit2, i, continuGame, winner, room)
{
    let text = document.getElementById("gameSteps")
    let cardPlayer1 = document.getElementById("cardPlayer" + card1.ownerId).querySelector("#hp")
    let cardPlayer2 = document.getElementById("cardPlayer" + card2.ownerId).querySelector("#hp")

    if (continuGame)
    {
        text.innerText = "Tour : " + i
        // attack1 = card1.attack > card2.defence ?( 100 * (card1.attack / (card1.attack - card2.defence))) *(card1.hp /hpInit1):  (100 * (1 / (card2.defence - card1.attack)) ) *(card1.hp /hpInit1)
        // attack2 = card2.attack > card1.defence ?( 100 * ( card2.attack / (card2.attack - card1.defence)) *(card2.hp /hpInit2) ):  (100 * (1 / (card1.defence - card2.attack)) ) *(card2.hp /hpInit2)
        
        attack1 = card1.attack
        attack2 = card2.attack
        console.log("Attack 1:"+ attack1)
        console.log("Attack 2:" +attack2)
        card1.hp -= attack2 
        cardPlayer1.innerText = "HP : " + card1.hp
        card2.hp -= attack1 
        cardPlayer2.innerText = "HP : " + card2.hp

        if (card1.hp <= 0) 
        {
            continuGame = false
            winner = card2.ownerId
        }
        else if (card2.hp <= 0) 
        {
            continuGame = false
            winner = card1.ownerId
        }
        i++

        setTimeout(() =>{tour(card1, card2, hpInit1, hpInit2, i, continuGame, winner, room)}, 2000)
    }
    else 
    {
        endGame(winner, room)
    }

}
function endGame(winner, room)
{
    document.getElementById("gameSteps").innerText = "Fin de la partie. Le winner est :" + winner 
    fetch("http://localhost:3084/room/endOfGame/" + room.id + "?winner=" +winner, 
    {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }
    })
    .then(response => response.json())
    .then((response) => {

        if (response == true)
        {

            setTimeout(() => {window.location.replace("menu.html")}, 2000)
        }
    })
}