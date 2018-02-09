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
	
	public CurrencyExchanger() {
		currencies = new Currency[] {
				new Currency("US Dollar", DOLLAR_RATE),
				new Currency("GP Pounds", POUND_RATE),
				new Currency("Yen", YEN_RATE),
				new Currency("Euro", EURO_RATE)
		};

    }

    public double exchange(double inputAmount, Currency inputCurrency, Currency outputCurrency){
        double outputAmount = (double) inputAmount / inputCurrency.rate 
					    * outputCurrency.rate;
		outputAmount = Math.round(outputAmount * 100) / 100.0;
        return outputAmount;

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
