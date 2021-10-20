package org.zensar.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.zensar")
public class ApplicationMain {


    public static void main(String... s){

        SpringApplication.run(ApplicationMain.class,s);

    }


}
