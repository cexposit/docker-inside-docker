package com.kaizten.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.IOException;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class KaiztenTaskApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(KaiztenTaskApplication.class, args);
        String[] commandToExecute;
        //
        commandToExecute = new String[] { "docker", "-v" };
        KaiztenProcessBuilder.execute(commandToExecute);
        //
        commandToExecute = new String[] { 
                "docker", "run", 
                "hello-world" };
        KaiztenProcessBuilder.execute(commandToExecute);
        //
        commandToExecute = new String[] { 
                "docker", "run", 
                "-v", "/var/run/docker.sock:/var/run/docker.sock", 
                "-t", "hello-world" };
        KaiztenProcessBuilder.execute(commandToExecute);
        //
        commandToExecute = new String[] { "service", "docker", "status" };
        KaiztenProcessBuilder.execute(commandToExecute);
    }
}
