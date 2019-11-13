package com.ifi.tp.pokemon_type_api.service;

import java.util.List;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;

public interface PokemonTypeService {
    PokemonType getPokemonType(int id);
    List<PokemonType> getAllPokemonTypes();
}

