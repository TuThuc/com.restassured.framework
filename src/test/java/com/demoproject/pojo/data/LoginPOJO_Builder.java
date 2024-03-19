package com.demoproject.pojo.data;

import com.demoproject.globals.ConfigsGlobal;
import com.demoproject.pojo.LoginPOJO;

public class LoginPOJO_Builder {
    public static LoginPOJO getDataLogin(){
        return LoginPOJO.builder()
                .username(ConfigsGlobal.USER_NAME)
                .password(ConfigsGlobal.PASSWORD)
                .build();
    }
}
