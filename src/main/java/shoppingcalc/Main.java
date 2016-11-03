package shoppingcalc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	private static final String LIST_REGEX = ",";

	/**
	 * Map of pricing.
	 */
	@SuppressWarnings("serial") private static final Map<String, Float> pricingMap = new HashMap<String, Float>() {
		{
			put("Banana", 0.35f);
			put("Orange", 0.20f);
			put("Apple", 0.50f);
			put("Lemon", 0.15f);
			put("Peach", 0.05f);
		}
	};

	/**
	 * Main entry point.
	 * 
	 * @param args
	 *            program arguments
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			usage();
		}

		Calculator c = new Calculator(pricingMap);
		List<String> items = asList(args[0]);
		float price = c.calculate(items);

		System.out.printf("Total price: £%.2f\n", price);
	}

	/**
	 * Converts a {@link #LIST_REGEX}-delimited list to a list.
	 * 
	 * @param listStr
	 *            the delimited list
	 * @return the corresponding list
	 */
	private static List<String> asList(String listStr) {
		return Arrays.asList(listStr.split(LIST_REGEX));
	}

	/**
	 * Displays usage and exits.
	 */
	private static void usage() {
		System.err.println("Usage: shoppingcalc shopping_list");
		System.exit(1);
	}
}
