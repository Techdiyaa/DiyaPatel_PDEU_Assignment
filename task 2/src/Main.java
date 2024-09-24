import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Satellite Command System started.");
        
        // Initialize Satellite and Command Executor
        Satellite satellite = new Satellite();
        CommandExecutor executor = new CommandExecutor(satellite);
        
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nEnter command (rotate [direction], activatePanels, deactivatePanels, collectData, exit): ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];
            
            switch (command) {
                case "rotate":
                    if (parts.length > 1) {
                        executor.executeCommand(command, parts[1]);
                    } else {
                        logger.warn("No direction provided for rotate command.");
                    }
                    break;

                case "activatePanels":
                case "deactivatePanels":
                case "collectData":
                    executor.executeCommand(command);
                    break;

                case "exit":
                    exit = true;
                    logger.info("Exiting Satellite Command System.");
                    break;

                default:
                    logger.warn("Unknown command: {}", command);
                    System.out.println("Unknown command.");
            }
        }
        
        scanner.close();
    }
}
