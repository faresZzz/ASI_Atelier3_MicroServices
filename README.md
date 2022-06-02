# Atelier 3 Asi 
## Projet Creation d'un site de jeu de cartes SpringBoot




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
