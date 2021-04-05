/**
 * Joseph Adams
 *
 * Lab 3, due June 21, 2020
 *
 * Sundae.java defines the Sundae class, which is a subclass of IceCream,
 * which is a subclass of Dessert.
 */

class Sundae extends IceCream {

    Sundae(IceCream base, Dessert topping){
	super(base.getName() +" topped with "+ topping.getName(), base.getPrice() + topping.getPrice());
    }
}
