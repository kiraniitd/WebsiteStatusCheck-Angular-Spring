package com.sunlife.status;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebsiteStatusCheckApplication.class)
@WebAppConfiguration
public class WebsiteStatusCheckApplicationTest 
{
	 @Autowired
	 private WebApplicationContext webApplicationContext;
	 private MockMvc mockMvc;
	 
	 protected void setUp() {
		 mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }

	 @Test
	 public void getGoogleStatus() throws Exception {
	    String uri = "https://www.google.com";
	    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
	       .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	    
	    int status = mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	 }
}
