package pojo.data;

import commons.globals.ConfigsGlobal;
import pojo.LoginPOJO;

public class LoginPOJO_Builder {
    public static LoginPOJO getDataLogin(){
        return LoginPOJO.builder()
                .usermame(ConfigsGlobal.USER_NAME)
                .password(ConfigsGlobal.PASSWORD)
                .build();
    }
}
