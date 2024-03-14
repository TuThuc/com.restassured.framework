package helpers;

import org.aeonbits.owner.Config;
@Config.Sources({"file:./src/main/resources/environment/staging.properties"})
public interface ConfigProperties extends Config {
@Key("BASE_URI")
    String getBaseURI();
    @Key("BASE_PATH")
    String getBasePath();


}
