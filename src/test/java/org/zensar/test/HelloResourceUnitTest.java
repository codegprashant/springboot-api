package org.zensar.test;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.zensar.main.ApplicationMain;


public class HelloResourceUnitTest extends  BaseTestClass{

    String hi_endpoint_url = "/hi";
    String hello_endpoint_url = "/hello?name=World";

    @Value(value = "${host.name}")
    String hostName;

    @Test
    public void testControllerEndpoint_hi() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get(hi_endpoint_url).content(MediaType.APPLICATION_JSON_VALUE)).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testControllerEndpoint_hello() throws Exception {

        String expectedJsonResponse = "{\"message\":\"Hello, World! I am "+hostName+"\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.get(hello_endpoint_url)
                .content(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_VALUE), MockMvcResultMatchers.content().json(expectedJsonResponse))
                ;

    }


}
