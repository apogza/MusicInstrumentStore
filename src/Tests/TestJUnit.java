package Tests;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testAdd() {
		String str = "JUnit is working just fine";
		assertEquals("JUnit is working just fine", str);
	}
}
