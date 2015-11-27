package bowlingtest;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class BowlingTest {

	@Test
	public void checkStrikesOnly() {
		BowlingCalculator calc = new BowlingCalculator();
		int result = calc.calculateResult("XXXXXXXXXXXX");
		assertThat(result,CoreMatchers.is(300));
	}
	@Test
	public void checkNineMiss() {
		BowlingCalculator calc = new BowlingCalculator();
		int result = calc.calculateResult("9-9-9-9-9-9-9-9-9-9-");
		assertThat(result,CoreMatchers.is(90));
	}
	@Test
	public void checkRandomShortX() {
		BowlingCalculator calc = new BowlingCalculator();
		int result = calc.calculateResult("9/345/X6123XXX45");
		assertThat(result,CoreMatchers.is(151));
	}
	@Test
	public void checkRandomLongX() {
		BowlingCalculator calc = new BowlingCalculator();
		int result = calc.calculateResult("9/345/X6123XXXX45");
		assertThat(result,CoreMatchers.is(172));
	}
	@Test
	public void checkSpare() {
		BowlingCalculator calc = new BowlingCalculator();
		int result = calc.calculateResult("5/5/5/5/5/5/5/5/5/5/5");
		assertThat(result,CoreMatchers.is(150));
	}
	
	

}
