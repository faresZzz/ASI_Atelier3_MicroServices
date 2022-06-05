
var dataCard;
var action;
$("document").ready(function() {

    action = localStorage.getItem("action")
    if (action == "buy")
    {
        dataCard = getCard("http://localhost:3083/market/buy") 
        $("#tableBuy").bootstrapTable({
            data : dataCard
        })
        $("#sell").hide()
        $("#action").append("BUY")
        
        
    }
    if (action == "sell")
    {
        dataCard = getCard("http://localhost:3083/market/sell" + localStorage.getItem("userId"))
        $("#tableSell").bootstrapTable({
            data : dataCard
        })
        $("#buy").hide()
        $("#action").append("SELL")
        $("#modalFooter").append('<input type="number" name="price" id="priceSell">')

    }
})

function getCard(url)
{
    
    $.ajax({
        url:url,
        cache:false,
        type:'GET',
        crossDomain: true,
        success: function( data ) {
           return data["listCard"]
        }
    });

}
function actionFormatter(value, row){
    //  preview facture
    return `<button  id = ${row.id}  type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" onclick = "cardInfo(${row.id})">$</button>`;
}


function cardInfo(cardId)
{
    for( card in dataCard)
    {
        if (card.id ==  cardId)
        {
            document.getElementById("cardName").innerText = card.name
            document.getElementById("cardPrice").innerText = card.price
            document.getElementById("cardImage").setAttribute("src", card.imgUrl) 
            document.getElementById("cardFamily").innerText = card.family
            document.getElementById("cardDescription").innerText = card.description
            document.getElementById("cardAffinity").innerText = card.affinity
            document.getElementById("cardHp").innerText = card.hp
            document.getElementById("cardEnergy").innerText = card.energy
            document.getElementById("cardAttack").innerText = card.attack
            document.getElementById("cardDefence").innerText = card.defence
            
            if(document.getElementById("priceSell"))
            {
                document.getElementById("modalAction").setAttribute("onclick" ,"sell(" + card.id + ","+ document.getElementById("priceSell") +")") 

            }
            else
            {
                document.getElementById("modalAction").setAttribute("onclick", "buy("+ card.id+"," +card.price+")")
            }
            document.getElementById("modalAction").innerText = action 
        
            
        }
    }
}

function buy(cardId, price)
{
    fetch("http://localhost:3083/buy/"+ cardId +"/"+ userId + "/?price=" +price, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json', 
            'Origin': 'Access-Control-Allow-Origin: *'

        },
        body: json_obj
}
     )
}
function sell(cardId, priceToSell)
{
    fetch
}

var myData =
[
        {
            "id": 1,
            "name": "Shifty",
            "description": "Lifty et Shifty sont des frères jumeaux raton-laveurs kleptomanes. Pour ne pas les confondre, il faut savoir que Shifty est celui qui porte un chapeau, et Lifty, celui qui n'en porte pas !",
            "imgUrl": "https://static.wikia.nocookie.net/happytreefriends/images/8/8f/Gallery_01_11.png/revision/latest?cb=20130113035357",
            "family": "Gentil",
            "affinity": "Terre",
            "hp": 697,
            "energy": 304,
            "attack": 703,
            "defence": 554,
            "ownerId": 1,
            "price": 984,
            "onMarket": false
        },
        {
            "id": 2,
            "name": "Flippy",
            "description": "Flippy est un l'un des personnages principaux de la série. Il est probablement le plus aimé du public, sa victoire au tournoi du meilleur personnage le prouvant. Il a sa propre série Ka-pow! Et est jouable dans le jeu vidéo False Alarm.",
            "imgUrl": "https://static.wikia.nocookie.net/happytreefriends/images/9/9e/FlippyTraumatizedScreamHS33.png/revision/latest?cb=20190106223343",
            "family": "Griffins",
            "affinity": "Nuit",
            "hp": 645,
            "energy": 461,
            "attack": 219,
            "defence": 353,
            "ownerId": 1,
            "price": 679,
            "onMarket": false
        },
        {
            "id": 3,
            "name": "Deadpool",
            "description": "Deadpool est un mercenaire défiguré, doté d'une capacité surhumaine de guérison accélérée et capable de prouesses physiques. ",
            "imgUrl": "https://www.actuabd.com/local/cache-vignettes/L330xH496/arton28724-0b370.jpg?1638532001",
            "family": "Griffins",
            "affinity": "Soleil",
            "hp": 134,
            "energy": 137,
            "attack": 240,
            "defence": 121,
            "ownerId": 1,
            "price": 543,
            "onMarket": false
        },
        {
            "id": 4,
            "name": "Deadpool",
            "description": "Deadpool est un mercenaire défiguré, doté d'une capacité surhumaine de guérison accélérée et capable de prouesses physiques. ",
            "imgUrl": "https://www.actuabd.com/local/cache-vignettes/L330xH496/arton28724-0b370.jpg?1638532001",
            "family": "Neutre",
            "affinity": "Feu",
            "hp": 509,
            "energy": 162,
            "attack": 911,
            "defence": 102,
            "ownerId": 1,
            "price": 631,
            "onMarket": false
        },
        {
            "id": 5,
            "name": "CroMarmot",
            "description": "Cro-Marmot est une marmotte verte dans un grand cube de glace, il tient une batte en bois dans la main et une sorte de slip léopard sur lui. Ses cheveux cachent ses yeux.",
            "imgUrl": "https://static.wikia.nocookie.net/happytreefriends/images/0/04/Cro-Marmot-NOICE.png/revision/latest?cb=20200524202259",
            "family": "Simpson",
            "affinity": "Nuit",
            "hp": 198,
            "energy": 660,
            "attack": 285,
            "defence": 874,
            "ownerId": 1,
            "price": 731,
            "onMarket": false
        }
    ]
