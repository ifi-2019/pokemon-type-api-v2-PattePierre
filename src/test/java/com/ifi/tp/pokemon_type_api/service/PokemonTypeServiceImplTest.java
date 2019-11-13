package com.ifi.tp.pokemon_type_api.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.ifi.tp.pokemon_type_api.repository.PokemonTypeRepository;

public class PokemonTypeServiceImplTest {

    @Test
    public void pokemonTypeRepository_shouldBeCalled_whenFindById(){
        PokemonTypeRepository pokemonTypeRepository = mock(PokemonTypeRepository.class); 
        PokemonTypeService pokemonTypeService = new PokemonTypeServiceImpl(pokemonTypeRepository); 

        pokemonTypeService.getPokemonType(25);

        verify(pokemonTypeRepository).findPokemonTypeById(25);
    }

    @Test
    public void pokemonTypeRepository_shouldBeCalled_whenFindAll(){
    	PokemonTypeRepository pokemonTypeRepository = mock(PokemonTypeRepository.class); 
    	PokemonTypeService pokemonTypeService = new PokemonTypeServiceImpl(pokemonTypeRepository); 

        pokemonTypeService.getAllPokemonTypes();

        verify(pokemonTypeRepository).findAllPokemonType();
    }

}
