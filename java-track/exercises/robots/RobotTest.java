package robots;
import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void testRotate() {
		Robot r = new Robot (1,1,90,1);
		r.rotate(450);
		assertTrue(r.getOrientation()==180);
	}

}
