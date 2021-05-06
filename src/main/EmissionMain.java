package main;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import transport.Transport;

public class EmissionMain {

	public static void main(String[] args) throws IOException {

		String url = "https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf6248143a51d3f31b4614a0d01d3aa4ed4b98&text=Namibian%20Brewery&layers=locality";

		CloseableHttpClient httpClient = HttpClients.createDefault();

		try {

			HttpGet request = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(request);

			try {

				// Get HttpResponse Status
				System.out.println(response.getProtocolVersion()); // HTTP/1.1
				System.out.println(response.getStatusLine().getStatusCode()); // 200
				System.out.println(response.getStatusLine().getReasonPhrase()); // OK
				System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

				HttpEntity entity = response.getEntity();
				if (entity != null) {
					// return it as a String
					String result = EntityUtils.toString(entity);
					System.out.println(result);
				}

			} finally {
				response.close();
			}
		} finally {
			httpClient.close();
		}

		Transport transport = new Transport();		
		System.out.println(transport.setTransport("bus7").getEmission());
		
	
	}
	
	//https://api.openrouteservice.org/v2/matrix/cycling-road
	//POSThttps://api.openrouteservice.org/v2/matrix/cycling-road
		

		
		

}
