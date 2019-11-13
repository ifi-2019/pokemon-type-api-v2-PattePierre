package com.ifi.tp.pokemon_type_api.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;

public class PokemonTypeRepositoryImplTest {

    private PokemonTypeRepositoryImpl repository = new PokemonTypeRepositoryImpl();

    @Test
    public void findPokemonTypeById_with25_shouldReturnPikachu(){
        PokemonType pikachu = repository.findPokemonTypeById(25);
        assertNotNull(pikachu);
        assertEquals("pikachu", pikachu.getName());
        assertEquals(25, pikachu.getId());
    }

    @Test
    public void findPokemonTypeById_with145_shouldReturnZapdos(){
    	PokemonType zapdos = repository.findPokemonTypeById(145);
        assertNotNull(zapdos);
        assertEquals("zapdos", zapdos.getName());
        assertEquals(145, zapdos.getId());
    }

    @Test
    public void findPokemonTypeByName_withEevee_shouldReturnEevee(){
    	PokemonType eevee = repository.findPokemonTypeByName("eevee");
        assertNotNull(eevee);
        assertEquals("eevee", eevee.getName());
        assertEquals(133, eevee.getId());
    }

    @Test
    public void findPokemonTypeByName_withMewTwo_shouldReturnMewTwo(){
    	PokemonType mewtwo = repository.findPokemonTypeByName("mewtwo");
        assertNotNull(mewtwo);
        assertEquals("mewtwo", mewtwo.getName());
        assertEquals(150, mewtwo.getId());
    }

    @Test
    public void findAllPokemonType_shouldReturn151Pokemons(){
    	List<PokemonType> pokemons = repository.findAllPokemonType();
        assertNotNull(pokemons);
        assertEquals(151, pokemons.size());
    }
    
    @Test
    public void applicationContext_shouldLoadPokemonRepository(){
        
    	ApplicationContext context = new AnnotationConfigApplicationContext("com.ifi.tp.pokemon_type_api.repository");
        Object repoByName = context.getBean("pokemonTypeRepositoryImpl"); 
        Object repoByClass = context.getBean(PokemonTypeRepository.class); 

        assertEquals(repoByName, repoByClass);
        assertNotNull(repoByName);
        assertNotNull(repoByClass);
    }

}