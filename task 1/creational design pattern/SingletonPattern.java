// Singleton Class
class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
        // private constructor
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Configuration Manager instance accessed!");
    }
}

// Main class to demonstrate Singleton Pattern
public class SingletonPattern {
    public static void main(String[] args) {
        ConfigurationManager manager1 = ConfigurationManager.getInstance();
        ConfigurationManager manager2 = ConfigurationManager.getInstance();

        // Both references should point to the same instance
        System.out.println(manager1 == manager2); // true

        manager1.showMessage();
    }
}
