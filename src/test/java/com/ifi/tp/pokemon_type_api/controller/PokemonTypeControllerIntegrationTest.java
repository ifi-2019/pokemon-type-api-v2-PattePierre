package com.ifi.tp.pokemon_type_api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;

@RunWith(SpringRunner.class) 
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 
public class PokemonTypeControllerIntegrationTest {

    @LocalServerPort 
    private String port;

    @Autowired
    private TestRestTemplate restTemplate; 

    @Autowired
    private PokemonTypeController controller; 

    @Test
    public void pokemonTypeController_shouldBeInstanciated(){ 
        assertNotNull(controller);
    }

    @Test
    public void getPokemon_withId25_ShouldReturnPikachu() throws Exception {
        String url = "http://localhost:" + port + "/pokemon-types/25"; 

        PokemonType pikachu = this.restTemplate.getForObject(url, PokemonType.class); 

        assertNotNull(pikachu); 
        assertEquals(25, pikachu.getId());
        assertEquals("pikachu", pikachu.getName());
        assertEquals(4, pikachu.getHeight());
    }
}