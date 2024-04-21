package com.example.webpayintegration.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(WebPayOperationController.class)
class WebPayOperationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void createTransaction() throws Exception {
		// Arrange

		// Act
		mockMvc.perform(get("/create-transaction").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("", is("")));

		// Assert
	}

	@Test
	void confirmTransaction() throws Exception {
		// Arrange

		// Act
		mockMvc.perform(get("/create-transaction").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("", is("")));

		// Assert
	}

	@Test
	void getTransactionStatus() throws Exception {
		// Arrange

		// Act
		mockMvc.perform(get("/create-transaction").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("", is("")));

		// Assert
	}

	@Test
	void cancelTransaction() throws Exception {

		// Arrange

		// Act
		mockMvc.perform(get("/create-transaction").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("", is("")));

		// Assert
	}

	@Test
	void captureTransaction() throws Exception {

		// Arrange

		// Act
		mockMvc.perform(get("/create-transaction").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("", is("")));

		// Assert
	}
}