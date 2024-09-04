import java.util.Scanner;
public class SumSnake{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        //Prompt the user to enter an integer number using the keyboard
        System.out.println("Enter an integer: ");
        //Assigned variables
        int userNumber = input.nextInt();
        int totalSum = 0;
        //prints "----For Loop-----" on terminal
        System.out.println("----For Loop-----");
        /*
        for loop to count the natural numbers from 0 up to the number they entered.
        It will print one number per line with a space preceding each even number.
        */
        for (int i=0; i<userNumber; i++) {
            if (i % 2 ==0) {
                System.out.println(i);
            }
            if (i % 2 ==1) {
                System.out.println(" " + i);
            }
            /*
            It will calculate the sum of these numbers after the 
            “snake” of numbers.
            */
            totalSum = totalSum + i;
        }
        //output the sum of these numbers after the “snake” of numbers.
        System.out.println("Sum is "+ totalSum);
        System.out.println("----While Loop-----");
        /*
        while loop to count the natural numbers from 0 up to the number they entered.
        It will print one number per line with a space preceding each even number.
        */
        int i = 0;
        while (i<userNumber) {
            if (i % 2 ==0) {
                System.out.println(i);
            }
            if (i % 2 ==1) {
                System.out.println(" " + i);
            }
            i++;
        }
        //output the sum of these numbers after the “snake” of numbers.
        System.out.println("Sum is "+ totalSum);
    }
}