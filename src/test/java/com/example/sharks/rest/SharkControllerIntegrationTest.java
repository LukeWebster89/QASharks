package com.example.sharks.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.sharks.entity.Shark;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class SharkControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void testCreate() throws Exception{
		Shark testShark = new Shark("Spotted Wobbegong", "Shaggy", "Sea Floor");
		String testSharkAsJSON = this.mapper.writeValueAsString(testShark);
		RequestBuilder req = post("/shark/create").content(testSharkAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		Shark testSavedShark = new Shark(1, "Spotted Wobbegong", "Shaggy", "Sea Floor");
		String testSavedSharkAsJSON = this.mapper.writeValueAsString(testSavedShark);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testSavedSharkAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}

}
