package main;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;

import transport.CO2Emission;
import transport.CityGeoCode;


public class EmissionMain {

	public JSONObject getPayloadMap() {
		JSONObject payload = new JSONObject();
		// payload.put("locations", locations);

		return payload;
	}

	public static void main(String[] args) throws IOException {

		CityGeoCode citycode1 = new CityGeoCode();
		CityGeoCode citycode2 = new CityGeoCode();
		try {
			citycode1.city("Kassel").getLongLatitude();
			System.out.println(String.format("Berlin: %f, %f ", citycode1.getLatitude(), citycode1.getLongitude()));

			citycode2.city("Hamburg").getLongLatitude();
			System.out.println(String.format("Hamburg: %f, %f ", citycode2.getLatitude(), citycode2.getLongitude()));

			CO2Emission co2em = new CO2Emission();
			co2em.coordinateCity_1(citycode1.getLatitude(), citycode1.getLongitude())
					.coordinateCity_2(citycode2.getLatitude(), citycode2.getLongitude()).createPayload();

			System.out.print(co2em.getPayload());

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

		String url = "https://api.openrouteservice.org/v2/matrix/cycling-road";
//
//		Client client = ClientBuilder.newClient();
//		Entity<String> payload = Entity.json({"locations":[[9.70093,48.477473],[9.207916,49.153868],[37.573242,55.801281],[115.663757,38.106467]]});
//		Response response = client.target("https://api.openrouteservice.org/v2/matrix/driving-hgv")
//		  .request()
//		  .header("Authorization", "5b3ce3597851110001cf6248143a51d3f31b4614a0d01d3aa4ed4b98")
//		  .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
//		  .header("Content-Type", "application/json; charset=utf-8")
//		  .post(payload);
//
//		System.out.println("status: " + response.getStatus());
//		System.out.println("headers: " + response.getHeaders());
		// System.out.println("body:" + response.readEntity(String.class));
		// Username
		// and
		// API-Key

	}

	// https://api.openrouteservice.org/v2/matrix/cycling-road
	// POSThttps://api.openrouteservice.org/v2/matrix/cycling-road

}
