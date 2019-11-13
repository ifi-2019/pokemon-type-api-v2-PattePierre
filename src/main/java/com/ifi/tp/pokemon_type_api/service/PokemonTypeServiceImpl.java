package com.ifi.tp.pokemon_type_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ifi.tp.pokemon_type_api.repository.PokemonTypeRepository;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {
	private PokemonTypeRepository repository;

    public PokemonTypeServiceImpl(PokemonTypeRepository repo) {
    	this.repository = repo;
    }

    @Override
    public PokemonType getPokemonType(int id) {
        return this.repository.findPokemonTypeById(id);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        return this.repository.findAllPokemonType();
    }
}