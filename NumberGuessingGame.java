import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lower = 1;
        int higher = 100;     //set the range of numbers from 1 to 100.
        int number = random.nextInt(higher - lower +1) + lower;
        
        int maxAttempts = 10;   //set a limit on the number of attempts.
        int attempts = 0;
        int score = 0;          

        boolean guess = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + lower + " and " + higher + " you have "+ maxAttempts +" chance to guess correct number.");
        
      
        try {     // To handle the InputMismatchException
        	
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            

            if (userGuess < lower || userGuess > higher) {
                System.out.println("Please guess a number within the valid range.");
            }
            else if (userGuess == number) {
                guess = true;
                score = maxAttempts - attempts;            // Calculate the Score on the basis of number of attempts
                break;
            } 
            else if (userGuess < number) {
                System.out.println("Try a higher number :: number of Attempts left ==>  " + (maxAttempts - attempts));
            } 
            else {
                System.out.println("Try a lower number :: number of Attempts left ==>  " + (maxAttempts - attempts));
            }
        }
      

        if (guess) {
            System.out.println("Congratulations! You've guessed the number " + number + " in " + attempts + " attempts.");
            System.out.println("Your score is: " + score);
        } 
        else {
            System.out.println("Sorry, you've run out of attempts. The correct number was: " + number);
        }

        scanner.close();
        }
        catch(InputMismatchException e) {
        	System.out.println("wrong input enter only numeric value Example 1,2,2.... Try again");
        }
    }
}
