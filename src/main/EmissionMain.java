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

//		JSONArray start = getCootdinatesLongLatitude("Berlin");
//		System.out.println(String.format("%s, %s", start.get(1), start.get(0)));
//
//		JSONArray finish = getCootdinatesLongLatitude("Hamburg");
//		System.out.println(String.format("%s, %s", finish.get(1), finish.get(0)));

		CityGeoCode citycode = new CityGeoCode();

		try {
			citycode.city("Berlin").getLongLatitude();

			System.out.println(String.format("Berlin: %f, %f ", 2* citycode.getLatitude(), citycode.getLongitude()));
			citycode.city("Hamburg").getLongLatitude();
			System.out.println(String.format("Hamburg: %f, %f ", citycode.getLatitude(), citycode.getLongitude()));

			citycode.city("Munich").getLongLatitude();
			System.out.println(String.format("Munich: %f, %f ", citycode.getLatitude(), citycode.getLongitude()));

			// Object lat = citycode.getLatitude();

			// float secOp = ((Float)lat).floatValue();

			// System.out.println(String.format("Berlin: %f",secOp));

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	public final static JSONArray getCootdinatesLongLatitude(String city) throws IOException, ClientProtocolException {
//		String coutry = "";
//
//		String url = "https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf6248143a51d3f31b4614a0d01d3aa4ed4b98&text="
//				+ //
//				coutry + //
//				"%20" + //
//				city + //
//				"&layers=locality";
//
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//
//		try {
//
//			HttpGet request = new HttpGet(url);
//			CloseableHttpResponse response = httpClient.execute(request);
//			JSONArray lat;
//			try {
//
////				// Get HttpResponse Status
////				System.out.println(response.getProtocolVersion()); // HTTP/1.1
////				System.out.println(response.getStatusLine().getStatusCode()); // 200
////				System.out.println(response.getStatusLine().getReasonPhrase()); // OK
////				System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK
//
//				HttpEntity entity = response.getEntity();
//				if (entity != null) {
//					JSONObject result1 = new JSONObject(EntityUtils.toString(entity));
//					JSONArray featuresList = result1.getJSONArray("features");
//					JSONObject geometry = featuresList.getJSONObject(0);
//					JSONObject coordinates = (JSONObject) geometry.get("geometry");
//
//					lat = (JSONArray) coordinates.get("coordinates");
//
//					return lat;
//
//				}
//
//			} finally {
//				response.close();
//			}
//		} finally {
//			httpClient.close();
//
//		}
//		return null;
//
//	}

	// https://api.openrouteservice.org/v2/matrix/cycling-road
	// POSThttps://api.openrouteservice.org/v2/matrix/cycling-road

}
