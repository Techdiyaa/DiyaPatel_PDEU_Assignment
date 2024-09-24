import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Satellite {
    private static final Logger logger = LoggerFactory.getLogger(Satellite.class);

    private String orientation;
    private boolean solarPanelsActive;
    private int dataCollected;

    public Satellite() {
        // Initialize the satellite's default state
        this.orientation = "North";
        this.solarPanelsActive = false;  // Inactive initially
        this.dataCollected = 0;
        logger.info("Satellite initialized with default state.");
    }

    // Getter methods
    public String getOrientation() {
        return orientation;
    }

    public boolean isSolarPanelsActive() {
        return solarPanelsActive;
    }

    public int getDataCollected() {
        return dataCollected;
    }

    // Method to rotate the satellite
    public void rotate(String direction) {
        if (direction.equals("North") || direction.equals("South") || direction.equals("East") || direction.equals("West")) {
            this.orientation = direction;
            logger.info("Satellite rotated to {}", direction);
        } else {
            logger.warn("Invalid direction: {}", direction);
        }
    }

    // Methods to activate and deactivate solar panels
    public void activatePanels() {
        this.solarPanelsActive = true;
        logger.info("Solar panels activated.");
    }

    public void deactivatePanels() {
        this.solarPanelsActive = false;
        logger.info("Solar panels deactivated.");
    }

    // Method to collect data if solar panels are active
    public void collectData() {
        if (this.solarPanelsActive) {
            this.dataCollected += 10;
            logger.info("Data collected. Total data: {}", this.dataCollected);
        } else {
            logger.warn("Cannot collect data. Solar panels are inactive.");
        }
    }

    // Display current state of the satellite
    public void displayStatus() {
        logger.info("Satellite Status: Orientation={}, Solar Panels={}, Data Collected={}",
                this.orientation, this.solarPanelsActive ? "Active" : "Inactive", this.dataCollected);
        System.out.println("Satellite Status:");
        System.out.println("Orientation: " + this.orientation);
        System.out.println("Solar Panels: " + (this.solarPanelsActive ? "Active" : "Inactive"));
        System.out.println("Data Collected: " + this.dataCollected);
    }
}
