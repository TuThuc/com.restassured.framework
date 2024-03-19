package com.demoproject.globals;

import com.demoproject.ultilities.PropertyUtils;
import org.aeonbits.owner.ConfigFactory;

public class ConfigsGlobal {
   private static final PropertyUtils configProperties = ConfigFactory.create(PropertyUtils.class);
    public static String BASE_URI = configProperties.getBaseURI();
    public static String BASE_PATH = configProperties.getBasePath();
    public static String USER_NAME = configProperties.getUserName();
    public static String PASSWORD = configProperties.getPassWord();

}
