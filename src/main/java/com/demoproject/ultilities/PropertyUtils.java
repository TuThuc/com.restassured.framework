package com.demoproject.ultilities;

import org.aeonbits.owner.Config;
@Config.Sources({"file:./src/main/resources/environment/staging.properties"})
public interface PropertyUtils extends Config {
    @Key("BASE_URI")
    String getBaseURI();

    @Key("BASE_PATH")
    String getBasePath();
    @Key("USERNAME")
    String getUserName();
    @Key("PASSWORD")
    String getPassWord();
}
