package tn.iit.spring.tp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import tn.iit.spring.tp2.entites.Langue;

@SpringBootApplication
@Configuration
@EntityScan("tn.iit.spring.tp2.entites")
public class Tp2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp2Application.class, args);
		//System.out.println(new Langue().toString());
	}
}
