package main;

import java.io.IOException;

import org.apache.http.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import co2.CityGeoCode;
import co2.CreatePaylaod;
import co2.Distance;

public class Co2Emission_Main {

	public static void main(String[] args) throws IOException, ParseException, JSONException {

		CityGeoCode citycode1 = new CityGeoCode();
		CityGeoCode citycode2 = new CityGeoCode();

		citycode1.city("Berlin").getLongLatitude();
		citycode2.city("Hamburg").getLongLatitude();

		CreatePaylaod co2em = new CreatePaylaod();
		JSONObject payload = co2em.coordinateCity_1(citycode1.getLatitude(), citycode1.getLongitude()) //
				.coordinateCity_2(citycode2.getLatitude(), citycode2.getLongitude())//
				.buildPayload();

		Distance calculateDistance = new Distance();
		calculateDistance.setPayload(payload).transport("bus").getDistance();


	}
}
