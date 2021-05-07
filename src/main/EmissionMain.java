package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import transport.CityGeoCode;
import transport.Transport;

public class EmissionMain {

	public static void main(String[] args) throws IOException {

		CityGeoCode citycode = new CityGeoCode();

		try {
			citycode.city("Berlin").getLongLatitude();
			System.out.println(String.format("Berlin: %f, %f ", citycode.getLatitude(), citycode.getLongitude()));
			
			citycode.city("Hamburg").getLongLatitude();
			System.out.println(String.format("Hamburg: %f, %f ", citycode.getLatitude(), citycode.getLongitude()));

			citycode.city("Munich").getLongLatitude();
			System.out.println(String.format("Munich: %f, %f ", citycode.getLatitude(), citycode.getLongitude()));

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		
//		// Sending get request
//        URL url = new URL("http://example-url");
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//        conn.setRequestProperty("Authorization","Bearer "+" Actual bearer token issued by provider.");
//        //e.g. bearer token= eyJhbGciOiXXXzUxMiJ9.eyJzdWIiOiPyc2hhcm1hQHBsdW1zbGljZS5jb206OjE6OjkwIiwiZXhwIjoxNTM3MzQyNTIxLCJpYXQiOjE1MzY3Mzc3MjF9.O33zP2l_0eDNfcqSQz29jUGJC-_THYsXllrmkFnk85dNRbAw66dyEKBP5dVcFUuNTA8zhA83kk3Y41_qZYx43T
//
//        conn.setRequestProperty("Content-Type","application/json");
//        conn.setRequestMethod("GET");
//
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        String output;
//
//        StringBuffer response = new StringBuffer();
//        while ((output = in.readLine()) != null) {
//            response.append(output);
//        }
//
//        in.close();
//        // printing result from response
//        System.out.println("Response:-" + response.toString());
//		
		
		
		
		
		

	}

	// https://api.openrouteservice.org/v2/matrix/cycling-road
	// POSThttps://api.openrouteservice.org/v2/matrix/cycling-road

}
