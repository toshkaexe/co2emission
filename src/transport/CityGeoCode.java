package transport;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class CityGeoCode {

	public String city;
	public float longitude;
	public float latitude;

	public CityGeoCode() {

	}

	public CityGeoCode city(String city) {

		this.city = city;
		return this;

	}

	public float getLongitude() {
		return longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void getLongLatitude() throws IOException, ClientProtocolException {
		String coutry = "";

		String url = "https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf6248143a51d3f31b4614a0d01d3aa4ed4b98&text="
				+ //
				coutry + //
				"%20" + //
				city + //
				"&layers=locality";

		CloseableHttpClient httpClient = HttpClients.createDefault();

		try {

			HttpGet request = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(request);
			JSONArray lat;
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					JSONObject result1 = new JSONObject(EntityUtils.toString(entity));
					JSONArray featuresList = result1.getJSONArray("features");
					JSONObject geometry = featuresList.getJSONObject(0);
					JSONObject coordinates = (JSONObject) geometry.get("geometry");

					lat = (JSONArray) coordinates.get("coordinates");

					this.longitude = Float.parseFloat(lat.get(0).toString());
					this.latitude = Float.parseFloat(lat.get(1).toString());

				}

			} finally {
				response.close();
			}
		} finally {
			httpClient.close();

		}

	}

}
