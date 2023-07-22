package kh.apiclient.service;

public interface ApiCachedClientService {

	/**
	 * Retrieves raw response from the source api url.
	 * 
	 * @param url
	 * @return
	 */
	public String retreive(String url);
	
	
	/**
	 * Parses the raw response to extract the specific response needed.
	 * 
	 * @param response
	 * @return
	 */
	public String parse(String response);
	
	
}
