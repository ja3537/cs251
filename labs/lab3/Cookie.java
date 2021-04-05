/**
 * Joseph Adams
 * Lab 3, due June 21, 2020
 *
 * Cookie.java defines the Cookie class, which is a subclass of
 * the Dessert class.
 *
 * The reason why I have made the variables private instead of
 * protected is that all files are in the same package, so main()
 * would have access to proteced variables.
 */

class Cookie extends Dessert {

    private int itemCount;
    private double pricePerDozen;

    Cookie(String name, int itemCount, double pricePerDozen){
	super(name);
	this.itemCount = itemCount;
	this.pricePerDozen = pricePerDozen;
    }

    public int getItemCount(){
	return itemCount;
    }

    public double getPricePerDozen(){
	return pricePerDozen;
    }

    public double getPrice(){
	return (itemCount*pricePerDozen)/12;
    }

}
	
