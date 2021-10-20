package org.zensar.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.zensar.main.ApplicationMain;

@ActiveProfiles("test")
@SpringBootTest(classes = ApplicationMain.class, properties = {"host.name=Zensar-machine"})

@AutoConfigureMockMvc
public abstract  class BaseTestClass {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testContextLoads(ApplicationContext applicationContext){
        Assertions.assertThat(applicationContext).isNotNull();
    }

}
