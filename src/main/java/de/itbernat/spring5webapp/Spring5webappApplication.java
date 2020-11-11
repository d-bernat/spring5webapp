package de.itbernat.spring5webapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Spring5webappApplication {


	public static void main(String[] args)
	{
		log.info("IoC is about to start...");
		SpringApplication.run(Spring5webappApplication.class, args);
	}

}
