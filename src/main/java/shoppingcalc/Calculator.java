package shoppingcalc;

import static org.apache.commons.lang3.Validate.noNullElements;
import static org.apache.commons.lang3.Validate.notNull;

import java.util.List;
import java.util.Map;

/**
 * A shopping calculator.
 * 
 * @author sam
 */
public class Calculator {
	/** Map of (item name -&gt; price) */
	protected final Map<String, Float> priceMap;

	/**
	 * Initialises a new instance of Calculator using the specified map of (item name -&gt; price).
	 * 
	 * @param priceMap
	 *            the map
	 */
	public Calculator(Map<String, Float> priceMap) {
		this.priceMap = notNull(priceMap);
	}

	/**
	 * Calculates the total price of the specified items.
	 * 
	 * @param items
	 *            the items to calculate
	 * @return the total price
	 */
	public float calculate(List<String> items) {
		noNullElements(items);

		float total = 0;

		for (String item : items) {
			Float price = priceMap.get(item);

			if (price != null) {
				total += price;
			} else {
				// the desired item was not priced
				throw new IllegalArgumentException(
						String.format("Items contained [%s] which is not a known item type.", item));
			}
		}

		return total;
	}
}
