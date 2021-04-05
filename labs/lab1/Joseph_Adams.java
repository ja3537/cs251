/**
 * Joseph Adams
 * Lab 1, due June 7, 2020
 *
 * Joseph_Adams.java is a java program meeting the requirements of parts
 * 1-4 of Lab 1 in succession.
 *
 * The lab involves taking user input and inserting into arrays in order
 * to manipulate the elements. More information is given in print statements
 * before the user input is requested. In general these inputs are
 * delimited either by spaces or Enter.
 *
 * Another important comment is that not much consideration has been given
 * to user error. For example, when asked for the size of an array, if
 * the user inputs a negative value, an exception will be raised and the
 * program will crash. The usage considered is the usage specified in
 * the Lab 1 pdf.
 */

import java.util.Scanner;

class Joseph_Adams {
    public static void main(String args[]) {
	Scanner input = new Scanner(System.in);

	//Part 1
	
	System.out.println("Welcome to Lab1!");
	System.out.println("Part 1:");
	System.out.print("This part returns the sum of the first n terms of");
	System.out.print(" the harmonic progression, where n is an integer");
	System.out.print(" entered by the user\n");
	System.out.println("Please input n now:");

	int n = input.nextInt();
	double ans = 0;

	for(;n > 0; n--) ans += (double) 1/n;

	System.out.println(String.format("%.2f", ans));
	System.out.println();

	//Part 2

	System.out.println("Part 2:");
	System.out.print("Part two takes two inputs from the user: The ");
	System.out.print("first is an int that defines an array size. ");
	System.out.print("The second is integer values to be put in the ");
	System.out.print("array. The program will then return the index ");
	System.out.print("of the smallest element.\n");
	System.out.println("Please enter size of array now:");

	n = input.nextInt();
	int[] arr = new int[n];
	int min = Integer.MAX_VALUE;
	int minIndex = -1;
	int index;

	for(index = 0; index < n; index++){
	    arr[index] = input.nextInt();
	    if(arr[index] < min){
		min = arr[index];
		minIndex = index;
	    }
	}

	System.out.println(minIndex);
	System.out.println();

	//Part 3

	System.out.println("Part 3:");
	System.out.print("Part 3 takes two inputs from the user: The ");
	System.out.print("first is an int that defines an array size. ");
	System.out.print("The second is chars to be put in the array. ");
	System.out.print("The program will then return the ASCII ");
	System.out.print("values of these chars each on their own line.\n");
	System.out.println("Please enter size of array now:");
	
	n = input.nextInt();
	char[] charArr = new char[n];

	for(index = 0; index < n; index++) charArr[index] = input.next().charAt(0);

	for(index = 0; index < n; index++) System.out.println((int) charArr[index]);

	System.out.println();
	
	//Part 4

	System.out.println("Part 4:");
	System.out.print("Part 4 takes two inputs from the user: The ");
	System.out.print("first is an int that defines an array size. ");
        System.out.print("The second is letters to be put in the array. ");
        System.out.print("The program will then return Yes for each vowel");
	System.out.print(" and No for each non vowel.\n");

	n = input.nextInt();
	charArr = new char[n];
	
	for(index = 0; index < n; index++) charArr[index] = input.next().charAt(0);
	for(index = 0; index < n; index++){
	    switch (charArr[index]){
	    case 'a':
	    case 'A':
	    case 'e':
	    case 'E':
	    case 'i':
	    case 'I':
	    case 'o':
	    case 'O':
	    case 'u':
	    case 'U':
		System.out.print("Yes ");
		break;
	    default:
		System.out.print("No ");
	    }
	}
	System.out.println();
		
    }
}
	
	
