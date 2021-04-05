/**
 * Joseph Adams
 * Lab 2, due June 14, 2020
 *
 * BankManagement.java is a simple bank user management program.
 * It allows the user to perform some basic operations on already
 * existing bank accounts including: check information, check balance,
 * withraw, deposit, and check last transaction.
 *
 * This program will automatically round to the nearest penny, and
 * allows the user to input custom withraw and deposit amounts in
 * the command line.
 *
 * When asked for the name of the user, remember it is case sensitive.
 *
 * If any new users are desired, please use the createUser() method
 * inside main so the user array and id numbers will be automatically
 * changed.
 *
 * This program does not contain any exception handling, so it is
 * very easy to crash it. For example, placing anything that cannot
 * be considered a double when asked for withdraw amount will cause
 * errors.
 */

import java.util.Scanner;

class User{
    final String NAME;
    final int ID;
    double balance;
    char lastTransaction;
    double lastAmount;

    /**
     * User() is the constructor for the User class. It takes the name,
     * id (which is generated by createUser()), and balance as parameters.
     * Notice that last transaction variables are set to show the initial
     * deposit as the last transaction. 
     */

    User(String name, int id, double balance){
        this.NAME = name;
        this.ID = id;
        this.balance = round(balance);
        lastTransaction = 'd';
        lastAmount = this.balance;
    }

    /**
     * round() is a simple method that rounds a double to two decimal places.
     */

    double round(double value){
        return (double) Math.round(value*100)/100;
    }

    /**
     * checkInformation() prints the name and id of the user when called.
     */

    void checkInformation(){
        System.out.println("Name: " + NAME);
        System.out.println("ID: " + String.format("%03d", ID));
    }

    /**
     * checkBalance() prints the balance of the user when called.
     */
    
    void checkBalance(){
        System.out.println("Your balance is: $" + String.format("%.2f",balance));
    }

    /**
     * withdraw() will withdraw the requested amount to the nearest penny. If
     * the amount requested is negative or if there are insufficient funds,
     * an appropriate message is printed instead.
     */
    
    void withdraw(double amount){
        
        amount = round(amount);
        
        if(amount <= 0){
            System.out.println("Improper amount to withdraw");
        }
        else if(amount > balance){
            System.out.println("Insufficient balance for this transaction");
        } else {
            balance = round(balance - amount);
            System.out.println("Withdrawn: $" + String.format("%.2f",amount));
            lastTransaction = 'w';
            lastAmount = amount;
        }

    }

    /**
     * deposit() will deposit the requested amount to the nearest penny. If
     * the amount requested is negative, an appropriate message is printed
     * instead.
     */

    void deposit(double amount){
        
        amount = round(amount);

        if(amount <= 0){
            System.out.println("Improper amount to deposit");
        } else {
            balance += amount;
            balance = round(balance);
            System.out.println("Deposited: $" + String.format("%.2f",amount));
            lastTransaction = 'd';
            lastAmount = amount;
        }
    }

    /**
     * lastTransaction() simply prints a statement regarding the last
     * transaction the user has taken.
     */

    void lastTransaction(){
        if(lastTransaction == 'w') {
            System.out.print("Last transaction: Withdraw $");
            System.out.println(String.format("%.2f", lastAmount));
        }
        else {
            System.out.print("Last transaction: Deposit $");
            System.out.println(String.format("%.2f", lastAmount));
        }
    }
        
}       
    

class BankManagement {

    User[] userArr = new User[100]; //used to hold User objects
    int userCount = 0; //used to count User objects and generate ID numbers
    Scanner input;
    User currentUser = null; //used to reference this User

    /**
     * createUser() creates a User object, automatically generating an id
     * for it, then places that object in the user array.
     *
     * The fact that createUser() returns a reference to the new object is
     * not used in this program as written, but could be useful for testing
     * or if the program is ever altered.
     */
    
    User createUser(String name, double balance){
            User obj = new User(name, userCount + 1, balance);
            userArr[userCount++] = obj;
            return obj;
        }

    /**
     * delimit() is just a cosmetic method that prints a string of
     * symbols to make the output of the program more readable.
     */
    
    void delimit(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    /**
     * enterName() is used to prompt the user to give their name, then searches
     * the user array for the name given. If the name is not found, it prints
     * a statement to that effect. If it is found, the currentUser variable is
     * made to reference the appropriate User object.
     *
     * It returns a boolean because it is used as a condition for a while loop.
     */
    
    boolean enterName(){
        System.out.println("Enter your name:");
        
        input = new Scanner(System.in);
        String name = input.nextLine();

        for(int i = 0; i < userCount; i++){
            if(userArr[i].NAME.equals(name)){
                currentUser = userArr[i];
                delimit();
                return false;
            }
        }

        System.out.println("Sorry, there is no user name " + name);
        delimit();
        return true;
    }

    /**
     * enterOption() is used to give the user a menu of options, prompt a
     * response, then use a switch statement to make the appropriate User
     * method calls.
     *
     * This method returns a boolean because it is used as the condition for
     * a while loop.
     */
    
    boolean enterOption(){
        input = new Scanner(System.in);
        char ch; //used to receive the option choice
        double amount; //used for withdraw() and deposit()

        System.out.println("Hello " + currentUser.NAME);

        System.out.println("Press:");
        System.out.println("1: to check information");
        System.out.println("2: to check balance");
        System.out.println("3: to withdraw");
        System.out.println("4: to deposit");
        System.out.println("5: to check last transaction");
        System.out.println("Any other key: to exit");

        ch = input.next().charAt(0);
        delimit();
        
        switch(ch) {
            case '1':
                currentUser.checkInformation();
                return true;
            case '2':
                currentUser.checkBalance();
                return true;
            case '3':
                System.out.println("Please input amount:");
                System.out.print("$");
                amount = input.nextDouble();
                currentUser.withdraw(amount);
                return true;
            case '4':
                System.out.println("Please input amount:");
                System.out.print("$");
                amount = input.nextDouble();
                currentUser.deposit(amount);
                return true;
            case '5':
                currentUser.lastTransaction();
                return true;
            default:
                return false;
            }
    }

    /**
     * main() is very simple. It begins by making a new BankManagement object
     * in order to access the methods above. It then creates new User objects
     * in the user array using the createUser() method. Feel free to change
     * these or insert your own.
     *
     * The user experience is created using two while loops. The first one
     * executes until enterName() returns false, which happens when the user
     * gives a name in the user array. The second gives the user options until
     * a character is entered other than a digit from 1 to 5.
     */

    public static void main(String args[]){
        
        BankManagement bm = new BankManagement();

        bm.createUser("Joe Adams", 1d);
        bm.createUser("Richie Rich", 1000000000d);
        bm.createUser("Jeff Bezos", 152900000000d);
        bm.createUser("Lebron James", 450000000d);
        bm.createUser("Dwayne Johnson", 280000000d);

        
        while(bm.enterName());

        while(bm.enterOption())bm.delimit();
    }
}

            
            
        
