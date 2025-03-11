package com.integration.film_service.services;
import com.integration.film_service.model.Characters;
import com.integration.film_service.model.Film;
import com.integration.film_service.model.FilmResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {
    private final String FILM_JSON_URL = "https://swapi.dev/api/films"; // Replace with actual URL

    public List<Film> fetchFilms() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Film>> response = restTemplate.exchange(
                "https://swapi.dev/api/films",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Film>>() {}
        );
        System.out.println();
        return response.getBody();
//        return Arrays.asList(films);
    }
    public Film fetchFilmById(String id) {
        String url = FILM_JSON_URL + "/" + id; // Construct URL dynamically
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("url : " + url);
        // Fetch the response and assume it might be wrapped in an object
        ResponseEntity<Film> response = restTemplate.exchange(url, HttpMethod.GET, null,Film.class);
        System.out.println("response " + response.getBody());
        if (response != null) {
            // Fetch film names
            List<String> charNames = response.getBody().getCharacters().stream()
                    .map(this::fetchCharacterName)
                    .collect(Collectors.toList());
            response.getBody().setCharacters(charNames);
        }
//        return response.getBody().getFilm(); // Adjust this based on the actual JSON structure
        return response.getBody();
    }

    private String fetchCharacterName(String filmUrl) {
        RestTemplate restTemplate = new RestTemplate();
        Characters chars = restTemplate.getForObject(filmUrl, Characters.class);
        return (chars != null) ? chars.getName() : "Unknown Characters";
    }
    }
