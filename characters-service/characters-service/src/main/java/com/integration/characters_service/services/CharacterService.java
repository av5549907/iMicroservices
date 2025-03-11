package com.integration.characters_service.services;

import com.integration.characters_service.dtos.Film;
import com.integration.characters_service.model.Characters;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    private final String CHARACTER_JSON_URL = "https://swapi.dev/api/people";

    public List<Character> fetchCharacters() {
        RestTemplate restTemplate = new RestTemplate();
        Character[] characters = restTemplate.getForObject(CHARACTER_JSON_URL, Character[].class);
        return Arrays.asList(characters);
    }
    public Characters fetchCharacterById(String id) {
        String url = CHARACTER_JSON_URL + "/" + id; // Construct URL dynamically
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(url, Character.class);
//
//        String url = FILM_JSON_URL + "/" + id; // Construct URL dynamically
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("url : " + url);
        // Fetch the response and assume it might be wrapped in an object
        ResponseEntity<Characters> response = restTemplate.exchange(url, HttpMethod.GET, null, Characters.class);
        System.out.println("response " + response.getBody());
        if (response != null) {
            // Fetch film names
            List<String> filmNames = response.getBody().getFilms().stream()
                    .map(this::fetchFilmTitle)
                    .collect(Collectors.toList());
            response.getBody().setFilms(filmNames);
        }
//        return response.getBody().getFilm(); // Adjust this based on the actual JSON structure
        return response.getBody();
    }
    private String fetchFilmTitle(String filmUrl) {
        RestTemplate restTemplate = new RestTemplate();
        Film film = restTemplate.getForObject(filmUrl, Film.class);
        return (film != null) ? film.getTitle() : "Unknown Film";
    }


}
