package main;

import java.util.HashMap;

import java.util.Map;

public class Transport {

	public static final String SMALL_DIESEL_CAR = "small-diesel-car";
	public static final String SMALL_PETROL_CAR = "small-petrol-car";
	public static final String SMALL_PLUGIN_HYBRID = "small-plugin-hybrid-car";
	public static final String SMALL_ELECTRIC_CAR = "small-electric-car";

	public static final String MEDIUM_DIESEL_CAR = "medium-diesel-car";
	public static final String MEDIUM_PETROL_CAR = "medium-plugin-car";
	public static final String MEDIUM_PLUGIN_HYBRID = "medium-plugin-hybrid-car";
	public static final String MEDIUM_ELECTRIC_CAR = "medium-electric-car";

	public static final String LARGE_DIESEL_CAR = "large-diesel-car";
	public static final String LARGE_PETROL_CAR = "large-petrol-car";
	public static final String LARGE_PLUGIN_HYBRID = "large-plugin-hybrid-car";
	public static final String LARGE_ELECTRIC_CAR = "large-electric-car";

	public static final String BUS = "bus";
	public static final String TRAIN = "train";

	public String transport;

	public Transport() {

	}

	public Transport setTransport(String transport) {

		this.transport = transport;
		return this;

	}

	public int getEmission() {

		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put(SMALL_DIESEL_CAR, 142);
		map.put(SMALL_PETROL_CAR, 154);
		map.put(SMALL_PLUGIN_HYBRID, 73);
		map.put(SMALL_ELECTRIC_CAR, 50);

		map.put(MEDIUM_DIESEL_CAR, 171);
		map.put(MEDIUM_PETROL_CAR, 192);
		map.put(MEDIUM_PLUGIN_HYBRID, 110);
		map.put(MEDIUM_ELECTRIC_CAR, 58);

		map.put(LARGE_DIESEL_CAR, 209);
		map.put(LARGE_PETROL_CAR, 282);
		map.put(LARGE_PLUGIN_HYBRID, 126);
		map.put(LARGE_ELECTRIC_CAR, 73);

		map.put(BUS, 27);
		map.put(TRAIN, 6);

		if (map.get(transport) != null || (map.get(transport) == null && map.containsKey(transport))) {
			return map.get(transport);
		} else {
			return 0;
		}

	}

}
