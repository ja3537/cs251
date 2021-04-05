import java.util.Scanner;

class SuperClass{

    int side;
    SuperClass(int side)
    {
	this.side = side;
    }
}

class SubClass extends SuperClass{

    SubClass(int side)
    {
	super(side);
    }
    int computeArea(){
	return side*side;
    }
}



public class MainClass {
    public static void main(String[] args){

	Scanner input = new Scanner(System.in);
	System.out.print("Please insert side length: ");
	int side = input.nextInt();

	SubClass A = new SubClass(side);

	System.out.println("Area is: " + A.computeArea());

    }
}
	
