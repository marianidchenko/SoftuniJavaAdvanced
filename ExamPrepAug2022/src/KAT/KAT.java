package KAT;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Queue
        ArrayDeque<Integer> licensePlates = new ArrayDeque<Integer>(Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        // Stack
        ArrayDeque<Integer> numberOfCars = new ArrayDeque<Integer>(Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        int numberOfDays = 0;
        int numberOfRegistered = 0;

        while (licensePlates.size() > 0 && numberOfCars.size() > 0) {
            numberOfDays ++;
            int dailyPlates = licensePlates.pop();
            int dailyCars = numberOfCars.removeLast();
            if (dailyPlates/2 > dailyCars) {
                numberOfRegistered += dailyCars;
                dailyPlates -= dailyCars * 2;
                licensePlates.offer(dailyPlates);
            } else if (dailyPlates/2 < dailyCars) {
                int registeredToday = dailyCars - (dailyCars - dailyPlates/2);
                numberOfRegistered += registeredToday;
                dailyCars -= registeredToday;
                numberOfCars.push(dailyCars);
            } else {
                numberOfRegistered += dailyCars;
            }
        }
        System.out.printf("%d cars were registered for %d days!\n", numberOfRegistered, numberOfDays);
        if (licensePlates.size() > 0) {
            int numOfLicensePlates = 0;
            for (int licensePlate: licensePlates) numOfLicensePlates += licensePlate;
            System.out.printf("%d license plates remain!\n", numOfLicensePlates);
        } else if (numberOfCars.size() > 0) {
            int totalCars = 0;
            for (int car: numberOfCars) totalCars += car;
            System.out.printf("%d cars remain without license plates!\n", totalCars);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT.KAT!");
        }
    }
}
