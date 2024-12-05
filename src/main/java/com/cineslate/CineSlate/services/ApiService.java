package com.cineslate.CineSlate.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cineslate.CineSlate.apiThings.ApiRequest;
import com.cineslate.CineSlate.apiThings.ApiResponse;
import com.cineslate.CineSlate.apiThings.homemovies.Datum;
import com.cineslate.CineSlate.apiThings.homemovies.HomeMovieResponse;
import com.cineslate.CineSlate.apiThings.homemovies.Top7;
import com.cineslate.CineSlate.apiThings.movie.MovieResponse;
import com.cineslate.CineSlate.apiThings.search.searchResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ApiService {
	private static final String API="http://api4.thetvdb.com/v4";
	RestTemplate restTemplate= new RestTemplate();

	public searchResponse search(String name) throws JsonProcessingException{
		return getSearch(name);
    }

	public MovieResponse movieDetails(Long id) throws JsonProcessingException{
		return getMovie(id);
	}
	
	public String getToken() throws JsonProcessingException{
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper objectMapper = new ObjectMapper();
		ApiRequest req= new ApiRequest();
        String json = objectMapper.writeValueAsString(req);
		HttpEntity<String> entity=new HttpEntity<>(json,headers);
		ApiResponse res=restTemplate.postForObject(API+"/login", entity, ApiResponse.class, headers);
		return res.getData().getToken();
	}
	public searchResponse getSearch(String name) throws JsonProcessingException{
		HttpHeaders headers2= new HttpHeaders();
		headers2.setContentType(MediaType.APPLICATION_JSON);
		headers2.set("Authorization","Bearer "+getToken());
		HttpEntity<String> entity2= new HttpEntity<>(headers2);
		ResponseEntity<searchResponse> resp= restTemplate.exchange(API+"/search?query="+name, HttpMethod.GET,entity2,searchResponse.class);
        return resp.getBody();
	}
	public MovieResponse getMovie(Long id) throws JsonProcessingException{
		HttpHeaders headers2= new HttpHeaders();
		headers2.setContentType(MediaType.APPLICATION_JSON);
		headers2.set("Authorization","Bearer "+getToken());
		HttpEntity<String> entity2= new HttpEntity<>(headers2);
		ResponseEntity<MovieResponse> resp= restTemplate.exchange(API+"/movies/"+id, HttpMethod.GET,entity2,MovieResponse.class);
        return resp.getBody();
	}

    public String homeMovieDetails() throws JsonProcessingException {
        return getHomeMovies();
			}
		
			private String getHomeMovies() throws JsonProcessingException {
				HttpHeaders headers2= new HttpHeaders();
				headers2.setContentType(MediaType.APPLICATION_JSON);
				headers2.set("Authorization","Bearer "+getToken());
				HttpEntity<String> entity2= new HttpEntity<>(headers2);
				ResponseEntity<HomeMovieResponse> resp= restTemplate.exchange(API+"/movies/filter?country=ind&lang=eng&sort=firstAired&year=2024", HttpMethod.GET,entity2,HomeMovieResponse.class);
				HomeMovieResponse found= resp.getBody();
				List<Top7> send= new ArrayList<>();
				for(int i=0;i<7&&i<found.getData().length;i++){
					Datum curr=found.getData()[i];
					send.add(new Top7(curr.getID(),"https://artworks.thetvdb.com"+curr.getImage(), curr.getName()));
				}
				ObjectMapper obj= new ObjectMapper();
				String json=obj.writeValueAsString(send);
				return json;
			}
}
