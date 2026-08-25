import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    private static final int MAX_SIZE = 100;

    private static void display(int[] values, int size) {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array elements: ");
        for (int index = 0; index < size; index++) {
            System.out.print(values[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = new int[MAX_SIZE];
        System.out.print("How many elements do you want? (1-" + MAX_SIZE + "): ");
        int size = scanner.nextInt();
        if (size < 1 || size > MAX_SIZE) {
            System.out.println("Invalid size.");
            return;
        }
        for (int index = 0; index < size; index++) {
            System.out.print("Element " + (index + 1) + ": ");
            values[index] = scanner.nextInt();
        }

        int choice;
        do {
            System.out.println("\n=== Array Operation ===");
            System.out.println("1.Display 2.Insert 3.Delete 4.Update 5.Search");
            System.out.println("6.Sort Ascending 7.Sort Descending 8.Reverse");
            System.out.println("9.Maximum 10.Minimum 11.Sum 12.Average 13.Count Even 14.Count Odd 15.Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> display(values, size);
                case 2 -> {
                    if (size == MAX_SIZE) { System.out.println("Array is full."); break; }
                    System.out.print("Position (1-" + (size + 1) + "): ");
                    int position = scanner.nextInt();
                    if (position < 1 || position > size + 1) { System.out.println("Invalid position."); break; }
                    System.out.print("Value: ");
                    int value = scanner.nextInt();
                    System.arraycopy(values, position - 1, values, position, size - position + 1);
                    values[position - 1] = value;
                    size++;
                    System.out.println("Element inserted successfully.");
                }
                case 3 -> {
                    System.out.print("Position (1-" + size + "): ");
                    int position = scanner.nextInt();
                    if (position < 1 || position > size) { System.out.println("Invalid position."); break; }
                    System.arraycopy(values, position, values, position - 1, size - position);
                    size--;
                    System.out.println("Element deleted successfully.");
                }
                case 4 -> {
                    System.out.print("Position (1-" + size + "): ");
                    int position = scanner.nextInt();
                    if (position < 1 || position > size) { System.out.println("Invalid position."); break; }
                    System.out.print("New value: ");
                    values[position - 1] = scanner.nextInt();
                    System.out.println("Element updated successfully.");
                }
                case 5 -> {
                    System.out.print("Value to search: ");
                    int value = scanner.nextInt();
                    int found = -1;
                    for (int index = 0; index < size; index++) if (values[index] == value) { found = index + 1; break; }
                    System.out.println(found == -1 ? "Value not found." : "Value found at position " + found + ".");
                }
                case 6, 7 -> {
                    Arrays.sort(values, 0, size);
                    if (choice == 7) for (int left = 0; left < size / 2; left++) { int right = size - left - 1; int temp = values[left]; values[left] = values[right]; values[right] = temp; }
                    System.out.println("Array sorted successfully.");
                }
                case 8 -> {
                    for (int left = 0; left < size / 2; left++) { int right = size - left - 1; int temp = values[left]; values[left] = values[right]; values[right] = temp; }
                    System.out.println("Array reversed successfully.");
                }
                case 9, 10, 11, 12, 13, 14 -> {
                    int maximum = values[0], minimum = values[0], sum = 0, even = 0;
                    for (int index = 0; index < size; index++) { maximum = Math.max(maximum, values[index]); minimum = Math.min(minimum, values[index]); sum += values[index]; if (values[index] % 2 == 0) even++; }
                    switch (choice) {
                        case 9 -> System.out.println("Maximum = " + maximum);
                        case 10 -> System.out.println("Minimum = " + minimum);
                        case 11 -> System.out.println("Sum = " + sum);
                        case 12 -> System.out.println("Average = " + (double) sum / size);
                        case 13 -> System.out.println("Even count = " + even);
                        case 14 -> System.out.println("Odd count = " + (size - even));
                    }
                }
                case 15 -> System.out.println("Bye Bye.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 15);
    }
}
