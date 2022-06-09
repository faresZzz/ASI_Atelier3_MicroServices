var userId = sessionStorage.getItem("userId")

if (userId)
{
    fetch("http://localhost:3081/user/getUserById/" + userId)
    .then(reponse => reponse.json())
    .then((reponse) => {
        addUserInformation(reponse)
    })
}
else
{
    window.location.replace("index.html")
}


function addUserInformation(user) 
{
    document.getElementById("name").innerText = "Name : "+ user.name;
    document.getElementById("surname").innerText = "Surname : "+ user.surname;
    document.getElementById("bank").innerText = "Bank : " + user.bank + "$";
    console.log(user.cardListId)
    for (let cardId of user.cardListId)
    {
        fetch("http://localhost:3080/card/getCard/" + cardId)
        .then(reponse => reponse.json())
        .then((reponse) => {
            addCard(reponse)
        })
    }
}

function addCard(card)
{
    let cardList = document.getElementById("listCards")
    
    let newElementList = document.createElement("li")
    newElementList.setAttribute("id", "card"+ card.id)

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

