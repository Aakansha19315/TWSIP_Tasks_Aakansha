package intern;
import java.util.Random;
import java.util.Scanner;

public class Number_Guessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1; 
        int upperBound = 100; 
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxTries = 10;
        int tries = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxTries + " tries to guess it.");
        
        while (tries < maxTries) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            tries++;
            
            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please guess within the valid range.");
            } else if (userGuess < numberToGuess) {
                System.out.println("Try higher. There are still " + (maxTries - tries) + " tries left.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Try lower. There are still " + (maxTries - tries) + " tries left.");
            } else {
                System.out.println("Congratulations! You've guessed it right in " + tries + " tries.");
                break;
            }
        }
        
        if (tries == maxTries) {
            System.out.println("Sorry, you've used up all of your The correct number was " + numberToGuess + ".");
        }
        
        scanner.close();
    }
}
