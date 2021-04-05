/**
 * Joseph Adams
 * Lab 3, due June 21, 2020
 *
 * Candy.java defines the Candy class, which is a subclass of
 * the Dessert class.
 *
 * The reason why I have made the variables private instead of
 * protected is that all files are in the same package, so main()
 * would have access to protected variables.
 */

class Candy extends Dessert {

    private double weight;
    private double pricePerPound;

    Candy(String name, double weight, double pricePerPound){
	super(name);
	this.weight = weight;
	this.pricePerPound = pricePerPound;

    }

    public double getWeightInPounds(){
	return weight;
    }

    public double getPricePerPound(){
	return pricePerPound;
    }

    public double getPrice(){
	return weight * pricePerPound;
    }
}
