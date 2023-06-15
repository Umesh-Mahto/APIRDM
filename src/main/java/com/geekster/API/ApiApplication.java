package com.geekster.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) throws IOException, InterruptedException{
		SpringApplication.run(ApiApplication.class, args);

		String url = "https://api.chucknorris.io/jokes/random";

		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		HttpClient httpClient = HttpClient.newBuilder().build();
		HttpResponse httpResponse = httpClient.send(request,HttpResponse.BodyHandlers.ofString());

		System.out.println(httpResponse.statusCode());
		System.out.println(httpResponse.body());
	}

}