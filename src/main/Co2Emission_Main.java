package main;


import org.json.JSONObject;

import co2.CityGeoCode;
import co2.CreateDistance;
import co2.PUTPayload;

public class Co2Emission_Main {

	public static void main(String[] args) throws Throwable {

		for (int i = 0; i < args.length; i++) {
			System.out.println(String.format("Command Line Argument %d is %s", i, args[i]));
		}

		CityGeoCode citycode1 = new CityGeoCode();
		CityGeoCode citycode2 = new CityGeoCode();

		citycode1.city(args[1]).getLongLatitude();
		citycode2.city(args[3]).getLongLatitude();
		PUTPayload co2em = new PUTPayload();

		JSONObject payload = co2em.coordinateCity_1(citycode1.getLatitude(), citycode1.getLongitude()) //
				.coordinateCity_2(citycode2.getLatitude(), citycode2.getLongitude())//
				.buildPayload();

		CreateDistance calculateDistance = new CreateDistance();
		calculateDistance.setPayload(payload).transport(args[4].replace("--transportation-method=", "")).getDistance();

	}
}
