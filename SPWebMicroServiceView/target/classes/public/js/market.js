
var dataCard;
var action;
$(document).ready(function() {
    console.log("ready")

    action = sessionStorage.getItem("action")
    userId = sessionStorage.getItem("userId")
    if (action == "buy")
    {
        fetch("http://localhost:3083/market/buy/" + userId)
        .then(reponse => reponse.json())
        .then((data) => {
            dataCard = data.listCard
            $("#tableBuy").bootstrapTable({
                data : dataCard
            })
            $("#sell").hide()
            $("#action").append("BUY")
            if (dataCard == undefined || dataCard.length <1 )
            {
                let errorMessage = document.createElement("p")
                errorMessage.innerText = "Malheuresement aucune carte n'est en vente sur la marcher pour le moment. Revenez plus tard !!!"
                errorMessage.style.color = "red"
                document.getElementById("action").appendChild( errorMessage)
            }
        
    })
    }
    else if (action == "sell")
    {
        fetch("http://localhost:3083/market/sell/" + userId)
        .then(reponse => reponse.json())
        .then((data) => {
            dataCard = data.listCard
            $("#tableSell").bootstrapTable({
                data : dataCard
            })
            $("#buy").hide()
            $("#action").append("SELL")
            $("#modalFooter").append('<input type="number" name="price" id="priceSell">')

        })

    }
    else
    {

        $("#sell").hide()
        $("#buy").hide()
        let action = document.getElementById("default")


        let buyButton = document.createElement("button")
        buyButton.setAttribute("value", "buy")
        buyButton.innerHTML = "BUY"
        buyButton.onclick = function(event)
        {
            sessionStorage.setItem("action", "buy")
            location.reload()
        }

        let sellButton = document.createElement("button")
        sellButton.setAttribute("value", "sell")
        sellButton.innerHTML = "SELL"
        sellButton.onclick = function(event)
        {
            sessionStorage.setItem("action", "sell")
            location.reload()
        }

        action.appendChild(buyButton)
        action.appendChild(sellButton)

    }
})



function actionFormatter(value, row){
    //  preview facture
    return `<button  id = ${row.id}  type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" onclick = "cardInfo(${row.id})">$</button>`;
}


function cardInfo(cardId)
{
    for( let card of dataCard)
    {
        if (card.id ==  cardId)
        {
            let idCard = document.createElement("span")
            idCard.innerHTML = "( n° " + card.id + ")" 
            idCard.setAttribute("id" , "cardId")

            document.getElementById("cardName").innerText = card.name
            document.getElementById("cardName").appendChild(idCard)

            document.getElementById("cardPrice").innerText = "Actual price : " + card.price + "$"
            document.getElementById("cardImage").setAttribute("src", card.imgUrl) 
            document.getElementById("cardImage").setAttribute("height", 200) 
            document.getElementById("cardFamily").innerText = "Family : " + card.family
            document.getElementById("cardDescription").innerText = card.description
            document.getElementById("cardAffinity").innerText = "Affinity : " + card.affinity
            document.getElementById("cardHp").innerText = "HP : " + card.hp
            document.getElementById("cardEnergy").innerText = "Energy : " + card.energy
            document.getElementById("cardAttack").innerText = "Attack : " + card.attack
            document.getElementById("cardDefence").innerText = "Defence : " + card.defence
            
            if(document.getElementById("priceSell"))
            {
                document.getElementById("modalAction").setAttribute("onclick" ,"sell(" + card.id+")") 

            }
            else
            {
                document.getElementById("modalAction").setAttribute("onclick", "buy("+ card.id+ ")")
            }
            document.getElementById("modalAction").innerText = action 
        
            
        }
    }
}

function buy(cardId)
{
    let sellCard;
    for( let card of dataCard)
    {
        if (card.id ==  cardId)
        {
            sellCard = card
            break
        }
    }

    fetch("http://localhost:3083/market/buyCard/"+ userId +"/"+ cardId , {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: sellCard
    })
    .then(response => response.json())
    .then((response) => {
        console.log(response)
        location.reload()
    })
}

function sell(cardId)
{
    let priceToSell = document.getElementById("priceSell").value;
    console.log("Vendre " + cardId + " au prix de " + priceToSell)

    fetch("http://localhost:3083/market/sellCard/" + cardId + "/" + userId + "?price=" + priceToSell, {
		method: 'PUT',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json',
	 	}
	})
    .then(reponse => reponse.json())
    .then((reponse) => {
        console.log(reponse)
        location.reload()
    })
}

// var myData =
// [
//         {
//             "id": 1,
//             "name": "Shifty",
//             "description": "Lifty et Shifty sont des frères jumeaux raton-laveurs kleptomanes. Pour ne pas les confondre, il faut savoir que Shifty est celui qui porte un chapeau, et Lifty, celui qui n'en porte pas !",
//             "imgUrl": "https://static.wikia.nocookie.net/happytreefriends/images/8/8f/Gallery_01_11.png/revision/latest?cb=20130113035357",
//             "family": "Gentil",
//             "affinity": "Terre",
//             "hp": 697,
//             "energy": 304,
//             "attack": 703,
//             "defence": 554,
//             "ownerId": 1,
//             "price": 984,
//             "onMarket": false
//         },
//         {
//             "id": 2,
//             "name": "Flippy",
//             "description": "Flippy est un l'un des personnages principaux de la série. Il est probablement le plus aimé du public, sa victoire au tournoi du meilleur personnage le prouvant. Il a sa propre série Ka-pow! Et est jouable dans le jeu vidéo False Alarm.",
//             "imgUrl": "https://static.wikia.nocookie.net/happytreefriends/images/9/9e/FlippyTraumatizedScreamHS33.png/revision/latest?cb=20190106223343",
//             "family": "Griffins",
//             "affinity": "Nuit",
//             "hp": 645,
//             "energy": 461,
//             "attack": 219,
//             "defence": 353,
//             "ownerId": 1,
//             "price": 679,
//             "onMarket": false
//         },
//         {
//             "id": 3,
//             "name": "Deadpool",
//             "description": "Deadpool est un mercenaire défiguré, doté d'une capacité surhumaine de guérison accélérée et capable de prouesses physiques. ",
//             "imgUrl": "https://www.actuabd.com/local/cache-vignettes/L330xH496/arton28724-0b370.jpg?1638532001",
//             "family": "Griffins",
//             "affinity": "Soleil",
//             "hp": 134,
//             "energy": 137,
//             "attack": 240,
//             "defence": 121,
//             "ownerId": 1,
//             "price": 543,
//             "onMarket": false
//         },
//         {
//             "id": 4,
//             "name": "Deadpool",
//             "description": "Deadpool est un mercenaire défiguré, doté d'une capacité surhumaine de guérison accélérée et capable de prouesses physiques. ",
//             "imgUrl": "https://www.actuabd.com/local/cache-vignettes/L330xH496/arton28724-0b370.jpg?1638532001",
//             "family": "Neutre",
//             "affinity": "Feu",
//             "hp": 509,
//             "energy": 162,
//             "attack": 911,
//             "defence": 102,
//             "ownerId": 1,
//             "price": 631,
//             "onMarket": false
//         },
//         {
//             "id": 5,
//             "name": "CroMarmot",
//             "description": "Cro-Marmot est une marmotte verte dans un grand cube de glace, il tient une batte en bois dans la main et une sorte de slip léopard sur lui. Ses cheveux cachent ses yeux.",
//             "imgUrl": "https://static.wikia.nocookie.net/happytreefriends/images/0/04/Cro-Marmot-NOICE.png/revision/latest?cb=20200524202259",
//             "family": "Simpson",
//             "affinity": "Nuit",
//             "hp": 198,
//             "energy": 660,
//             "attack": 285,
//             "defence": 874,
//             "ownerId": 1,
//             "price": 731,
//             "onMarket": false
//         }
//     ]
