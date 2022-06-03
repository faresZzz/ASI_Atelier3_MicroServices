# Atelier 3 Asi 
## Projet Creation d'un site de jeu de cartes SpringBoot
## Membres de l'équipe 1 :
ZAGOUANE Fares <br>
CHOURAQUI Maxime<br>
CLEMENT Charles<br>
LUPPI Daniel<br>




## Port d'ecoute de nos micros services

- card : 3080
- user : 3081
- authentification : 3082
- transaction : 3083
- room : 3084
- nginx : 8080

Tous nos services sont accessibles en localhost : 127.0.0.1


# Liste des routes par micro service

## Micro service Auth
- Route de base : /

|   Methode     |       URI         |     Body          |   Valeur de retour    |
| :-----------: |   :-----------:   |   :-----------:   |   :-----------:       |
|   GET         |       /           |    " "            |   String              |
|   GET         |       /login      |    UserDto        |   int                 |
|   POST        |       /singIn     |    UserDto        |   int                 |



## Micro service Card

- Route de base: /card

|   Methode     |       URI         |     Body          |   Valeur de retour    |
| :-----------: |   :-----------:   |   :-----------:   |   :-----------:       |
|   POST        |       /createCard           |    CardDto            |   CardDto              |
|   GET         |       /cards      |    None        |   ListCardDtoWrapper                 |
|   GET         |       /getCard/{cardId}     |    None        |   CardDto                 |
|   GET         |        /getCardByOwner/{ownerId}     |    None        |   ListCardDtoWrapper |
|   PUT         |       /update/{cardId}     |    CardDto        |   bool |
|   GET         |       /randcard/{numberOfCard}     |    None        |   ListCardDtoWrapper |
|   GET         |       /onMarket    |    None        |   ListCardDtoWrapper |


## Micro service User

- Route de base: /user

|   Methode     |       URI         |     Body          |   Valeur de retour    |
| :-----------: |   :-----------:   |   :-----------:   |   :-----------:       |
|   POST        |       /createUser           |    UserDto            |   UserDto              |
|   GET         |       /users      |    None        |   ListUserDtoWrapper                 |
|   GET         |       /getUserById/{id}     |    None        |   UserDto                 |
|   GET         |       /getUserBySurname/{surname}     |    None        |   UserDto |
|   PUT         |       /update/{userId}     |    UserDto        |   bool |



## Micro service Transaction

- Route de base: /market

|   Methode     |       URI         |     Body          |   Valeur de retour    |
| :-----------: |   :-----------:   |   :-----------:   |   :-----------:       |
|   PUT         |       /sellCard/{cardId}/{userid}?price={price}           |    None            |   bool              |
|   PUT         |       /buyCard/{buyerId}/{cardId}      |    None        |   bool                 |
|   GET         |       /sell/{userId}     |    None        |   ListCardDtoWrapper                 |
|   GET         |       /buy     |    None        |   ListCardDtoWrapper |


## Micro service Room

- Route de base: /room

|   Methode     |       URI         |     Body          |   Valeur de retour    |
| :-----------: |   :-----------:   |   :-----------:   |   :-----------:       |
|   GET         |       /           |    None            |   List<Room>              |
|   GET         |       /{id}      |    None        |   Room                 |
|   POST        |       /newRoom/{player1Id}     |    Room        |   Room                 |
|   PUT         |       /join/{idRoom}?idPlayer={idPlayer}     |    None        |   Room |
|   PUT         |       /start/{idRoom}     |    ListCardDtoWrapper        |   Room |
|   PUT         |        /endOfGame/{idRoom}?winner={winnerId}     |    None        |   bool |
  
  
# Elements réalisés du cahier des charges
  # ZAGOUANE Fares
  La gestion des utilisateurs a été réalisée. Nous avons une interface de sign-in ou sign-up permetttant la création ainsi que le sockage d'utilisateurs. Ceux-ci ont quatre paramètres à savoir : un id, un nom, un pseudo ainsi qu'un mot de passe. On stock ces informations dans une base de donnée qui sera consulté lors d'une tentative d'identification. De plus, il est impossible pour deux utilisatuers d'avoir le même pseudo. A la création d'un utilisateur, nous lui attribuons aléatoirement cinq cartes.<br>
  # CLEMENT Charles
  La création de carte a été réalisée. Chaque carte est caractérisée par de nombreux paramètres à savoir : un nom, une description, une image, une famille, une affinité, un nombre de point de vie, un nombre de point d'energy, un nombre de pont d'attaque, un nombre depoint de défense ainsi qu'un prix. De plus nous avons créé un boolean pour savoir si cette carte est ou non disponible sur le marché.
  #CHOURAQUI Maxime
  L'achat et vente de carte a été réalisée. Nou savons mis en place un 'Market' permettant à un utilisateur de pouvoir mettre à jour sa collection de carte. Chaque utilisateur possede un nombre d'argent lui permettant l'ajout de carte à sa collection. Celui- ci peut aussi décider de vendre et ainsi récupérer de l'arget sur son compte.
  #LUPPI Daniel
  Nous avons mis en place des 'rooms' afin d'héberger les compétitions de cartes.
  
 
