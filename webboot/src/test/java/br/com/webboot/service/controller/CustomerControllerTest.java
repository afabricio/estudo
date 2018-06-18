package br.com.webboot.service.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.study.webboot.App;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class CustomerControllerTest {

	//@Autowired
	 //private MockMvc mockMvc;
	 
	 //@Autowired
	//    private WebApplicationContext webApplicationContext;
	
	@Before
    public void setup() throws Exception {
		
		System.out.println(1);
		// this.mockMvc = webAppContextSetup(webApplicationContext).build();

	}
	
	
	@Test
    public void userNotFound() throws Exception {
		
		
	}

}
