package emission;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.junit.Test;

import co2.CityGeoCode;
import co2.TransportType;
import junit.framework.TestCase;


public class TrasportTest extends TestCase {
	private static final SimpleDateFormat tsFormater = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	@Test
	public void test_TransportClass() {

		TransportType transport = new TransportType();

		assertEquals(142, transport.transportType("small-diesel-car").getEmission());
		assertEquals(154, transport.transportType("small-petrol-car").getEmission());
		assertEquals(73, transport.transportType("small-plugin-hybrid-car").getEmission());
		assertEquals(50, transport.transportType("small-electric-car").getEmission());

		assertEquals(171, transport.transportType("medium-diesel-car").getEmission());
		assertEquals(192, transport.transportType("medium-plugin-car").getEmission());
		assertEquals(110, transport.transportType("medium-plugin-hybrid-car").getEmission());
		assertEquals(58, transport.transportType("medium-electric-car").getEmission());

		assertEquals(209, transport.transportType("large-diesel-car").getEmission());
		assertEquals(282, transport.transportType("large-petrol-car").getEmission());
		assertEquals(126, transport.transportType("large-plugin-hybrid-car").getEmission());
		assertEquals(73, transport.transportType("large-electric-car").getEmission());

		assertEquals(6, transport.transportType("train").getEmission());
		assertEquals(27, transport.transportType("bus").getEmission());

		assertEquals(0, transport.transportType("Bus").getEmission());
		assertEquals(0, transport.transportType("Bus1").getEmission());
	}

	@Test
	public void test_lanitude() throws ParseException, JSONException {

		CityGeoCode citycode = new CityGeoCode();

		try {
			citycode.city("Berlin").getLongLatitude();
			System.out.println(citycode.getLatitude());
			System.out.println(citycode.getLongitude());

			// assertEquals("52.52045", citycode.getLatitude());
			// assertEquals("13.40732", citycode.getLongitude());

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// assertEquals(0, transport.setTransport("Bus1").getEmission());
	}

	@Test
	public void test11() throws Exception {

		Date nowTs = tsFormater.parse("2019-11-27T15:53:18.243+0000");
		Date finalReportTs = tsFormater.parse("2019-11-27T14:21:22.243+0000");
		// JSONObject expectedOutput = buildExpectedAcceptRequestOutput(finalReportTs,
		// nowTs);

		// System.out.println(expectedOutput.toString());
//		try {
//			defaultApplicationName(expectedOutput.getJSONObject("appl").getString("name"));
//			applicationVersion(expectedOutput.getJSONObject("appl").getString("version"));
//			dataCenterId(expectedOutput.getString("data-center"));
//			defaultHost(expectedOutput.getString("host"));
//
//			PullReportTrackingBuilder builder = new PullReportTrackingBuilder().now(nowTs).succeeded() //
//					.customerNo(expectedOutput.getString("customer")) //
//					.trackingId("22k3ipeylz-dev-fax4win-2zjrkg859s64x222") //
//					.serverId(expectedOutput.getJSONObject("info").getString("server-id")) //
//					.jobId(expectedOutput.getJSONObject("info").getString("job-id")) //
//					.jobRefId(expectedOutput.getJSONObject("info").getString("job-ref-id")) //
//					.billingCode(expectedOutput.getJSONObject("info").getString("billing-code")) //
//					.customerAccount(expectedOutput.getJSONObject("info").getString("customer-account")) //
//					.customerAgent(expectedOutput.getJSONObject("info").getString("customer-agent"))
//					.reportFinalTs(finalReportTs)//
//					.clientFingerprint(expectedOutput.getJSONObject("info").getString("client-fingerprint"));
//
//			if (!expectedOutput.toString().equals(builder.build().toString())) {
//				LOG.info("expected: " + expectedOutput.toString());
//				LOG.info("actual:   " + builder.build().toString());
//			}
//
//			assertEquals(expectedOutput.toString(), builder.build().toString());
//
//			LOG.info("testPullReportMsg - test passed!");
//
//		} catch (Exception e) {
//			LOG.error("test failed!", e);
//			fail();
//		}
	}

}
