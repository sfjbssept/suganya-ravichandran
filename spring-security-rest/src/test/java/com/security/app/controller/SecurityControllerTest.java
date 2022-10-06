package com.security.app.controller;

import static org.assertj.core.api.Assertions.catchException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import spring.security.controller.SecurityController;
import spring.security.entities.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest({SecurityController.class})
@ActiveProfiles(value = "true")
public class SecurityControllerTest {

	@Autowired
	private MockMvc mock;
	
	@Value("${employee.get.url}")
	String getUrl;
	
	@Value("${employee.post.url}")
	String postUrl;
	
	@Value("${employee.put.url}")
	String putUrl;
	
	@Value("${employee.delete.url}")
	String deleteUrl;
	
	@Value("${user.user1.username}")
	String username1;
	
	@Value("${user.user1.password}")
	String password1;
	
	@Value("${admin.user1.username}")
	String admin_name1;
	
	@Value("${admin.user1.password}")
	String admin_password1;
	
	@Test
	public void testEmployeeGet() throws Exception{
		ResultActions responseEntity = processApiRequest(getUrl, HttpMethod.GET, null, null, username1, password1);
		responseEntity.andExpect(status().isOk());
		String result= responseEntity.andReturn().getResponse().getContentAsString();
		assertEquals("get employee", result);
	}
	@Test
	public void testEmployeePost() throws Exception{
		Employee employee = createEmployee("test","dev");
		ResultActions responseEntity= processApiRequest(postUrl,HttpMethod.POST,null,employee, admin_name1, admin_password1);
		responseEntity.andExpect(status().isOk());
		ObjectMapper mapper = new ObjectMapper();
		Employee result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
				new TypeReference<Employee>() {
			
		});
		assertEquals("test", result.getName());
		assertEquals("dev", result.getRole());
	}
	
	private Employee createEmployee(String string,String string2) {
		return null;
	}
	
	private ResultActions processApiRequest(String api,HttpMethod http,String name,Employee employee,
			String username,String password) {
		
		ResultActions response=null;
		String secret= "Basic" + Base64Utils.encodeToString((username+ ":"+password).getBytes());
		try {
			switch(http) {
			case GET:
				//response=mock.perform(get(api).header(HttpHeaders.AUTHORIZATION,secret));
				response=mock.perform(get(api).with(user(username).password(password).roles("USER")));
				break;
				
			}
		}catch(Exception e) {
				e.printStackTrace();
				fail();
			}
			return response;
			
		}
	
}
