package com.aluracursos.ScreenMatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner{

	public static void main(String[] args) {

		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo desde Spring!");
	}

	public String obtenerDatos(String url) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.build();
		HttpResponse<String> response = null;
		try {
			response = client
					.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		String json = response.body();
		return json;
	}

}
