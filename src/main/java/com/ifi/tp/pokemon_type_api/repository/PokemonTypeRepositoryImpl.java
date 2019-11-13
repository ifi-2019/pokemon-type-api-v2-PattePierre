package com.ifi.tp.pokemon_type_api.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.pokemon_type_api.bo.PokemonType;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            InputStream pokemonsStream = this.getClass().getResourceAsStream("/pokemons.json"); 

            ObjectMapper objectMapper = new ObjectMapper(); 
            PokemonType[] pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);

        for (PokemonType poke : this.pokemons) {
        	if (poke.getId() == id) return poke;
        }
        return null;
    }

    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);

        for (PokemonType poke : this.pokemons) {
        	if (poke.getName().equals(name)) return poke;
        }
        return null;
    }

    public List<PokemonType> findAllPokemonType() {
        return this.pokemons;
    }
}