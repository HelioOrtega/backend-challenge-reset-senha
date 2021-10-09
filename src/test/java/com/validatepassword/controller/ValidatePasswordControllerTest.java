package com.validatepassword.controller;

import com.validatepassword.Application;
import com.validatepassword.model.ValidatePasswordRequestModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.validatepassword.TestHelper.asJsonString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author helio.ortega
 * @since 10/2021
 */
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ValidatePasswordControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testShouldReturnOkWhenPasswordIsNotNullOnValidate() throws Exception {
		this.mockMvc
				.perform(post("/v1/password/validate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(new ValidatePasswordRequestModel("test-password")))
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void testShouldReturnBadRequestWhenPasswordIsNullOnValidate() throws Exception {
		this.mockMvc
				.perform(post("/v1/password/validate")
						.content(asJsonString(new ValidatePasswordRequestModel(null)))
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().is4xxClientError());
	}

	@Test
	public void testShouldReturnOkWhenPasswordIsNotNullOnValidateOnly() throws Exception {
		this.mockMvc
				.perform(post("/v1/password/validate-only")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(new ValidatePasswordRequestModel("test-password")))
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void testShouldReturnBadRequestWhenPasswordIsNullOnValidateOnly() throws Exception {
		this.mockMvc
				.perform(post("/v1/password/validate-only")
						.content(asJsonString(new ValidatePasswordRequestModel(null)))
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().is4xxClientError());
	}
}