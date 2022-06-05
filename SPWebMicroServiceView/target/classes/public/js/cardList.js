let cardList = [

    {
        family_name:"DC Comic",
        img_src:"http://www.superherobroadband.com/app/themes/superhero/assets/img/superhero.gif",
        name:"SUPERMAN",
        description: "The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El, moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass. Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of humanity through a 'Superman' identity.",
        hp: 500,
        energy:100,
        attack:50,
        defence: 50,
        price:200
    },
    {
        family_name:"DC Comic",
        img_src:"https://static.fnac-static.com/multimedia/Images/8F/8F/7D/66/6716815-1505-1540-1/tsp20171122191008/Lego-lgtob12b-lego-batman-movie-lampe-torche-batman.jpg",
        name:"BATMAN",
        description: "Bruce Wayne, alias Batman, est un héros de fiction appartenant à l'univers de DC Comics. Créé par le dessinateur Bob Kane et le scénariste Bill Finger, il apparaît pour la première fois dans le comic book Detective Comics no 27 (date de couverture : mai 1939 mais la date réelle de parution est le 30 mars 1939) sous le nom de The Bat-Man. Bien que ce soit le succès de Superman qui ait amené sa création, il se détache de ce modèle puisqu'il n'a aucun pouvoir surhumain. Batman n'est qu'un simple humain qui a décidé de lutter contre le crime après avoir vu ses parents se faire abattre par un voleur dans une ruelle de Gotham City, la ville où se déroulent la plupart de ses aventures. Malgré sa réputation de héros solitaire, il sait s'entourer d'alliés, comme Robin, son majordome Alfred Pennyworth ou encore le commissaire de police James Gordon. ",
        hp: 50,
        energy:80,
        attack:170,
        defence: 80,
        price:100
    },
    {
        family_name:"Marvel",
        img_src:"https://static.hitek.fr/img/actualite/2017/06/27/i_deadpool-2.jpg",
        name:"DEAD POOL",
        description: "Le convoi d'Ajax est attaqué par Deadpool. Il commence par massacrer les gardes à l'intérieur d'une voiture, avant de s'en prendre au reste du convoi. Après une longue escarmouche, où il est contraint de n'utiliser que les douze balles qu'il lui reste, Deadpool capture Ajax (dont le véritable nom est Francis, ce que Deadpool ne cesse de lui rappeler). Après l'intervention de Colossus et Negasonic venus empêcher Deadpool de causer plus de dégâts et le rallier à la cause des X-Men, Ajax parvient à s'échapper en retirant le sabre de son épaule. Il apprend par la même occasion la véritable identité de Deadpool : Wade Wilson.",
        hp: 999999,
        energy:100,
        attack:15,
        defence: 15,
        price:250
    },

    ];


function create_card_object(response, id){
    var card = new Object();
    card.family_src = "";
    card.family_name = response[id].family
    card.name = response[id].name;
    card.description = response[id].description;
    card.imgUrl = response[id].imgUrl; //"https://media.giphy.com/media/6nWT5GyxsmAoM/giphy.gif"
    card.hp = response[id].hp
    card.energy = response[id].energy
    card.attack = response[id].attack
    card.defence = response[id].defence

    // card.date = "12h";
    // card.comment = "0 comment";
    // card.like = "2 likes";
    // card.button = "Read";
    cardList.push(card);
    display(card);
}


let template = document.querySelector("#row");

for(const card of cardList){
    display(card);
}

function display(card){
    let clone = document.importNode(template.content, true);

    newContent= clone.firstElementChild.innerHTML
                .replace(/{{family_src}}/g, card.family_src)
                .replace(/{{family_name}}/g, card.family_name)
                .replace(/{{img_src}}/g, card.img_src)
                .replace(/{{name}}/g, card.name)
                .replace(/{{description}}/g, card.description)
                .replace(/{{hp}}/g, card.hp)
                .replace(/{{energy}}/g, card.energy)
                .replace(/{{attack}}/g, card.attack)
                .replace(/{{defence}}/g, card.defence)
                .replace(/{{price}}/g, card.price);
    clone.firstElementChild.innerHTML= newContent;
    clone.firstElementChild.addEventListener("click", () => update_card(card));

    let cardContainer= document.querySelector("#tableContent");
    cardContainer.appendChild(clone);
}

function update_card(card){
    console.log("updating card".concat(' ', card.name));
    
    let HP = document.querySelector("#HPId");
    HP.textContent = card.hp;
    let family_name= document.querySelector("#cardFamilyName");
    family_name.textContent = card.family_name;
    let energy = document.querySelector("#energyId");
    energy.textContent = card.energy;
    let name = document.querySelector("#cardName");
    name.textContent = card.name;
    let image = document.querySelector("#cardImgId");
    image.src = card.img_src;
    let description = document.querySelector("#cardDescriptionId");
    description.textContent = card.description;
    let attack = document.querySelector("#cardAttackId");
    attack.textContent = card.attack;
    let defence = document.querySelector("#cardDefenceId");
    defence.textContent = card.defence;
    let card_energy = document.querySelector("#cardEnergyId");
    card_energy.textContent = card.energy;
    let card_HP = document.querySelector("#cardHPId");
    card_HP.textContent = card.hp;
    let card_price = document.querySelector("#cardPriceId");
    card_price.textContent = card.price;

}

function generate(){

    const GET_URL="https://asi2-backend-market.herokuapp.com/cards"; 
    let context =   {
                        method: 'GET'
                    };
        
    fetch(GET_URL,context)
        .then(response => response.json())
            .then(response => callback(response))
            .catch(error => err_callback(error));
}

function callback(response){
    console.log(response[41]);
    console.log("ajout cartes serveur")
    for (const i in response){
        create_card_object(response, i);
    }

    console.log(cardList);
    

}

function err_callback(error){
    console.log(error);
}


generate();









