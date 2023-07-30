package kh.apiclient.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		//System.out.println(responseText);
		return responseText;
	}

	@Override
	public String parse(String response) {
		String ssnNumber = null;
		// split the response into lines then look for the one with ssn following the section header
		String[] resultLines = response.split("\\n");
		System.out.println("Split lines: " + resultLines.length);
		int sectionHeaderLine = 0;
		for(int lineNum = 0; lineNum < resultLines.length; lineNum++) {
			if(resultLines[lineNum].equals("E.  Daily Indices: (real-time preliminary/estimated values)")) {
				System.out.println("... section line at: " + lineNum);
				sectionHeaderLine = lineNum;
			}
		}
		if(sectionHeaderLine > 0) {
			String ssnLine = resultLines[sectionHeaderLine + 1];
			System.out.println("ssn line: " + ssnLine);
			Pattern p = Pattern.compile(".*SSN\\s([\\d]+)\\s.*", Pattern.MULTILINE);
			Matcher m = p.matcher(ssnLine);
			m.find();
			ssnNumber = m.group(1);
			System.out.println("Matched SSN: " + ssnNumber);
		}
		
		return ssnNumber;
	}

}
