package shoppingcalc;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CalculatorTest {
	@Test
	public void policyIsAppliedCorrectlyForSingleList() {
		// given
		Map<String, Float> priceMap = createPriceMap();

		Calculator calculator = new Calculator(priceMap);

		// when
		float price = calculator.calculate(Arrays.asList("A"));

		// then
		assertEquals(10f, price, 0);
	}

	@Test
	public void policyIsAppliedCorrectlyForMultipleList() {
		// given
		Map<String, Float> priceMap = createPriceMap();

		Calculator calculator = new Calculator(priceMap);

		// when
		float price = calculator.calculate(Arrays.asList("A", "A", "A", "B"));

		// then
		assertEquals(40f, price, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nonExistentItemIsIdentified() {
		// given
		Map<String, Float> priceMap = createPriceMap();

		Calculator calculator = new Calculator(priceMap);

		// when
		calculator.calculate(Arrays.asList("_nonexistent_"));

		// then
	}

	/**
	 * Creates a fresh price map for testing.
	 * 
	 * @return the newly created pricing map
	 */
	private Map<String, Float> createPriceMap() {
		float price = 10f;

		Map<String, Float> pricingMap = new HashMap<>();

		pricingMap.put("A", price);
		pricingMap.put("B", price);

		return pricingMap;
	}
}
