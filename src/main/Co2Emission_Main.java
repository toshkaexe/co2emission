package main;

import java.io.IOException;

import org.apache.http.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import co2.CityGeoCode;
import co2.CreateDistance;
import co2.PUTPayload;

public class Co2Emission_Main {

	public static void main(String[] args) throws Throwable {

		CityGeoCode citycode1 = new CityGeoCode();
		CityGeoCode citycode2 = new CityGeoCode();

		citycode1.city("New York").getLongLatitude();
		citycode2.city("Los Angeles").getLongLatitude();
		PUTPayload co2em = new PUTPayload();

		JSONObject payload = co2em.coordinateCity_1(citycode1.getLatitude(), citycode1.getLongitude()) //
				.coordinateCity_2(citycode2.getLatitude(), citycode2.getLongitude())//
				.buildPayload();

		CreateDistance calculateDistance = new CreateDistance();
		calculateDistance.setPayload(payload).transport("large-electric-car").getDistance();

	}
}
