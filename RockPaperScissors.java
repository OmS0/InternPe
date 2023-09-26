import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random ob = new Random();

        String[] choices = {"ROCK", "PAPER", "SCISSORS"};

        while(true)
        {
            int ComputerChoiceIndex = ob.nextInt(choices.length);
            String ComputerChoice =  choices[ComputerChoiceIndex];

            System.out.print("Enter Your Choice (Rock, Paper, Scissors): ");
            String UserChoice = sc.nextLine().toUpperCase();

            if(!UserChoice.equals("ROCK") && !UserChoice.equals("PAPER") && !UserChoice.equals("SCISSORS"))
            {
                System.out.println("Invalid Input. Please Choose Rock, Paper or Scissors");
                continue;
            }
            if(UserChoice.equals(ComputerChoice))
            {
                System.out.println("It's a Tie! Computer Also Chose: " + ComputerChoice + ".");
            }
            else if(
                    (UserChoice.equals("ROCK") && ComputerChoice.equals("SCISSORS")) ||
                    (UserChoice.equals("PAPER") && ComputerChoice.equals("Rock")) ||
                    (UserChoice.equals("SCISSORS") && ComputerChoice.equals("PAPER"))
                   )
            {
                System.out.println("You Win! Computer Chose: " + ComputerChoice + ".");
            }
            else
            {
                System.out.println("Computer Wins! Computer Chose: " + ComputerChoice + ".");
            }

            System.out.print("Do You Want To Play Again? (Yes/No): ");
            String Play = sc.nextLine().toUpperCase();
            if (!Play.equals("YES"))
            {
                break;
            }
        }
        System.out.println("Thanks For Playing!");
    }
}
