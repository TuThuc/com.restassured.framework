package commons.globals;

import helpers.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;

public class ConfigsGlobal {
   private static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    public static String BASE_URI = configProperties.getBaseURI();
    public static String BASE_PATH = configProperties.getBasePath();
    public static String USER_NAME = configProperties.getUserName();
    public static String PASSWORD = configProperties.getPassWord();

}
