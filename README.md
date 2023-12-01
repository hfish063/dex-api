# [DISCLAIMER]
This project is intended for **educational** and demo purposes, in order to showcase my skillset.  It violates the **TOS** of pokemondb.net, and is not being used outside of the aforementioned areas.

## 🚩 Table of Contents
- [About](#---about-the-project)
- [Examples](#---example-api-calls)
- [More](#---additional-info)

# dex-api
## 🔧 About the Project
- Jsoup webscraper wrapped in a REST Api
- Directly parses html data to generate Json responses
- Find information on various Pokemon, and items from the video game series
    - `Pokemon`
    - `Stats`
    - `Moves`
    - `Abilities`
    - `Items`
    - `Sprites`
- Lightweight respone format, extremely easy to use and read
- Underlying webscraping functionality is abstracted to allow for easy implementation of new features, and reusability.


**Not** intended for public or distributed use

## 🎨 Example Api Calls
### Find a Pokemon move:
Api call
```
/api/move/absord
```

Json response
```json
{
    "generation": 1,
    "name": "Absorb",
    "type": "GRASS",
    "effect": "User recovers half the HP inflicted on opponent.",
    "resourceUrl": "https://pokemondb.net/move/all"
}
```

### Find Pokemon's stats:
Api call
```
/api/stats/rayquaza
```

Json response
```json
{
    "hp": 105,
    "attack": 150,
    "defense": 90,
    "spatk": 150,
    "spdef": 90,
    "speed": 95,
    "total": 680,
    "resourceUrl": "https://pokemondb.net/pokedex/all"
}
```

### Find an item:
Api call
```
/api/item/ultra ball
```

Json response
```json
{
    "name": "Ultra Ball",
    "category": "POKEBALLS",
    "effect": "Catches wild Pokémon with 2x the rate of a Poké Ball.",
    "resourceUrl": "https://pokemondb.net/item/all"
}
```

Api call for key items
```
/api/keyItem/bike
```

Json response
```json
{
    "name": "Bike",
    "effect": "A folding Bike that enables a rider to get around much faster than with Running Shoes.",
    "resourceUrl": "https://pokemondb.net/item/type/key"
}
```

### Find a sprite (by generation):
Api call
```
/api/sprite/giratina/5
```

Json response
```json
{
    "generation": 5,
    "pokemonName": "giratina",
    "shiny": false,
    "imgSrcUrl": "https://img.pokemondb.net/sprites/scarlet-violet/normal/1x/giratina-altered.png",
    "resourceUrl": "https://pokemondb.net/sprites/"
}
```

![Giratina sprite](https://img.pokemondb.net/sprites/scarlet-violet/normal/1x/giratina-altered.png)

Api call for shiny version
```
/api/sprite/shiny/giratina/5
```

Json response

## 📜 Additional Info
### Error handling:
Finding data relies on valid model names, and spelling e.g. if a user searches for Pokemon that does not exist, an exception is thrown

*NOTE: Capitalization does not matter in the above case*

Example of mispelled name
```json
{
    "message": "Could not locate stats for pokemon - pkachu",
    "httpStatus": "404 NOT_FOUND"
}
```

