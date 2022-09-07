package com.capitole.co.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.capitole.co.PruebaCapitoleApplication.class)
@ActiveProfiles("test")

public class CapitoleApiTest {
	@Autowired
	protected WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void getCurrentPricebyParameters1_thenStatus200() throws Exception {

		mockMvc.perform(get("/capitole/getCurrentPricebyParameters/35455/1/2020-06-14T10:00:00+02:00/")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(content().json(
						"{\"brandId\":1,\"date\":\"2020-06-14T10:00:00+02:00\",\"price\":35.5,\"priceList\":1,\"productId\":35455}"));

	}

	@Test
	public void getCurrentPricebyParameters2_thenStatus200() throws Exception {

		mockMvc.perform(get("/capitole/getCurrentPricebyParameters/35455/1/2020-06-14T16:00:00+02:00/")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(content().json(
						" {\"brandId\":1,\"date\":\"2020-06-14T16:00:00+02:00\",\"price\":25.45,\"priceList\":2,\"productId\":35455}"));

	}

	@Test
	public void getCurrentPricebyParameters3_thenStatus200() throws Exception {

		mockMvc.perform(get("/capitole/getCurrentPricebyParameters/35455/1/2020-06-14T21:00:00+02:00/")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(content().json(
						"{\"brandId\":1,\"date\":\"2020-06-14T21:00:00+02:00\",\"price\":35.5,\"priceList\":1,\"productId\":35455}"));
	}

	@Test
	public void getCurrentPricebyParameters4_thenStatus200() throws Exception {

		mockMvc.perform(get("/capitole/getCurrentPricebyParameters/35455/1/2020-06-15T10:00:00+02:00/")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(content().json(
						"{\"brandId\":1,\"date\":\"2020-06-15T10:00:00+02:00\",\"price\":30.5,\"priceList\":3,\"productId\":35455}"));

	}

	@Test
	public void getCurrentPricebyParameters5_thenStatus200() throws Exception {

		mockMvc.perform(get("/capitole/getCurrentPricebyParameters/35455/1/2020-06-16T21:00:00+02:00/")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(content().json(
						"{\"brandId\":1,\"date\":\"2020-06-16T21:00:00+02:00\",\"price\":38.95,\"priceList\":4,\"productId\":35455}"));
	}

	@Test
	public void getCurrentPricebyParameters_thenStatus4XX() throws Exception {
		mockMvc.perform(get("/capitole/getCurrentPricebyParameters/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
	}

}