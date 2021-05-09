package co2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreatePaylaod {

	public double x1 = 0;
	public double y1 = 0;
	public double x2 = 0;
	public double y2 = 0;

	public CreatePaylaod() {

	}

	public CreatePaylaod coordinateCity_1(double x1, double y1) {

		this.x1 = x1;
		this.y1 = y1;
		return this;

	}

	public CreatePaylaod coordinateCity_2(double x2, double y2) {

		this.x2 = x2;
		this.y2 = y2;
		return this;

	}

	public JSONObject buildPayload() {

		JSONObject result = new JSONObject();
		JSONArray locations = new JSONArray();
		try {
			result.put("coordinates", locations);
		} catch (JSONException e) {

			e.printStackTrace();
		}

		double[] city1 = new double[2];
		city1[0] = y1;
		city1[1] = x1;

		double[] city2 = new double[2];
		city2[0] = y2;
		city2[1] = x2;

		try {
			JSONArray array1 = new JSONArray(city1);
			JSONArray array2 = new JSONArray(city2);

			locations.put(array1);
			locations.put(array2);

			// {"locations":[[9.70093,48.477473],[9.207916,49.153868]]});

			return result;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
