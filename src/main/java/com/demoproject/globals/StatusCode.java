package com.demoproject.globals;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusCode {
    CODE_200(200, "Success");

   //   CODE_201(201,"");

   // CODE_400(400,"Missing required field: name ");

   // CODE_401(401,"invalid access token");

    public final int code;
    public final String msg;


}

