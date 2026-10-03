//class Logger {
//    private static  Logger instance;
//    private Logger(){
//
//    }
//
//    public Logger getInstance() {
//        if(instance == null) {
//            instance = new Logger();
//        }
//        return instance;
//    }
//    public void log(String message) {
//        System.out.println(message);
//    }
//}
//
//class SingletonPattern {
//    public static void main(String[] args) {
//        Logger l1 = Logger.getInstance();
//        Logger l2 = Logger.getInstance();
//        l1.log("User created");
//        l2.log("Payment successfull");
//        System.out.println(l1 == l2);
//    }
//}

import java.util.*;

class ConfigManager {
    private static ConfigManager instance;

    private Map<String, String> configurations;

    private ConfigManager() {
        configurations = new HashMap<>();
    }

    public static ConfigManager getInstance() {
        if(instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public void setConfigurations(String key, String value) {
        configurations.put(key,value);
    }

    public String get(String key) {
        return configurations.get(key);
    }
}

class SingletonPattern {
    public static void main(String[] args) {
        ConfigManager config = ConfigManager.getInstance();

        config.setConfigurations("dbUrl", "localhost:5432");
        config.setConfigurations("appName", "MyShop");
        config.setConfigurations("apiKey", "ABC123");

        ConfigManager con = ConfigManager.getInstance();
        System.out.println(con.get("dbUrl"));
        System.out.println(con.get("appName"));
        System.out.println(config2.get("apiKey"));

        System.out.println(config == config2);
    }
}