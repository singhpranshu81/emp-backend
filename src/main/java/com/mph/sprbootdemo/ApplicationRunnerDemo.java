package com.mph.sprbootdemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationRunnerDemo {
      @Bean
	public ApplicationRunner applicationRunner() {
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
				System.out.println("ApplicationRunner running.....");
				System.out.println("Option name: "+ args.getOptionNames());
				if(args.containsOption("myOption")) {
					System.out.println("Option my Option value is: "+ args.getOptionValues("myOption"));
				}
				System.out.println("non-option arguments: "+args.getNonOptionArgs());
			}
		};
	}
}
