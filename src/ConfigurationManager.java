public class ConfigurationManager {
    private static ConfigurationManager instance;

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    // Database connection information
    // Integration details with external systems
    // Security parameters 
}
