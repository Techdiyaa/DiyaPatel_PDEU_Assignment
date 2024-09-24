// import behavioral.ObserverPattern;
// import behavioral.StrategyPattern;
// import creational.SingletonPattern;
// import creational.FactoryPattern;
// import structural.AdapterPattern;
// import structural.CompositePattern;

// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int choice;

//         do {
//             System.out.println("Choose a design pattern to demonstrate:");
//             System.out.println("1: Observer Pattern");
//             System.out.println("2: Strategy Pattern");
//             System.out.println("3: Singleton Pattern");
//             System.out.println("4: Factory Pattern");
//             System.out.println("5: Adapter Pattern");
//             System.out.println("6: Composite Pattern");
//             System.out.println("0: Exit");

//             choice = scanner.nextInt(); 

//             switch (choice) {
//                 case 1:
//                     ObserverPattern.main(args);
//                     break;
//                 case 2:
//                     StrategyPattern.main(args);
//                     break;
//                 case 3:
//                     SingletonPattern.main(args);
//                     break;
//                 case 4:
//                     FactoryPattern.main(args);
//                     break;
//                 case 5:
//                     AdapterPattern.main(args);
//                     break;
//                 case 6:
//                     CompositePattern.main(args);
//                     break;
//                 case 0:
//                     System.out.println("Exiting...");
//                     break;  // Exit on 0
//                 default:
//                     System.out.println("Invalid choice. Please try again.");
//             }
//         } while (choice != 0);  
//         scanner.close();  
//     }
// }









import behavioral.ObserverPattern;
import behavioral.StrategyPattern;
import creational.SingletonPattern;
import creational.FactoryPattern;
import structural.AdapterPattern;
import structural.CompositePattern;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create scanner outside loop

        int choice;
        do {
            // Display the menu for pattern selection
            System.out.println("Choose a design pattern to demonstrate:");
            System.out.println("1: Observer Pattern");
            System.out.println("2: Strategy Pattern");
            System.out.println("3: Singleton Pattern");
            System.out.println("4: Factory Pattern");
            System.out.println("5: Adapter Pattern");
            System.out.println("6: Composite Pattern");
            System.out.println("0: Exit");

            // Input choice
            while (!scanner.hasNextInt()) {  // Check for valid integer input
                System.out.println("Please enter a valid number.");
                scanner.next();  // Clear invalid input
            }
            choice = scanner.nextInt();  // Read valid input

            // Handle pattern selection
            switch (choice) {
                case 1:
                    ObserverPattern.main(args);
                    break;
                case 2:
                    StrategyPattern.main(args);
                    break;
                case 3:
                    SingletonPattern.main(args);
                    break;
                case 4:
                    FactoryPattern.main(args);
                    break;
                case 5:
                    AdapterPattern.main(args);
                    break;
                case 6:
                    CompositePattern.main(args);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);  // Exit when choice is 0

        scanner.close();  // Close scanner after exit
    }
}
