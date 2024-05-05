import fine.FineCalculator;

import java.util.Scanner;

/**
 * @author Anas Al-Halawani
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter return date, followed by the expected return date, in the format: d1 m1 y1 d2 m2 y2: ");
        String input = scanner.nextLine();
        FineCalculator.calculateFine(input);
    }
}