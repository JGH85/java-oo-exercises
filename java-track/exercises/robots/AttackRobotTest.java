package robots;
import static org.junit.Assert.*;

import org.junit.Test;

public class AttackRobotTest {

	@Test
	public void testHeal() {
		AttackRobot r = new AttackRobot(0,0,0,0,0,0);
		r.health = 0;
		r.heal(5);
		assertEquals("Health not working", 5, r.getHealth());
	}

	@Test
	public void testAttack() {
		fail("Not yet implemented");
	}

	@Test
	public void testCanAttack() {
		fail("Not yet implemented");
	}

}
