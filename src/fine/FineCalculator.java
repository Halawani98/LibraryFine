package fine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anas Al-Halawani
 */
public class FineCalculator {

    public static void calculateFine(String input) {
        String[] splitInput = input.split(" ");

        List<Integer> parsedDays = new ArrayList<>(Arrays.asList(Integer.parseInt(splitInput[0]), Integer.parseInt(splitInput[3])));
        List<Integer> parsedMonths = new ArrayList<>(Arrays.asList(Integer.parseInt(splitInput[1]), Integer.parseInt(splitInput[4])));
        List<Integer> parsedYears = new ArrayList<>(Arrays.asList(Integer.parseInt(splitInput[2]), Integer.parseInt(splitInput[5])));

        if (parsedDays.stream().anyMatch(day -> day > 31 || day < 1) ||
                parsedMonths.stream().anyMatch(month -> month > 12 || month < 1) ||
                parsedYears.stream().anyMatch(year -> year > 5000 || year < 1)) {
            System.out.println("Invalid input");
            return;
        }

        long fine = 0;

        if (parsedYears.get(1) < parsedYears.get(0)) {
            fine = 10000;
        } else if (parsedMonths.get(1) < parsedMonths.get(0) && parsedYears.get(0).equals(parsedYears.get(1))) {
            int monthsDiff = parsedMonths.get(0) - parsedMonths.get(1);
            while (monthsDiff > 0) {
                fine += 500;
                monthsDiff--;
            }
        } else if (parsedDays.get(1) < parsedDays.get(0) && parsedYears.get(0).equals(parsedYears.get(1)) && parsedMonths.get(0).equals(parsedMonths.get(1))) {
            int daysDiff = parsedDays.get(0) - parsedDays.get(1);
            while (daysDiff > 0) {
                fine += 15;
                daysDiff--;
            }
        } else {
            System.out.println("Invalid input");
            return;
        }

        System.out.println("The fine is: " + fine + " $");
    }
}
