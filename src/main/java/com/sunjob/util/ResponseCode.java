package com.sunjob.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseCode {
    private String code;
    private Map<String, Object> object = new HashMap<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, Object> getObject() {
        return object;
    }

    public void setObject(Map<String, Object> object) {
        this.object = object;
    }

    public ResponseCode put(String key, Object value) {
        this.object.put(key, value);
        return this;
    }


    public static ResponseCode success() {
        ResponseCode rm = new ResponseCode();
        rm.setCode("200");
        return rm;
    }

    public static ResponseCode error() {
        ResponseCode rm = new ResponseCode();
        rm.setCode("400");
        return rm;
    }
}
