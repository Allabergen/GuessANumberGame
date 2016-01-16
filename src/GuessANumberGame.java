import java.util.Random;
import java.util.Scanner;

/**
 * @author Allabergen Suleimenov
 *         allromis@gmail.com
 *         allabergen.su@gmail.com
 * @version 1.0
 */
public class GuessANumberGame {
    public static int number;
    public static int guess;
    public static int maxValue;
    public static int count;
    public static Scanner in;
    public static Random rand;

    public static void main(String[] args) {
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
