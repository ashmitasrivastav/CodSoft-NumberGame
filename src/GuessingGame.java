
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;
        int round = 0;
        
        while (playAgain) {
            round++;
            int numberToGuess = random.nextInt(100) + 1;
            int maxAttempts = 10;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + round + ": Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");
            
            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    score++;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over. Your total score is: " + score + " out of " + round + " rounds.");
        scanner.close();
    }
}
