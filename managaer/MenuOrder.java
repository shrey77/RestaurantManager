package managaer;

public class MenuOrder {
	private int tableNum, pastaQuantity, lasagnaQuantity, breadsticksQuantity, soupQuantity, saladQuantity;
	// Variable for price of each item on menu
	private double pastaPrice =  10.99, lasagnaPrice = 10.99, breadsticksPrice = 5.99, soupPrice = 8.99, saladPrice = 8.99;
	
	public MenuOrder() {
		pastaQuantity = 0;
		lasagnaQuantity = 0;
		breadsticksQuantity = 0;
		soupQuantity = 0;
		saladQuantity = 0;
	}
	
	public void newOrder(int table, int pasta, int lasagna, int breadsticks, int soup, int salad) {
		tableNum = table;
		pastaQuantity = pasta;
		lasagnaQuantity = lasagna;
		breadsticksQuantity = breadsticks;
		soupQuantity = soup;
		saladQuantity = salad;
	}
	
	public double orderSubtotal() {
		return ((pastaQuantity*pastaPrice) + (lasagnaQuantity*lasagnaPrice) + (breadsticksQuantity*breadsticksPrice) + (soupQuantity*soupPrice)
				+ (saladQuantity*saladPrice));
	}
	
	public double orderTotal() {
		double tax = 0.13;
		return (orderSubtotal()*(1+tax));
	}
}

