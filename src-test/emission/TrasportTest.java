package emission;

import org.junit.Test;

import junit.framework.TestCase;
import transport.Transport;

public class TrasportTest extends TestCase {

	@Test
	public void test_TransportClass() {

		Transport transport = new Transport();

		assertEquals(142, transport.setTransport("small-diesel-car").getEmission());
		assertEquals(154, transport.setTransport("small-petrol-car").getEmission());
		assertEquals(73, transport.setTransport("small-plugin-hybrid-car").getEmission());
		assertEquals(50, transport.setTransport("small-electric-car").getEmission());
		
		assertEquals(171, transport.setTransport("medium-diesel-car").getEmission());
		assertEquals(192, transport.setTransport("medium-plugin-car").getEmission());
		assertEquals(110, transport.setTransport("medium-plugin-hybrid-car").getEmission());
		assertEquals(58, transport.setTransport("medium-electric-car").getEmission());
		
		assertEquals(209, transport.setTransport("large-diesel-car").getEmission());
		assertEquals(282, transport.setTransport("large-petrol-car").getEmission());
		assertEquals(126, transport.setTransport("large-plugin-hybrid-car").getEmission());
		assertEquals(73, transport.setTransport("large-electric-car").getEmission());
		
		assertEquals(6, transport.setTransport("train").getEmission());
		assertEquals(27, transport.setTransport("bus").getEmission());
	}

}
