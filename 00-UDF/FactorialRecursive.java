import java.util.Scanner;

public class FactorialRecursive {
    static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int number = scanner.nextInt();

        if (number < 0 || number > 20) {
            System.out.println("Enter a number from 0 to 20.");
            return;
        }
        System.out.printf("Factorial of %d is %d%n", number, factorial(number));
    }
}
