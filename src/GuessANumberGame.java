import java.util.Random;
import java.util.Scanner;

/**
 * @author Allabergen Suleimenov
 *         allromis@gmail.com
 *         allabergen.su@gmail.com
 * @version 1.1
 */
public class GuessANumberGame {
    public static int number;
    public static int guess;
    public static int maxValue;
    public static int count;
    public static Scanner in;
    public static Random rand;

    public static void main(String[] args) {
        System.out.println("Welcome to \"Guess A Number Game\"");
        playGame();
        chooseOption();
    }

    public static void playGame() {
        in = new Scanner(System.in);
        rand = new Random();

        System.out.print("Enter the Maximum value of range of the number: ");
        maxValue = enterNumber();
        number = rand.nextInt(maxValue) + 1;
        System.out.println("Please enter a guess: ");

        while (guess != number) {
            guess = enterNumber();
            count++;

            if (guess < number) {
                System.out.println("Too low");
            }
            if (guess > number) {
                System.out.println("Too high");
            }
        }

        System.out.println("You WIN!!!\nYou guessed a number in " + count + " steps");
        count = 0;
    }

    public static void chooseOption() {
        int choice;

        do {
            showMenu();
            choice = enterNumber();

            switch (choice) {
                case 1:
                    playGame();
                case 0:
                    System.out.println("Bye bye!");
                    break;
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.print("\nEnter to choose: \n" +
                "1 - Play Again\n" +
                "0 - Exit\n");
    }

    public static int enterNumber() {
        int num;
        do {
            try {
                num = in.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Enter a Number!");
                in.next();
            }
        } while (true);

        return num;
    }
}
