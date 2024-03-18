package commons.globals;

import lombok.Builder;
public enum StatusCode {
    CODE_200(200, "");

    CODE_201(201,"");

    CODE_400(400,"Missing required field: name ");

    CODE(401,"invalid access token");

    private final int code;
    private final String msg;

    StatusCode() {
        this.code = code;
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
    public String getCode() {
        return msg;
    }

}

