import java.util.Random;
import java.util.Scanner;

public class guessnumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        int attempts = 0;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ". Try to guess it!");

        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < minRange || userGuess > maxRange) {
                System.out.println("Please enter a number within the valid range.");
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number (" + randomNumber + ") in " + attempts + " attempts.");
                break;
            }
        }

        scanner.close();
    }
}
