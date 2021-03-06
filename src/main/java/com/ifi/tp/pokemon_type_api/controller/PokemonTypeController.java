package com.ifi.tp.pokemon_type_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ifi.tp.pokemon_type_api.service.PokemonTypeService;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {
	
	private PokemonTypeService service;

    public PokemonTypeController(PokemonTypeService service) { 
    	this.service = service;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable("id") int id){
        return this.service.getPokemonType(id);
    }
    
    @GetMapping(value="", params="name")
    PokemonType getPokemonTypeFromName(@RequestParam String name){
        return this.service.getPokemonType(name);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return this.service.getAllPokemonTypes();
    }
    
    
}
