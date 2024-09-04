/*
Assume you are in charge of inventory management for the SMU Bookstore. The two main products at the
bookstore are Textbooks and SMU Branded Apparel. The Bookstore may purchase textbooks for $50 each and
then resell them for $100 each. SMU Branded Apparel can be purchased for $5 each and sold for $13.37 each.
The Bookstore must have items in stock before it can sell them and also must have enough cash on hand in the
Bookstore’s bank account to purchase / re-stock new items.
The purpose of this program is to simulate an administrative portal for Bookstore inventory management for
the SMU Bookstore. We should be able to view our current items in stock and bank account balance. We should
also be able to handle the purchase and sale of items (Books and Apparel in this case). We’ll also need to make
sure we have enough money in our bank account to purchase items before buying them and enough items in
stock to sell before performing a sale.
*/

import java.util.Scanner;
public class Bookstore2 {
    //Class member variables
    /*
    A variable declared within a class but outside any method is called 
    a class member variable or field, in contrast to a local variable 
    defined inside a method. 
    A field's scope extends from the class's opening brace to the class's
    closing brace and reaches into methods regardless of where the field is 
    declared within the class.
    */
    //Sets our number of books in stock to 100
    static int numBooksInStock = 100;
    //Sets our number of apparel in stock to 250
    static int numApparelInStock = 250;
    //Sets our current account balance to 0 since we haven’t sold anything yet
    static double balance = 0;
    //Scanner declaration
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        do {
            int userNumber = showMenu();
            /*
            If the user enters an option that is not 1, 2, 3, 4, 5 or 6, 
            display the message “Invalid choice. Please choose an option 
            from the list.” and loop back around to redisplay the menu. 
            Continue in this manner until a correct option is input
            */
            if (userNumber != 1 && userNumber != 2 && userNumber != 3 && userNumber != 4 && userNumber != 5 && userNumber != 6) {
                System.out.println("Invaild choice. Please choose an option from the list.");
            }
            /*
            if option 1 is selected, display the current inventory with prefix 
            text: "Books in Stock: " and "Apparel in Stock: ".
            */
            if (userNumber == 1) {
                showInventory();
            }
            /*
            if option 2 is selected, display the current account balance 
            with prefix text: "Current Balance: "
            */
            if (userNumber == 2) {
                showBalance();
            }
            /*
            if option 3 is selected, prompt the user for the number of Books to buy, 
            and once we have this number, check to see if we can afford the Books 
            (based on the formula: number of Books to be bought * 50 <= total cash 
            we have)
            */
            if (userNumber == 3) {
                System.out.print("Enter number of books to buy: ");
                int userBooksToBuy = input.nextInt();
                buyBooks(userBooksToBuy);
            } 
            /*
            If option 4 is selected, prompt the user for the number of Apparel to buy, and once we 
            have this number, check to see if we can afford the Apparel (based on the formula: 
            number of Apparel to be bought * 5 <= total cash we have)
            */
            if (userNumber == 4) {
                System.out.print("Enter amount of apparel to buy: ");
                int userApparelToBeBought = input.nextInt();
                buyApparel(userApparelToBeBought);
            }
            /*
            If option 5 is selected, prompt the user for the number of Books to sell.
            Then prompt the use for the number of Apparel to sell.
            Once we have these numbers, check to see if we have enough items in stock
            */
            if (userNumber == 5) {
                System.out.print("Enter number of books to sell: " );
                int userBooksToSell = input.nextInt();
                System.out.print("Enter number of apparel to sell: " );
                int userApparelToSell = input.nextInt();
                sellItems(userBooksToSell,userApparelToSell);
            }
            /*
            If option 6 is selected, then the program will end. Display a message saying “Goodbye :)” 
            and break the loop
            */
            if (userNumber == 6) {
                System.out.println("Goodbye :)" );
                break;
            }
        } while(true);
    }
    
    public static int showMenu() {
        //display the menu
        System.out.println("                             ");
        System.out.println("Welcome to the SMU Bookstore Inventory System");
        System.out.println("____________________________");
        System.out.println("                             ");
        System.out.printf("%-15s", "Choice");
        System.out.printf("%4s\n", "Action");
        System.out.printf("%-15s", "1");
        System.out.printf("%4s\n", "Show Inventory");
        System.out.printf("%-15s", "2");
        System.out.printf("%4s\n", "Show Balance");
        System.out.printf("%-15s", "3");
        System.out.printf("%4s\n", "Buy Books");
        System.out.printf("%-15s", "4");
        System.out.printf("%4s\n", "Buy SMU Apparel");
        System.out.printf("%-15s", "5");
        System.out.printf("%4s\n", "Sell Items(s)");
        System.out.printf("%-15s", "6");
        System.out.printf("%4s\n", "Exit");
        
        System.out.print("Choose an option: ");
        int userNumber = input.nextInt();
        return userNumber;
    }

    /*
    showInventory() is option 1,
    display the current inventory with prefix 
    text: "Books in Stock: " and "Apparel in Stock: "
    */
    public static void showInventory() {
        System.out.println("Books in Stock: " + numBooksInStock);
        System.out.println("Apparel in Stock: " + numApparelInStock);
    }
    /*
    showBalance() is option 2, display the current account balance 
    with prefix text: "Current Balance: "
    */
    public static void showBalance() {
        System.out.printf("Current Balance: %.2f",  balance);
    }
    /*
    buyBooks(int numBooks) is option 3, prompt the user for the number of Books to buy, 
    and once we have this number, check to see if we can afford the Books 
    (based on the formula: number of Books to be bought * 50 <= total cash we have)
    */
    public static void buyBooks(int numBooks) {
        int userBooksToBuy = numBooks;

        if (userBooksToBuy* 50 <= balance) {
            /*
            If we can, then we add the newly purchased Books to our current book stock
            and reduce out account balance to whatever is left after the purchase
            */
            numBooksInStock += userBooksToBuy;
            balance -= userBooksToBuy* 50;
            /*
            Then we display the number of books bought, followed by our inventory
            and account balance
            */
            System.out.println("Bought "+ userBooksToBuy + " books");
            System.out.println("Books in Stock: " + numBooksInStock);
            System.out.println("Apparel in Stock: " + numApparelInStock);
            System.out.printf("Current Balance: %.2f",  balance);
            
        }
        //If we cannot, then we display a message saying – “We don’t have enough money for this :(”
        else {
            System.out.println("We don't have enough money for this : (");
        }
    }
    /*
    buyApparel(int numApparel) is option 4, prompt the user for the number of
    Apparel to buy, and once we have this number, check to see if we can 
    afford the Apparel (based on the formula: number of Apparel to be 
    bought * 5 <= total cash we have)
    */
    public static void buyApparel(int numApparel) {
        /*
        if we can, then we add the newly purchased Apparel to our current 
        apparel stock and reduce our account balance to whatever is left 
        after the purchase. 
        Then we display the number of apparel bought, followed by our inventory and account balance
        */
        int userApparelToBeBought = numApparel;
        //number of Apparel to be bought * 5 <= total cash we have
        if (userApparelToBeBought * 5 <= balance) {
            numApparelInStock += userApparelToBeBought;
            balance -= userApparelToBeBought * 5;
            System.out.println("Bought "+ userApparelToBeBought + " apparel");
            System.out.println("Books in Stock: " + numBooksInStock);
            System.out.println("Apparel in Stock: " + numApparelInStock);
            System.out.printf("Current Balance: %.2f",  balance);
            }
            /*
            If we cannot, then we display a message saying – “We don’t have 
            enough money for this :(”
            */
            else {
                System.out.println("We don't have enough money for this : (");
            }
    }
    /*
    sellItems(int numBooks, int numApparel) is option 5, prompt the user for the number of Books to sell.
    Then prompt the use for the number of Apparel to sell.
    Once we have these numbers, check to see if we have enough items in stock
    */
    public static void sellItems(int numBooks, int numApparel) {
        int userBooksToSell = numBooks;
        int userApparelToSell = numApparel;
        if (numBooksInStock >= userBooksToSell ) {
            balance += userApparelToSell * 13.37 + userBooksToSell * 100;
            numBooksInStock -= userBooksToSell;
            numApparelInStock -= userApparelToSell;
            System.out.println("Books in Stock: " + numBooksInStock);
            System.out.println("Apparel in Stock: " + numApparelInStock);
            System.out.printf("Current Balance: %.2f",  balance);
            }
            /*
            If we cannot, then we display a message saying – "We don't have enough items in stock for this : ("
            */
            else {
                System.out.println("We don't have enough items in stock for this : (");
            }
    }
}