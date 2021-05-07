package main;

import java.io.IOException;
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

	}

	// https://api.openrouteservice.org/v2/matrix/cycling-road
	// POSThttps://api.openrouteservice.org/v2/matrix/cycling-road

}
