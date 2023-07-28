package kh.apiclient.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import kh.apiclient.service.ApiCachedClientService;

public class SunspotServiceImpl implements ApiCachedClientService {

	@Override
	public String retreive(String url) {
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder(
		       URI.create(url))
		   .header("accept", "text/plain")
		   .build();

		HttpResponse<String> response = null;
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String responseText = response.body();
		System.out.println(responseText);
		return responseText;
	}

	@Override
	public String parse(String response) {
		// TODO Auto-generated method stub
		return null;
	}

}
