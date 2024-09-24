import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandExecutor {
    private static final Logger logger = LoggerFactory.getLogger(CommandExecutor.class);
    private final Satellite satellite;

    public CommandExecutor(Satellite satellite) {
        this.satellite = satellite;
    }

    // Method to execute a command
    public void executeCommand(String command, String... args) {
        switch (command) {
            case "rotate":
                if (args.length > 0) {
                    satellite.rotate(args[0]);
                } else {
                    logger.error("No direction provided for rotate command.");
                }
                break;

            case "activatePanels":
                satellite.activatePanels();
                break;

            case "deactivatePanels":
                satellite.deactivatePanels();
                break;

            case "collectData":
                satellite.collectData();
                break;

            default:
                logger.error("Invalid command: {}", command);
        }

        // Display the satellite status after each command
        satellite.displayStatus();
    }
}
