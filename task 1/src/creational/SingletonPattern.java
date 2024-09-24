package creational;

class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
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

public class SingletonPattern {
    public static void main(String[] args) {
        ConfigurationManager manager1 = ConfigurationManager.getInstance();
        ConfigurationManager manager2 = ConfigurationManager.getInstance();

        System.out.println(manager1 == manager2); 

        manager1.showMessage();
    }
}
