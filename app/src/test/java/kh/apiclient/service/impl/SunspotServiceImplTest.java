package kh.apiclient.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class SunspotServiceImplTest {

	@Test
	public void testRetreve1() {
		SunspotServiceImpl impl = new SunspotServiceImpl();
		String result = impl.retreive("https://services.swpc.noaa.gov/text/sgas.txt");
		
		System.out.println("test result: " + result);
		assertTrue(result.startsWith(":Product: Solar and Geophysical Activity Summary"));
	}

}
