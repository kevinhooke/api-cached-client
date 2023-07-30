package kh.apiclient.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class SunspotServiceImplTest {

	//Useful use of Java 15 Text Block multi-line strings for test data
	private String exampleResponse1 = """
		:Product: Solar and Geophysical Activity Summary
		:Issued: 2023 Jul 23 0245 UTC
		# Prepared jointly by the U.S. Dept. of Commerce, NOAA,
		# Space Weather Prediction Center and the U.S. Air Force.
		#
		Joint USAF/NOAA Solar and Geophysical Activity Summary
		SGAS Number 204 Issued at 0245Z on 23 Jul 2023
		This report is compiled from data received at SWO on 22 Jul
		A.  Energetic Events
		Begin  Max  End  Rgn   Loc   Xray  Op 245MHz 10cm   Sweep
		 0035 0035 0035                       650                           
		 0048 0048 0048                       110                           
		 0218 0219 0219                       190                           
		 0312 0337 0355  3372 N21W55 M3.1  2n                               
		 0406 0406 0406                       100                           
		 0412 0416 0424  3373 N08W25 M1.0  1f                               
		 0713 0713 0714                       710                           
		 0727 0736 0743  3372 N25W48       Sf 130                           
		 0840 0840 0840                       170                           
		 1021 1022 1022                       120                           
		 1247 1247 1247                       100                           
		 1415 1415 1417                       150                           
		 1825 1825 1826                       230                           
		B.  Proton Events:  None.
		C.  Geomagnetic Activity Summary:  The geomagnetic field was quiet
		and active.
		D.  Stratwarm:  Not Available
		E.  Daily Indices: (real-time preliminary/estimated values)
		10 cm 174  SSN 103  Afr/Ap 009/008   X-ray Background C1.2
		Daily Proton Fluence (flux accumulation over 24 hrs)
		GT 1 MeV 8.7e+05   GT 10 MeV 2.6e+04 p/(cm2-ster-day)
		(GOES-16 satellite synchronous orbit W75 degrees)
		Daily Electron Fluence
		GT 2 MeV 2.60e+06 e/(cm2-ster-day)
		(GOES-16 satellite synchronous orbit W75 degrees)""";
	
	@Test
	public void testRetreve1() {
		SunspotServiceImpl impl = new SunspotServiceImpl();
		String result = impl.retreive("https://services.swpc.noaa.gov/text/sgas.txt");
		
		//System.out.println("test result: " + result);
		assertTrue(result.startsWith(":Product: Solar and Geophysical Activity Summary"));
	}

	@Test
	public void testParse1() {
		SunspotServiceImpl impl = new SunspotServiceImpl();
		String result = impl.parse(exampleResponse1);
		
		//expecting "103" from the SSN line: 10 cm 174  SSN 103  Afr/Ap 009/008   X-ray Background C1.2
		assertEquals("103", result);
	}
	
}
