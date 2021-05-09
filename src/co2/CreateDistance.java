package co2;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateDistance {

	public JSONObject payload = null;
	public String transort = "";

	public CreateDistance() {

	}

	public CreateDistance setPayload(JSONObject payload) {
		this.payload = payload;
		return this;
	}

	public CreateDistance transport(String transort) {
		this.transort = transort;
		return this;
	}

	public float getDistance() throws ClientProtocolException, IOException, ParseException, JSONException {

		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost("https://api.openrouteservice.org/v2/directions/driving-car/json");

		String token = "Bearer ".concat(System.getenv("ORS_TOKEN"));

		httpPost.addHeader("Authorization", token);
		httpPost.addHeader("Content-Type", "application/json");

		StringEntity entity = new StringEntity(payload.toString(), ContentType.APPLICATION_FORM_URLENCODED);
		httpPost.setEntity(entity);
		HttpResponse response = httpclient.execute(httpPost);

		float dist = 0;
		float result = 0;
		int responseCode = response.getStatusLine().getStatusCode();
		switch (responseCode) {
		case 200: {

			String stringResponse = EntityUtils.toString(response.getEntity());
			// System.out.println(stringResponse);
			JSONObject allJson = new JSONObject(stringResponse);
			// System.out.println(allJson);
			JSONArray routes = allJson.getJSONArray("routes");
			// System.out.println(routes);
			JSONObject summary = routes.getJSONObject(0);
			// System.out.println(summary);
			Object distance = summary.get("summary");
			// System.out.println(distance);
			JSONObject duration = new JSONObject(distance.toString());
			// System.out.println(duration.getString("distance"));
			dist = Float.parseFloat(duration.getString("distance"));

			TransportType transport = new TransportType();
			result = (transport.transportType(transort).getEmission() * dist) / 1000;
			System.out.println(String.format("Your trip caused: %.1fkg of CO2-equivalent", result));
			return result;
		}
		case 500: {
			System.out.println("Server problems");
			break;
		}
		case 403: {
			System.out.println("You have no authorization to access that resource");
			break;
		}

		}
		return result;
	}

}
