package com.api_test.models;

import java.util.*;

public class ApiRespone {

    public static Map<String, Object> getResponse(int code,String message, Map<String,Object> data){
         Map<String, Object> response = new HashMap<>();

        response.put("code", code);
        response.put("message", message);
        response.put("data",data);

        return response;

    }

}
