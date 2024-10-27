package demo;

import java.util.Scanner;

public class Solution {
   
	public static int findTestPassedByEnv(AutonomousCar[] cars, String environment) {
        int totalTestsPassed = 0;
        boolean found = false;

        for (AutonomousCar car : cars) {
            if (car.getEnvironment().equalsIgnoreCase(environment)) {
                totalTestsPassed += car.getNoOfTestsPassed();
                found = true;
            }
        }
        return found ? totalTestsPassed : 0;
    }

    public static AutonomousCar updateCarGrade(AutonomousCar[] cars, String brand) {
        for (AutonomousCar car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                int rating = (car.getNoOfTestsPassed() * 100) / car.getNoOfTestsConducted();
                String grade = rating >= 80 ? "A1" : "B2";
                car.setGrade(grade);
                return car;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutonomousCar[] cars = new AutonomousCar[4];
        
        // Reading the AutonomousCar details
        for (int i = 0; i < 4; i++) {
            int carId = sc.nextInt();
            String brand = sc.next();
            int noOfTestsConducted = sc.nextInt();
            int noOfTestsPassed = sc.nextInt();
            String environment = sc.next();
            cars[i] = new AutonomousCar(carId, brand, noOfTestsConducted, noOfTestsPassed, environment);
        }
        
        String env = sc.next();    // Reading environment for findTestPassedByEnv
        String searchBrand = sc.next();  // Reading brand for updateCarGrade
        
        // Calling and printing result for findTestPassedByEnv
        int totalTestsPassed = findTestPassedByEnv(cars, env);
        if (totalTestsPassed > 0) {
            System.out.println(totalTestsPassed);
        } else {
            System.out.println("There are no tests passed in this particular environment");
        }
        
        // Calling and printing result for updateCarGrade
        AutonomousCar carWithGrade = updateCarGrade(cars, searchBrand);
        if (carWithGrade != null) {
            System.out.println(carWithGrade.getBrand() + "::" + carWithGrade.getGrade());
        } else {
            System.out.println("No Car is available with the specified brand");
        }
        
        sc.close();
}
}