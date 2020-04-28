package dev.mdrobot.booksapifeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BooksApiFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApiFeignClientApplication.class, args);
	}

}