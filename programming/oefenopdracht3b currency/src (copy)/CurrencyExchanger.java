import java.util.Scanner;


/**
 * Currency exchange.
 * @author dominic
 *
 */
public class CurrencyExchanger {
	public final double DOLLAR_RATE = 1;
	public final double POUND_RATE = 0.762888;
	public final double YEN_RATE = 113.470557;
	public final double EURO_RATE = 0.850292;
	
	public Currency[] currencies;
	
	public void main() {
		currencies = new Currency[] {
				new Currency("US Dollar", DOLLAR_RATE),
				new Currency("GP Pounds", POUND_RATE),
				new Currency("Yen", YEN_RATE),
				new Currency("Euro", EURO_RATE)
		};
		
		System.out.println("Huidige valuta: ");
		Currency inputCurrency = currencies[getUserInputValuta()];
		System.out.println("");
		

		System.out.print("Gewenste valuta: ");
		Currency outputCurrency = currencies[getUserInputValuta()];
		System.out.println("");

		System.out.println("In te wisselen bedrag (gehele getallen) : ");
		Scanner input = new Scanner(System.in);
		int inputAmount = input.nextInt();
		
		double outputAmount = (double) inputAmount / inputCurrency.rate 
					    * outputCurrency.rate;
		outputAmount = Math.round(outputAmount * 100) / 100.0;
		String template = "\n%s %d = %s %.2f";
		System.out.printf(template, inputCurrency.name, inputAmount, outputCurrency.name, outputAmount);

	}
	
	public int getUserInputValuta() {
		// Occasional -1 to correct for 0-based indexing.
		for (int i=1; i <= currencies.length; i++) {
			System.out.println(i + ". " + currencies[i-1].name);
		}
		Scanner input = new Scanner(System.in);
		
		int result = input.nextInt() - 1;
		System.out.println(currencies[result].name);
		return result;
	}

}
