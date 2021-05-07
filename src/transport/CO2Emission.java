package transport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CO2Emission {

	private double x1;
	private double y1;
	private double x2;
	private double y2;

	private JSONObject payload;

	public JSONObject getPayload() {
		return payload;
	}

	public void setPayload(JSONObject payload) {
		this.payload = payload;
	}

	public CO2Emission() {

	}

	public CO2Emission coordinateCity_1(double x1, double y1) {

		this.x1 = x1;
		this.y1 = y1;
		return this;

	}

	public CO2Emission coordinateCity_2(double x2, double y2) {

		this.x2 = x2;
		this.y2 = y2;
		return this;

	}

	public void createPayload() throws JSONException {

		JSONObject result = new JSONObject();
		JSONArray locations = new JSONArray();
		result.put("locations", locations);

		double[] city1 = new double[2];
		city1[0] = x1;
		city1[1] = y1;

		double[] city2 = new double[2];
		city2[0] = x2;
		city2[1] = y2;

		JSONArray array1 = new JSONArray(city1);
		JSONArray array2 = new JSONArray(city2);

		locations.put(array1);
		locations.put(array2);

		// {"locations":[[9.70093,48.477473],[9.207916,49.153868]]});

		this.payload = result;
	}

}
