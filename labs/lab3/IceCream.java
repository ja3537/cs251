/**
 * Joseph Adams
 * Lab 3, due June 21, 2020
 *
 * IceCream.java defines the IceCream class, which is a subclass of
 * the Dessert class.
 *
 * The reason why I have made the variables private instead of
 * protected is that all files are in the same package, so main()
 * would have access to proteced variables.
 */

class IceCream extends Dessert{

    private double price;

    IceCream(String name, double price){
	super(name);
	this.price = price;
    }

    public double getPrice(){
	return price;
    }
}
