/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package kh.apiclient;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ApiCachedClient implements RequestHandler<Map<String,String>, String>{

	private static String rawResponse = null;
	private static String response = null;
	
	@Override
	public String handleRequest(Map<String, String> input, Context context) {
		LambdaLogger logger = context.getLogger();
		String apiUrl = System.getenv("API_URL");
		logger.log("ApiCachedClient invoked, API_URL: " + apiUrl);
		
		if(response == null) {
			//retrieve and parse the response
			//TODO
		}
		
		
		return response;
	}

}