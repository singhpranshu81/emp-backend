package com.mph.sprbootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class CommandLineRunnerDemoApplication {
	@Bean
public CommandLineRunner commandLineRunner() {
	return args->{
		System.out.println("Commande line runner....");
		for(String arg:args) {
			System.out.println("Arg: "+arg);
		}
		};
	

}
}
